/**
 * 
 */
package arduino.services.data;

import arduino.models.Acceleration;
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
	
	public void save(Acceleration acc){
		accjpa.save(acc);
	}
	
}