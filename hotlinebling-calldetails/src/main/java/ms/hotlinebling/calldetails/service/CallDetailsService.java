package ms.hotlinebling.calldetails.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import ms.hotlinebling.calldetails.dto.CallDetailsDTO;
import ms.hotlinebling.calldetails.entity.CallDetails;
import ms.hotlinebling.calldetails.repository.CallDetailsRepository;

@Service
public class CallDetailsService 
{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	CallDetailsRepository callDetailsRepo;
	
	public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo)
	{
		logger.info("Calldetails request for customer ()", phoneNo);
		
		List<CallDetails> callDetails = callDetailsRepo.findByCallFrom(phoneNo);
		
		List<CallDetailsDTO> callDetailsDTO = new ArrayList<>();
		
		for(CallDetails call : callDetails)
		{
			callDetailsDTO.add(CallDetailsDTO.valueOf(call));
		}
		
		logger.info("Calldetails for customer ()", callDetails);
		
		return callDetailsDTO;
	}
}
