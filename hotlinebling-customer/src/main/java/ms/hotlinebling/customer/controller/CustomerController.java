package ms.hotlinebling.customer.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ms.hotlinebling.customer.dto.CustomerDTO;
import ms.hotlinebling.customer.exception.CustomerException;
import ms.hotlinebling.customer.exception.ServiceDiscoveryException;
import ms.hotlinebling.customer.service.ControllerService;
import ms.hotlinebling.customer.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	Logger LOGGER = LogManager.getFormatterLogger(this.getClass());

	@Autowired
	ControllerService controllerService;

	@Autowired
	CustomerService customerService;
	

	/*** http://localhost:8200/customers ***/
	@GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerDTO> getAllCustomers() throws CustomerException
	{


		List<CustomerDTO> customers = customerService.getAllCustomers();

		LOGGER.info("Customers retrieved successfully from DB.");

		return customers;
	}

	/*** http://localhost:8200/customer/1 
	 * @throws ServiceDiscoveryException ***/
	@GetMapping(value = "/customer/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerById(@PathVariable String customer_id) throws CustomerException, ServiceDiscoveryException
	{
		CustomerDTO customerDTO = customerService.getCustomerById(Integer.parseInt(customer_id));

		controllerService.setCustomerPhone(customerDTO);
		controllerService.setCustomerPlan(customerDTO);

		LOGGER.info("Customer ${" + customerDTO.getId() + "} retrieved successfully from DB.");

		return customerDTO;
	}

	/*** http://localhost:8200/customers ***/
	@PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO postNewCustomer(@RequestBody CustomerDTO postCustomer) throws CustomerException, ServiceDiscoveryException
	{

		CustomerDTO customerDTO = customerService.postNewCustomer(postCustomer);

		controllerService.postNewCustomerPhone(customerDTO);
		controllerService.postNewCustomerPlan(customerDTO);

		LOGGER.info("Customer ${" + customerDTO.getId() + "} posted successfully to DB.");

		return customerDTO;
	}

	/***
	 * http://localhost:8200/customer/1
	 * 
	 * @throws CustomerException
	 ***/
	@PutMapping(value = "/customer/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO updateCustomerById(@PathVariable String customer_id, @RequestBody CustomerDTO updateCustomer) throws CustomerException 
	{

		CustomerDTO updatedCustomer;

		try {

			updatedCustomer = customerService.updateCustomerById(customer_id, updateCustomer);

			LOGGER.info("Customer ${" + updatedCustomer.getId() + "} updated successfully in DB.");

			return updatedCustomer;

		} catch (CustomerException exception) {

			LOGGER.error(exception.getMessage(), exception.getCause());

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
	public String deleteCustomerById(@PathVariable String customer_id) throws CustomerException 
	{

		try {
			customerService.deleteCustomerById(customer_id);
			String customerDeletedMsg = "Customer ${" + customer_id + "} deleted successfully from DB.";
			LOGGER.info(customerDeletedMsg);
			return customerDeletedMsg;

		} catch (CustomerException exception) {
			LOGGER.error(exception.getMessage(), exception.getCause());
			throw new CustomerException("\n\n Something went wrong: \n\n" + exception.getMessage(),
					exception.getCause());
		}

	}

	
}
