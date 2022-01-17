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
    
    public List<Calendar> findAllCalendars()  
    {

			List<Calendar> calendars;
			if( calendarRepo.count() != 0 )
			{
			    calendars = new ArrayList<>();
			    calendars = calendarRepo.findAll();
				return calendars;
			}
			else if (calendarRepo.count() == 0)
			{
//				throw new RepoCallerException("NO CALENDARS FOUND IN DB");
			}
			return null;

    }


    public Calendar postCalendar(CalendarDTO calendarDTO) 
    {
	Calendar newCal = Calendar.valueOf(calendarDTO);
	return calendarRepo.save(newCal);
    }
    public Calendar postCalendar(Calendar calendar) 
    {
	return calendarRepo.save(calendar);
    }

}
