package arduino.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import arduino.models.Acceleration;

public class AccelerationJPA {
	private EntityManager manager;
	private EntityTransaction tx;

	public AccelerationJPA() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistenceUnit");
		manager = factory.createEntityManager();

	}

	public void save(Acceleration acc) {
		tx = manager.getTransaction();
		tx.begin();
		try {
			manager.persist(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}

	//
	// private void listAll() {
	// List<Acceleration> resultList = manager.createQuery(
	// "Select a From Employee a", Acceleration.class).getResultList();
	// System.out.println("num of employess:" + resultList.size());
	// for (Acceleration next : resultList) {
	// System.out.println("next employee: " + next);
	// }
	// }

}