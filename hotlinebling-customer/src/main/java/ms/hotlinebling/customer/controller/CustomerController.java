package ms.hotlinebling.customer.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ms.hotlinebling.customer.dto.CustomerDTO;
import ms.hotlinebling.customer.dto.PhoneDTO;
import ms.hotlinebling.customer.dto.PlanDTO;
import ms.hotlinebling.customer.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController 
{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping(value = "/customers/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerDetailsById(@PathVariable int customer_id)
	{
		CustomerDTO customerDTO = customerService.getCustomerDetailsById(customer_id);
		
		List<ServiceInstance> planInstances = discoveryClient.getInstances("PLANMS");
		ServiceInstance planInstance = planInstances.get(0);
		URI planUri = planInstance.getUri();
		
		PlanDTO planDTO = new RestTemplate().getForObject(planUri +"/plan/" + customerDTO.getCurrentPlan().getPlanId(), PlanDTO.class);
		customerDTO.setCurrentPlan(planDTO);
		
		List<ServiceInstance> phoneInstances = discoveryClient.getInstances("PHONEMS");
		ServiceInstance phoneInstance = phoneInstances.get(0);
		URI phoneURI = phoneInstance.getUri();
		
		PhoneDTO phoneDTO = new RestTemplate().getForObject(phoneURI + "/phone/" + customerDTO.getCurrentPhone().getPhoneId(), PhoneDTO.class);
		customerDTO.setCurrentPhone(phoneDTO);
		
		return customerDTO;
	}
	/*
	 * http://localhost:8200/customers/1
	 */
}
