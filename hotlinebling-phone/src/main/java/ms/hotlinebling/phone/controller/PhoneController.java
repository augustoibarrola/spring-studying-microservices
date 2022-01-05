package ms.hotlinebling.phone.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ms.hotlinebling.phone.dto.PhoneDTO;
import ms.hotlinebling.phone.exception.PhoneException;
import ms.hotlinebling.phone.service.PhoneService;

@RestController
@CrossOrigin
public class PhoneController 
{
	
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	PhoneService phoneService;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	
	/*
	 * @URI http://localhost:8500/phones
	 * @return returns phone with same id as given {phoneId} path variable 
	 */
	@GetMapping(value="/phones", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PhoneDTO> getAllPhones() throws PhoneException
	{
		try
		{
			List<PhoneDTO> phoneDTOs = phoneService.getAllPhones();
			
			LOGGER.info("Phones retrieved successfully from DB.");
			
			return phoneDTOs;			
		}catch(PhoneException exception)
		{
			LOGGER.error(exception.getMessage(), exception.getCause());
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(),
					exception.getCause());
		}
		
 	}
	
	/*
	 * @URI http://localhost:8500/phones/{phoneId}
	 * @return returns phone with same id as given {phoneId} path variable 
	 */
	@GetMapping(value="/phone/{phoneId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public PhoneDTO getPhoneById(@PathVariable("phoneId") String phoneId) throws PhoneException
	{
		try 
		{
				
			PhoneDTO phoneDTO = phoneService.getPhoneById(phoneId);
			
			return phoneDTO;
		}catch(PhoneException exception)
		{
			LOGGER.error(exception.getMessage(), exception.getCause());
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(),
					exception.getCause());
		}
	}
	/*
	 * @URI http://localhost:8500/phones
	 * @return newly posted phone
	 */
	@PostMapping(value="/phones", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public PhoneDTO postNewPhone(@RequestBody PhoneDTO phoneDTO) throws PhoneException
	{
		try
		{
			PhoneDTO postedPhone = phoneService.postNewPhone(phoneDTO);
			
			return postedPhone;			
		}catch(PhoneException exception)
		{
			LOGGER.error(exception.getMessage(), exception.getCause());
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(),
					exception.getCause());
		}
	}

	@PutMapping(value="/phone/{phone_id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public PhoneDTO updatePhoneById(@PathVariable String phone_id, @RequestBody PhoneDTO updatePhone) throws PhoneException
	{
		try
		{
			PhoneDTO phoneDTO = phoneService.updatePhoneById(phone_id, updatePhone);
			
			return phoneDTO;
		}catch(PhoneException exception)
		{
			LOGGER.error(exception.getMessage(), exception.getCause());
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(),
					exception.getCause());
		}
	}
	
	@DeleteMapping(value="/phone/{phone_id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public String deletePhoneById(@PathVariable String phone_id) throws PhoneException
	{
		try
		{
			phoneService.deletePhoneById(phone_id);
			String phoneDeleteMsg = "Phone " + phone_id + " has been deleted.";
			LOGGER.info("Phone " + phone_id + " has been deleted.");
			return phoneDeleteMsg;
			
		}catch(PhoneException exception)
		{
			LOGGER.error(exception.getMessage(), exception.getCause());
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(),
					exception.getCause());
		}
	}
}
