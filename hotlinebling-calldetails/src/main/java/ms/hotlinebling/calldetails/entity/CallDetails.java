package ms.hotlinebling.calldetails.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CallDetails {
	
	@Id
	@GeneratedValue
	long call_id;
	@Column(nullable = false)
	long call_from;
	@Column(nullable = false)
	long call_to;
	@Column(nullable = false)
	Date call_on;
	@Column(nullable = false)
	int duration;
	
	public long getCall_id() {
		return call_id;
	}
	public void setCall_id(long call_id) {
		this.call_id = call_id;
	}
	public long getCall_from() {
		return call_from;
	}
	public void setCall_from(long call_from) {
		this.call_from = call_from;
	}
	public long getCall_to() {
		return call_to;
	}
	public void setCall_to(long call_to) {
		this.call_to = call_to;
	}
	public Date getCall_on() {
		return call_on;
	}
	public void setCall_on(Date call_on) {
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
 * QUESTION: What is the difference between
 * java.sql.Date and java.util.Date 
 */
