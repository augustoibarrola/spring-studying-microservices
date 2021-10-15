package ms.hotlinebling.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ms.hotlinebling.customer.dto.CustomerDTO;
import ms.hotlinebling.customer.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController 
{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(value = "/customers/{phone_number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerDetailsById(@PathVariable Long phone_number)
	{
		CustomerDTO customerDTO = customerService.getCustomerDetailsById(phone_number);
		
		return customerDTO;
	}
	/*
	 * http://localhost:8200/customers/303030
	 */
}
