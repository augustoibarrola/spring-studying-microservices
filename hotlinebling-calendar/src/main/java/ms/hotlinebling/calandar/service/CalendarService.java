package ms.hotlinebling.calandar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ms.hotlinebling.calandar.dto.CalendarDTO;
import ms.hotlinebling.calandar.entity.Calendar;
import ms.hotlinebling.calandar.repository.CalendarRepository;

@Service(value = "calendarService")
@Transactional
public class CalendarService 
{

	@Autowired
	CalendarRepository calendarRepository;
	@Autowired
	RepositoryCommunicator repoCaller;
	
	public List<CalendarDTO> getAllCalendars() {
	    List<CalendarDTO> calendars = repoCaller.findAllCalendars();
	    return calendars;
	}
	
	public CalendarDTO postNewCalendar(CalendarDTO calendarDTO) 
	{
	    CalendarDTO postedCalendar = repoCaller.postCalendar(calendarDTO);
	    return postedCalendar;
	}
	
	
	
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
