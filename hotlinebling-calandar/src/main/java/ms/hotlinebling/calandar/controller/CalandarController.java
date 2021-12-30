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

import ms.hotlinebling.calandar.dto.CalandarDTO;
import ms.hotlinebling.calandar.service.CalandarService;

@RestController
@CrossOrigin
@RefreshScope
public class CalandarController 
{

	@Autowired
	CalandarService calandarService;
	
	@Autowired
	DiscoveryClient discoveryClient; 
	
	@GetMapping(value = "/event/{event_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CalandarDTO getEventDetailsById(@PathVariable("event_id") int eventId)
	{
		CalandarDTO calandarDTO = calandarService.getCalandarDetails(eventId);
		
		return calandarDTO;
	}
	
	/*** http://localhost:8700/events ***/
	/*
		{
		    "customerId": 0,
		    "description": "",
		    "year": "",
		    "date": "YYYY-MM-DD", 
		    "time": "HH:MM:SS", 
		    "datetime": "YYYY-MM-DDTHH:MM:SS"
		}
	 */
	@PostMapping(value = "/events", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CalandarDTO postNewEvent(@RequestBody CalandarDTO postEvent)
	{
		CalandarDTO postedEvent = calandarService.postNewEvent(postEvent);
		
		return postedEvent;
	}
}
