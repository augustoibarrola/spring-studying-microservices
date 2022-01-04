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
import org.springframework.web.bind.annotation.DeleteMapping;
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
import ms.hotlinebling.customer.exception.CustomerException;
import ms.hotlinebling.customer.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CustomerService customerService;

	@Autowired
	DiscoveryClient discoveryClient;

	/*** http://localhost:8200/customers ***/
	@GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerDTO> getAllCustomers() {

		List<CustomerDTO> customers = customerService.getCustomers();
		logger.info("Customers retrieved successfully from DB.");

		return customers;
	}

	/*** http://localhost:8200/customer/1 ***/
	@GetMapping(value = "/customer/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerById(@PathVariable String customer_id) {
		CustomerDTO customerDTO = customerService.getCustomerById(Integer.parseInt(customer_id));

//		PhoneDTO phoneDTO = new RestTemplate().getForObject(
//				getPhoneURI() + "/phone/" + customerDTO.getCurrentPhone().getId(), 
//				PhoneDTO.class);
//		customerDTO.setCurrentPhone(phoneDTO);
//
//		PlanDTO planDTO = new RestTemplate().getForObject(
//				getPlanURI() +"/plan/" + customerDTO.getCurrentPlan().getId(), 
//				PlanDTO.class);
//		customerDTO.setCurrentPlan(planDTO);
//		

		logger.info("Customer ${" + customerDTO.getId() + "} retrieved successfully from DB.");

		return customerDTO;
	}

	/*** http://localhost:8200/customers ***/
	@PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO postNewCustomer(@RequestBody CustomerDTO postCustomer) {

		CustomerDTO postedCustomer = customerService.postNewCustomer(postCustomer);

//		PhoneDTO phoneDTO = new RestTemplate().postForObject(
//				getPhoneURI() + "/phones", 
//				postCustomer.getCurrentPhone(), 
//				PhoneDTO.class);
//		postedCustomer.setCurrentPhone(phoneDTO);
//		
//		PlanDTO planDTO = new RestTemplate().postForObject(
//				getPlanURI() + "/plans", 
//				postCustomer.getCurrentPlan(), 
//				PlanDTO.class);
//		postedCustomer.setCurrentPlan(planDTO);

		logger.info("Customer ${" + postedCustomer.getId() + "} posted successfully to DB.");

		return postedCustomer;
	}

	/***
	 * http://localhost:8200/customer/1
	 * 
	 * @throws CustomerException
	 ***/
	@PutMapping(value = "/customer/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO updateCustomerById(@PathVariable String customer_id, @RequestBody CustomerDTO updateCustomer)
			throws CustomerException {

		CustomerDTO updatedCustomer;
		
		try {
			
			updatedCustomer = customerService.updateCustomerById(customer_id, updateCustomer);
			
			logger.info("Customer ${" + updatedCustomer.getId() + "} updated successfully in DB.");
			
			return updatedCustomer;
			
		} catch (CustomerException exception) {
			
			logger.error(exception.getMessage(), exception.getCause());
			
			throw new CustomerException("\n\n Something went wrong: \n\n" + exception.getMessage(),
					exception.getCause());
		}

	}

	/***
	 * http://localhost:8200/customer/1
	 * 
	 * @throws CustomerException
	 ***/
	@DeleteMapping(value = "/customer/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCustomerById(@PathVariable String customer_id) throws CustomerException {

		try {
			customerService.deleteCustomerById(customer_id);
			String customerDeletedMsg = "Customer " + customer_id + " has been deleted.";
			logger.info("Customer ${" + customer_id + "} deleted successfully from DB.");
			return customerDeletedMsg;

		} catch (CustomerException exception) {
			logger.error(exception.getMessage(), exception.getCause());
			throw new CustomerException("\n\n Something went wrong: \n\n" + exception.getMessage(),
					exception.getCause());
		}

	}

	/*
	 * Helper Methods
	 */

	/*
	 * @return uri for phone microservice instance
	 */
	public URI getPhoneURI() {
		List<ServiceInstance> phoneInstances = discoveryClient.getInstances("PhoneMS");
		ServiceInstance phoneInstance = phoneInstances.get(0);
		return phoneInstance.getUri();
	}

	/*
	 * @return uri for plan microservice instance
	 */
	public URI getPlanURI() {
		List<ServiceInstance> planInstances = discoveryClient.getInstances("PlanMS");
		ServiceInstance planInstance = planInstances.get(0);
		return planInstance.getUri();
	}

}
