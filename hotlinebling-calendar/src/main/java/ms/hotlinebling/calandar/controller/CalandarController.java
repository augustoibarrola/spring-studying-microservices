package ms.hotlinebling.calandar.controller;

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
import ms.hotlinebling.calandar.service.CalendarService;

@RestController
@CrossOrigin
@RefreshScope
public class CalandarController 
{

	@Autowired
	CalendarService calendarService;
	
	@Autowired
	DiscoveryClient discoveryClient; 
	
	@GetMapping(value = "/event/{event_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CalendarDTO getEventDetailsById(@PathVariable("event_id") int eventId)
	{
		CalendarDTO calendarDTO = calendarService.getCalandarDetails(eventId);
		
		return calendarDTO;
	}
	
//	@PostMapping(value="/calendar", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public CalendarDTO
	
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
