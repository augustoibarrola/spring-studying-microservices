package ms.hotlinebling.calldetails.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ms.hotlinebling.calldetails.dto.CallDetailsDTO;
import ms.hotlinebling.calldetails.service.CallDetailsService;

@RestController
@CrossOrigin
public class CallDetailsController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CallDetailsService callDetailsService;
	
	@GetMapping(value = "/customers/{phoneNo}/calldetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo)
	{
		logger.info("Calldetails request for customer ()", phoneNo);
		
		return callDetailsService.getCustomerCallDetails(phoneNo);
	}
	/*
	 * http://localhost:8100/customers/303030/calldetails
	 */
}
