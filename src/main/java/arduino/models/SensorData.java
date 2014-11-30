/**
 * 
 */
package arduino.models;

import java.util.Map;

/**
 * @author Serhat CAN
 *
 *
 */

public interface SensorData {

	/**
	 * @Description: Gets the class name so that it can be used in Training's
	 *               sensorData as Identifier
	 * 
	 */
	public String getClassIdentifier();

	/**
	 * @Description: Returns the sensor's values as key value
	 * 
	 * @return Map<String(field's name), String(field's value>
	 */
	public Map<String, String> getSensorData();

}
