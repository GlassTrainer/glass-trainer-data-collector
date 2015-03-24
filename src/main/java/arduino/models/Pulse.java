/**
 * 
 */
package arduino.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Serhat CAN
 *
 */

@Entity
public class Pulse implements SensorData, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	User user;

	@Column(nullable = false)
	private String rate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, updatable = false)
	private Date created;

	public Pulse(String rate) {
		this.rate = rate;
	}
	
	public Pulse(User user, String rate) {
		this.user = user;
		this.rate = rate;
	}

	// Getters and Setters

	public Date getTime() {
		return created;
	}

	@PrePersist
	protected void setTime() {
		created = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	@Override
	public String getClassIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getSensorData() {
		// TODO Auto-generated method stub
		return null;
	}

}
