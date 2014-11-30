/**
 * 
 */
package arduino.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Serhat CAN
 *
 */

@Entity
public class Trainer {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 25)
	private String fname;
	
	@Column(nullable = false, length = 25)
	private String lname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
