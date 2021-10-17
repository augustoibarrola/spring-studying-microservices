package ms.hotlinebling.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ms.hotlinebling.customer.dto.CustomerDTO;
import ms.hotlinebling.customer.dto.PlanDTO;
import ms.hotlinebling.customer.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController 
{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(value = "/customers/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerDetailsById(@PathVariable int customer_id)
	{
		CustomerDTO customerDTO = customerService.getCustomerDetailsById(customer_id);
		
		PlanDTO planDTO = new RestTemplate().getForObject("http://localhost:8400/plan/" + customerDTO.getCurrentPlan().getPlanId(), PlanDTO.class);
		customerDTO.setCurrentPlan(planDTO);
		return customerDTO;
	}
	/*
	 * http://localhost:8200/customers/1
	 */
}
