package ms.hotlinebling.calandar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.hotlinebling.calandar.dto.CalendarDTO;
import ms.hotlinebling.calandar.entity.Calendar;
import ms.hotlinebling.calandar.repository.CalendarRepository;

@Service
public class CalendarService 
{

	@Autowired
	CalendarRepository calendarRepository;
	
	public CalendarDTO getCalandarDetails(int eventId)
	{
		Calendar calendar = calendarRepository.getById(eventId);
		
		CalendarDTO calendarDTO = CalendarDTO.valueOf(calendar);
		
		return calendarDTO;
	}

	
	public CalendarDTO postNewEvent(CalendarDTO postEvent) {
		
		Calendar event = calendarRepository.save(Calendar.valueOf(postEvent));
		
		CalendarDTO postedEvent = CalendarDTO.valueOf(event);
		
		return postedEvent;
	}

	
}
