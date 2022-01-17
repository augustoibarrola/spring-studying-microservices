package ms.hotlinebling.calandar.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import ms.hotlinebling.calandar.entity.Calendar;
public class CalendarDTO 
{
	private String name;
	private Integer calendarOwner;
	
	
	public String getName() {
	    return name;
	}


	public void setName(String name) {
	    this.name = name;
	}


	public Integer getCalendarOwner() {
	    return calendarOwner;
	}


	public void setCalendarOwner(Integer calendarOwner) {
	    this.calendarOwner = calendarOwner;
	}


	public static CalendarDTO valueOf(Calendar calendar) {
		
		CalendarDTO calendarDTO = new CalendarDTO();
		
		calendarDTO.setName(calendar.getName());
		calendarDTO.setCalendarOwner(calendar.getCalendarOwner());
		
		return calendarDTO;
	}

}
