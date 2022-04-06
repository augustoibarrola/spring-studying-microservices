package ms.hotlinebling.calandar.dto;

import java.util.ArrayList;
import java.util.List;

import ms.hotlinebling.calandar.entity.Calendar;
public class CalendarDTO 
{
	private String name;
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


	public static CalendarDTO valueOf(Calendar calendar) 
	{
		
		CalendarDTO calendarDTO = new CalendarDTO();
		
		calendarDTO.setName(calendar.getName());
		calendarDTO.setCalendarOwner(calendar.getCalendarOwner());
		
		return calendarDTO;
	}


	public static List<CalendarDTO> valueOf(List<Calendar> calendars) 
	{
	    CalendarDTO calDTO;
	    List<CalendarDTO> calendarDTOs = new ArrayList<>();
	    for(Calendar cal : calendars)
	    {
		calDTO = CalendarDTO.valueOf(cal);
		calendarDTOs.add(calDTO);
	    }
	    
	    return calendarDTOs;
	}

}
