package arduino.services;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import arduino.entity.*;
import arduino.persistence.DataParserPersistence;

/**
 * @author Serhat CAN
 *
 */
public class DataParser {

	private DataParserPersistence persistence;
	private Training training;
	private User user;

	// cx:-0.059,cy:0.062,cz:0.994,p:85      pulse optional
	// cx:-0.056,cy:0.066,cz:0.998
	String data;

	public DataParser(String trainingName) {
		persistence = new DataParserPersistence();
		user = persistence.getUser(1l);
		training = new Training(user, trainingName);
		training.setStartTime(Date.from(Instant.now()));
		training.setEndTime(Date.from(Instant.now()));
	}

	public void setData(String data) {
		this.data = data;
	}

	private void parseAndSave(Map<String, String> values) {

		String params[] = data.split(Delimiters.comma);

		for (int i = 0; i < params.length; i++) {
			String cvalues[] = params[i].split(Delimiters.colon);
			values.put(cvalues[0], cvalues[1]);
		}

		Acceleration acc = new Acceleration(values.get("cx"), values.get("cy"),
				values.get("cz"));

		Pulse pulse = null;
		if(values.get("p") != null) {
			pulse = new Pulse(values.get("p"));
		}
		persistence.save(training, acc, pulse);
	}

	public void printRawData() {
		System.out.println(data);
	}

	public void parseData() {
		Map<String, String> values = new HashMap<String, String>();
		parseAndSave(values);
		Set<String> keys = values.keySet();

		for (String key : keys) {
			System.out.println("Key:" + key + " Value:" + values.get(key));
			System.out.println();
		}
	}
}
