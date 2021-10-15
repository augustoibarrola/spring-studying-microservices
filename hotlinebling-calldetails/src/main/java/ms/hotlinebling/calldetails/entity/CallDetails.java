package ms.hotlinebling.calldetails.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CallDetails")
public class CallDetails {

	@Id
	@GeneratedValue
	long callId;
	@Column(nullable = false)
	long callFrom;
	@Column(nullable = false)
	long callTo;
	@Column(nullable = false)
	Date call_on;
	@Column(nullable = false)
	int duration;

	public long getCallId() {
		return callId;
	}

	public void setCallId(long call_id) {
		this.callId = call_id;
	}

	public long getCallFrom() {
		return callFrom;
	}

	public void setCallFrom(long call_from) {
		this.callFrom = call_from;
	}

	public long getCallTo() {
		return callTo;
	}

	public void setCallTo(long call_to) {
		this.callTo = call_to;
	}

	public Date getCallOn() {
		return call_on;
	}

	public void setCallOn(Date call_on) {
		this.call_on = call_on;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}

/*
 * QUESTION: What is the difference between java.sql.Date and java.util.Date
 */
