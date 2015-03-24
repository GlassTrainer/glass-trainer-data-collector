package arduino.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import arduino.models.Acceleration;
import arduino.models.Pulse;

public class AccelerationJPA {
	private EntityManager manager;
	private EntityTransaction tx;

	public AccelerationJPA() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistenceUnit");
		manager = factory.createEntityManager();

	}

	public void save(Acceleration acc, Pulse pulse) {
		tx = manager.getTransaction();
		tx.begin();
		try {
			manager.persist(acc);

			if(pulse != null) {
				manager.persist(pulse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

}