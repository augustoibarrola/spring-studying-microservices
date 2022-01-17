package ms.hotlinebling.calandar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ms.hotlinebling.calandar.dto.CalendarDTO;
import ms.hotlinebling.calandar.exception.CalendarException;
import ms.hotlinebling.calandar.exception.RepoCallerException;
import ms.hotlinebling.calandar.service.CalendarService;

@RestController
@CrossOrigin
public class CalendarController 
{

	@Autowired
	CalendarService calendarService;
	
	@Autowired
	DiscoveryClient discoveryClient; 
	
	// http://localhost:8700/events 
	@GetMapping(value = "/calendars", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CalendarDTO> getAllCalendars()
	{
		List<CalendarDTO> calendars = calendarService.getAllCalendars();
		
		return calendars;
	}
	// http://localhost:8700/calendars 
	@PostMapping(value = "/calendars", produces = MediaType.APPLICATION_JSON_VALUE)
	public CalendarDTO postNewCalendar(@RequestBody CalendarDTO postCalendar)
	{
		CalendarDTO calendar = calendarService.postNewCalendar(postCalendar);
		
		return calendar;
	}
	
	
	
//	@GetMapping(value = "/calendar/events", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<EventDTO> getAllCalendarEvents(@PathVariable("calendar_id") int eventId)
//	{
//		CalendarDTO calendarDTO = calendarService.getCalandarDetails(eventId);
//		
//		return calendarDTO;
//	}
	
//	@PostMapping(value="/calendar", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public CalendarDTO postNewCalendar(@RequestBody CalendarDTO newCalendar) throws CalendarException, RepoCallerException
//	{
//		try
//		{
//		    
//		}
//        		catch(CalendarException exception)
//        		{
//        		    throw new CalendarException(exception.getMessage(), exception.getCause());
//        		}
//        		catch(RepoCallerException exception)
//        		{
//        		    throw new RepoCallerException(exception.getMessage(), exception.getCause());
//        		}
//	}
//	
	/*** http://localhost:8700/events ***/
	/*
		{

		}
	 */
	@PostMapping(value = "/events", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CalendarDTO postNewEvent(@RequestBody CalendarDTO postEvent)
	{
		CalendarDTO postedEvent = calendarService.postNewEvent(postEvent);
		
		return postedEvent;
	}
}
