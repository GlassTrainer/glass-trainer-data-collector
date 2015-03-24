/**
 * 
 */
package arduino.services.data;

import arduino.models.Acceleration;
import arduino.models.Pulse;
import arduino.persistence.AccelerationJPA;

/**
 * @author Serhat CAN
 *
 */
public class AccelerationService {

	private AccelerationJPA accjpa;
	
	public AccelerationService(){
		accjpa = new AccelerationJPA();
	}
	
	public void save(Acceleration acc, Pulse pulse){
		accjpa.save(acc, pulse);
	}
	
}