/**
 * 
 */
package arduino.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Serhat CAN
 *
 */

@Entity
public class Training {

	@Id
	@GeneratedValue
	private Long id;

	private String type;

	private String note;

	@OneToOne
	private Athlete athlete;

	@OneToOne
	private Trainer trainer;

	/**
	 * TODO: there has to be some kind of data keeper
	 */

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startTime", nullable = false, updatable = false)
	private Date start;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endTime", nullable = false, updatable = false)
	private Date end;

	// methods

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartTime() {
		return start;
	}

	@PrePersist
	protected void setStartTime() {
		start = new Date();
	}

	public Date getEndTime() {
		return end;
	}

	@PostPersist
	protected void setEndTime() {
		end = new Date();
	}

}
