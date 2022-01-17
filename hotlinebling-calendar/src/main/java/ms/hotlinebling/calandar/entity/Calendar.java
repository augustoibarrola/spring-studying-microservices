package ms.hotlinebling.calandar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ms.hotlinebling.calandar.dto.CalendarDTO;

@Entity
@Table(name = "Event")
public class Calendar 
{
	
	@Id
	@Column(name="name")
	private String name;
	@Column(name="calendarOwner")
	private Integer calendarOwner;
	
	public String getName() 
	{
	    return name;
	}

	public void setName(String name) 
	{
	    this.name = name;
	}

	public Integer getCalendarOwner() 
	{
	    return calendarOwner;
	}

	public void setCalendarOwner(Integer calendarOwner) 
	{
	    this.calendarOwner = calendarOwner;
	}

	public static Calendar valueOf(CalendarDTO postCalendar) 
	{

		Calendar calendar = new Calendar();
		
		calendar.setName(postCalendar.getName());
		calendar.setCalendarOwner(postCalendar.getCalendarOwner());
		
		return calendar;
	}
}
