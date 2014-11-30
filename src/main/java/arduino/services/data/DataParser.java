package arduino.services.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import arduino.models.Acceleration;
import arduino.models.Delimiters;

/**
 * @author Serhat CAN
 *
 */
public class DataParser {

	private AccelerationService accService;

	// cx:-0.059-cy:0.062-cz:0.994
	// cx:-0.056-cy:0.066-cz:0.998
	String data;

	public DataParser() {
		accService = new AccelerationService();
	}

	public void setData(String data) {
		this.data = data;
	}

	private Map<String, String> parseAndSave() {
		Map<String, String> values = new HashMap<String, String>();
		String params[] = data.split(Delimiters.comma);

		for (int i = 0; i < params.length; i++) {
			String cvalues[] = params[i].split(Delimiters.colon);
			values.put(cvalues[0], cvalues[1]);
		}

		Acceleration acc = new Acceleration(values.get("cx"), values.get("cy"),
				values.get("cz"));

		accService.save(acc);

		return values;
	}

	public void printRawData() {
		System.out.println(data);
	}

	public void parseData() {
		HashMap<String, String> values = (HashMap<String, String>) parseAndSave();
		Set<String> keys = values.keySet();

		for (String key : keys) {
			System.out.println("Key:" + key + " Value:" + values.get(key));
			System.out.println();
		}
	}
}
