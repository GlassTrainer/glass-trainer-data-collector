package arduino.persistence;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import arduino.entity.Acceleration;
import arduino.entity.Pulse;
import arduino.entity.Training;
import arduino.entity.User;

import java.util.List;

public class DataParserPersistence {
	static final String queryGetTrainingByName = "Select t From Training t where t.name=:name";

	private EntityManager manager;
	private EntityTransaction tx;

	public DataParserPersistence() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistenceUnit");
		manager = factory.createEntityManager();

	}

	public void save(Training training, Acceleration acc, Pulse pulse) {
		tx = manager.getTransaction();
		tx.begin();

		 List<Training> training1 = manager.createQuery(queryGetTrainingByName, Training.class)
				.setParameter("name", training.getName())
				.getResultList();

		try {
			if(training1.size() == 0) {
				manager.persist(training);
			} else {
				training = training1.get(0);
			}
			acc.setTraining(training);
			manager.persist(acc);
			if(pulse != null) {
				pulse.setTraining(training);
				manager.persist(pulse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	public User getUser(Long id) {
		return manager.find(User.class, id);
	}

}