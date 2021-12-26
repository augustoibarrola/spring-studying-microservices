package ms.hotlinebling.customer.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ms.hotlinebling.customer.dto.CustomerDTO;
import ms.hotlinebling.customer.dto.PhoneDTO;
import ms.hotlinebling.customer.dto.PlanDTO;
import ms.hotlinebling.customer.service.CustomerService;

@RestController
@CrossOrigin
@RefreshScope
public class CustomerController 
{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	/***	http://localhost:8200/customers	***/
	@GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerDTO> getCustomers()
	{
		List<CustomerDTO> customers = customerService.getCustomers();
		
		return customers;
	}
	
	/***	http://localhost:8200/customer/1	***/
	@GetMapping(value = "/customer/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerDetailsById(@PathVariable String customer_id)
	{
		CustomerDTO customerDTO = customerService.getCustomerDetailsById(Integer.parseInt(customer_id));
		
		List<ServiceInstance> planInstances = discoveryClient.getInstances("PlanMS");
		ServiceInstance planInstance = planInstances.get(0);
		URI planUri = planInstance.getUri();
		
		PlanDTO planDTO = new RestTemplate().getForObject(planUri +"/plan/" + customerDTO.getCurrentPlan().getId(), PlanDTO.class);
		customerDTO.setCurrentPlan(planDTO);
		
		List<ServiceInstance> phoneInstances = discoveryClient.getInstances("PhoneMS");
		ServiceInstance phoneInstance = phoneInstances.get(0);
		URI phoneURI = phoneInstance.getUri();
		
		PhoneDTO phoneDTO = new RestTemplate().getForObject(phoneURI + "/phone/" + customerDTO.getCurrentPhone().getId(), PhoneDTO.class);
		customerDTO.setCurrentPhone(phoneDTO);
		
		return customerDTO;
	}
	
	/***	http://localhost:8200/customers	***/
	@PostMapping(value = "/customers",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO postNewCustomer(@RequestBody CustomerDTO postCustomer)
	{
		
		CustomerDTO postedCustomer = customerService.postNewCustomer(postCustomer);
		
		PhoneDTO phoneDTO = new RestTemplate().postForObject(
				getPhoneURI() + "/phones", 
				postCustomer.getCurrentPhone(), 
				PhoneDTO.class);
		postedCustomer.setCurrentPhone(phoneDTO);
		
		PlanDTO planDTO = new RestTemplate().postForObject(
				getPlanURI() + "/plans", 
				postCustomer.getCurrentPlan(), 
				PlanDTO.class);
		postedCustomer.setCurrentPlan(planDTO);
		
		return postedCustomer;
	}
	
	/***	http://localhost:8200/customer/1	***/
	@PutMapping(value="/customer/{customer_id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO updateCustomerDetailsById(@PathVariable String customer_id, @RequestBody CustomerDTO updateCustomer) 
	{
		System.out.print("\n\n CONTROLLER HIT \n\n");
		System.out.println(updateCustomer.toString());
		System.out.println(updateCustomer.getFirstName() + "\n\n");
		System.out.println(updateCustomer.getMiddleName() + "\n\n");
		System.out.println(updateCustomer.getLastName() + "\n\n");
		
		CustomerDTO updatedCustomer = customerService.updateCustomerById(Integer.parseInt(customer_id), updateCustomer);
		
		System.out.print("\n\n UPDATED CUSTOMER RETURNED \n\n");
		System.out.println(updatedCustomer.toString());
		System.out.println(updatedCustomer.getFirstName() + "\n\n");
		System.out.println(updatedCustomer.getMiddleName() + "\n\n");
		System.out.println(updatedCustomer.getLastName() + "\n\n");
		System.out.println(updatedCustomer.toString());
		return updatedCustomer;
	}
	
	
	/*
	 * Helper Methods
	 */
	
	/*
	 * @return uri for phone microservice instance
	 */
	public URI getPhoneURI() 
	{
		List<ServiceInstance> phoneInstances = discoveryClient.getInstances("PhoneMS");
		ServiceInstance phoneInstance = phoneInstances.get(0);
		return phoneInstance.getUri();
	}
	
	/*
	 * @return uri for plan microservice instance
	 */
	public URI getPlanURI() 
	{
		List<ServiceInstance> planInstances = discoveryClient.getInstances("PlanMS");
		ServiceInstance planInstance = planInstances.get(0);
		return planInstance.getUri();
	}
	
	
}
