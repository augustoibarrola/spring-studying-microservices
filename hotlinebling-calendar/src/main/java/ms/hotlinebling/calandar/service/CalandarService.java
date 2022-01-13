package ms.hotlinebling.calandar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.hotlinebling.calandar.dto.CalandarDTO;
import ms.hotlinebling.calandar.entity.Calandar;
import ms.hotlinebling.calandar.repository.CalandarRepository;

@Service
public class CalandarService 
{

	@Autowired
	CalandarRepository calandarRepository;
	
	public CalandarDTO getCalandarDetails(int eventId)
	{
		Calandar calandar = calandarRepository.getById(eventId);
		
		CalandarDTO calandarDTO = CalandarDTO.valueOf(calandar);
		
		return calandarDTO;
	}

	
	public CalandarDTO postNewEvent(CalandarDTO postEvent) {
		
		Calandar event = calandarRepository.save(Calandar.valueOf(postEvent));
		
		CalandarDTO postedEvent = CalandarDTO.valueOf(event);
		
		return postedEvent;
	}

	
}
