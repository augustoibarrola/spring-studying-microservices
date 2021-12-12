package ms.hotlinebling.phone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import ms.hotlinebling.phone.dto.PhoneDTO;
import ms.hotlinebling.phone.service.PhoneService;

@RestController
@CrossOrigin
@RefreshScope
public class PhoneController 
{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	PhoneService phoneService;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	/*
	 * @URI http://localhost:8500/phones/{phoneId}
	 * @return phone with id same as given phoneId
	 */
	@GetMapping(value="/phones/{phoneId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public PhoneDTO getPhoneDetailsById(@PathVariable("phoneId") int phoneId)
	{
		PhoneDTO phoneDTO = phoneService.getCustomerPhone(phoneId);
		
		return phoneDTO;
	}
	/*
	 * @URI http://localhost:8500/phones
	 * @return newly posted phone
	 */
	@PostMapping(value="/phones", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public PhoneDTO postNewPhone(@RequestBody PhoneDTO phoneDTO)
	{
		PhoneDTO postedPhone = phoneService.postNewPhone(phoneDTO);
		
		return postedPhone;
	}

}
