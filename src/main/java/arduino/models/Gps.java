/**
 * 
 */
package arduino.models;

import java.io.Serializable;
import java.sql.Time;
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
public class Gps implements SensorData, Serializable {

	@Id
	@GeneratedValue
	private Long id;

	/*
	 * This is the current time coming from GPS
	 */
	private Time gpsTime;

	@Column(nullable = false, precision = 6)
	private Double latitude;

	@Column(nullable = false, precision = 6)
	private Double longitude;

	@ManyToOne
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, updatable = false)
	private Date created;

	public Gps() {
	}

	public Gps(User user, Double latitude, Double longitude) {
		this.user = user;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Gps(User user, Double latitude, Double longitude, Time gpsTime) {
		this.user = user;
		this.latitude = latitude;
		this.longitude = longitude;
		this.gpsTime = gpsTime;
	}

	// Getters and Setters

	public Date getTime() {
		return created;
	}

	@PrePersist
	protected void setTime() {
		created = new Date();
	}

	public Time getGpsTime() {
		return gpsTime;
	}

	public void setTime(Time gpsTime) {
		this.gpsTime = gpsTime;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
