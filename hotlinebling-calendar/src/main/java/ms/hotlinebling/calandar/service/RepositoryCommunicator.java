package ms.hotlinebling.calandar.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ms.hotlinebling.calandar.dto.CalendarDTO;
import ms.hotlinebling.calandar.entity.Calendar;
import ms.hotlinebling.calandar.exception.RepoCallerException;
import ms.hotlinebling.calandar.repository.CalendarRepository;

@Service(value = "repoCaller")
@Transactional
public class RepositoryCommunicator 
{
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CalendarRepository calendarRepo;
    
    public List<CalendarDTO> findAllCalendars()  
    {
	List<Calendar> calendars;
	if( calendarRepo.count() != 0 )
	{
	    calendars = new ArrayList<>();
	    calendars = calendarRepo.findAll();
	    List<CalendarDTO> calendarDTOs = CalendarDTO.valueOf(calendars);
	    return calendarDTOs;
	}
	else if (calendarRepo.count() == 0)
	{
//				throw new RepoCallerException("NO CALENDARS FOUND IN DB");
	}
	return null;

    }


    public CalendarDTO postCalendar(CalendarDTO calendarDTO) 
    {
	Calendar newCal = Calendar.valueOf(calendarDTO);
	newCal = calendarRepo.save(newCal);
	calendarDTO = CalendarDTO.valueOf(newCal);
	return calendarDTO;
    }
    
    public CalendarDTO postCalendar(Calendar calendar) 
    {
	calendar = calendarRepo.save(calendar);
	CalendarDTO postedCalendar = CalendarDTO.valueOf(calendar);
	return postedCalendar;
    }

}
