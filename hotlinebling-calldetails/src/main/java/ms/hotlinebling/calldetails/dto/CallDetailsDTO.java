package ms.hotlinebling.calldetails.dto;

import java.sql.Date;

import ms.hotlinebling.calldetails.entity.CallDetails;

public class CallDetailsDTO {
	
	long call_from;
	
	long call_to;
	
	Date call_on;
	
	int duration;
	
	public CallDetailsDTO()
	{
		super();
	}
	
	public CallDetailsDTO(long call_from, long call_to, Date call_on, int duration)
	{
		this();
		this.call_from = call_from;
		this.call_to = call_to;
		this.call_on = call_on;
		this.duration= duration;
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
	
	public static CallDetailsDTO valueOf(CallDetails callDetails)
	{
		CallDetailsDTO callDetailsDTO = new CallDetailsDTO();
		
		callDetailsDTO.setCall_from(callDetails.getCallFrom());
		callDetailsDTO.setCall_to(callDetails.getCallTo());
		callDetailsDTO.setCall_on(callDetails.getCallOn());
		callDetailsDTO.setDuration(callDetails.getDuration());
		
		return callDetailsDTO;
	}

}



/*
 * QUESTION: What is the difference between
 * java.sql.Date and java.util.Date 
 */
