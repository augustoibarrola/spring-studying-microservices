package ms.hotlinebling.phone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ms.hotlinebling.phone.dto.PhoneDTO;
import ms.hotlinebling.phone.service.PhoneService;

@RestController
@CrossOrigin
public class PhoneController 
{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	PhoneService phoneService;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping(value="/phone/{phone_id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public PhoneDTO getPhoneDetailsById(@PathVariable("phone_id") int phoneId)
	{
		PhoneDTO phoneDTO = phoneService.getCustomerPhone(phoneId);
		
		return phoneDTO;
	}
	/*
	 * http://localhost:8500/phone/2
	 */

}
