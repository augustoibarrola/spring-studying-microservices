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
import ms.hotlinebling.customer.exception.RepoCallerException;
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
	

	/*** http://localhost:8200/customers 
	 * @throws CustomerException 
	 * @throws RepoCallerException ***/
	@GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerDTO> getAllCustomers() throws CustomerException, RepoCallerException
	{

		try 
		{
			List<CustomerDTO> customers = customerService.getAllCustomers();
			
			LOGGER.info("Customers retrieved successfully from DB.");
			
			return customers;			
		}
		catch(CustomerException exception)
		{
			throw new CustomerException(exception.getMessage(), exception.getCause());
		} catch (RepoCallerException exception) {

			throw new RepoCallerException(exception.getMessage(), exception.getCause());
		}

	}

	/*** http://localhost:8200/customer/1 
	 * @throws CustomerException 
	 * @throws RepoCallerException 
	 * @throws ServiceDiscoveryException 
	 * @throws  ***/
	@GetMapping(value = "/customer/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerById(@PathVariable String customer_id) throws CustomerException, RepoCallerException, ServiceDiscoveryException  
	{
		try 
		{
			CustomerDTO customerDTO;
			customerDTO = customerService.getCustomerById(Integer.parseInt(customer_id));
			if(customerDTO.getCurrentPhone()!=null)controllerService.setCustomerPhone(customerDTO);
			if(customerDTO.getCurrentPlan()!=null)controllerService.setCustomerPlan(customerDTO);
			
			LOGGER.info("Customer ${" + customerDTO.getId() + "} retrieved successfully from DB.");
			
			return customerDTO;

		} 
			catch (CustomerException exception) 
			{
				LOGGER.error("CustomerException Thrown : \n" + exception.getMessage());
				throw new CustomerException(exception.getMessage(), exception.getCause());	
			} 
			catch (RepoCallerException exception) 
			{
				LOGGER.error("RepoCallerException Thrown : \n" + exception.getMessage());
				throw new RepoCallerException(exception.getMessage(), exception.getCause());
			} 
			catch (ServiceDiscoveryException exception) 
			{
				LOGGER.error("ServiceDiscoveryException Thrown : \n" + exception.getMessage());
				throw new ServiceDiscoveryException(exception.getMessage(), exception.getCause());
			} 


	}

	/*** http://localhost:8200/customers 
	 * @throws RepoCallerException ***/
	@PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO postNewCustomer(@RequestBody CustomerDTO postCustomer) throws CustomerException, RepoCallerException, ServiceDiscoveryException
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
	public CustomerDTO updateCustomerById(@PathVariable String customer_id, @RequestBody CustomerDTO updateCustomer) throws CustomerException, RepoCallerException, ServiceDiscoveryException 
	{

		CustomerDTO updatedCustomer;

		try {

			updatedCustomer = customerService.updateCustomerById(customer_id, updateCustomer);

			LOGGER.info("Customer ${" + updatedCustomer.getId() + "} updated successfully in DB.");

			return updatedCustomer;

			}catch (CustomerException exception) 
			{
				throw new CustomerException(exception.getMessage(), exception.getCause());	
			} 
			catch (RepoCallerException exception) 
			{
				throw new RepoCallerException(exception.getMessage(), exception.getCause());
			} 

	}

	/***
	 * http://localhost:8200/customer/1
	 * 
	 * @throws CustomerException
	 ***/
	@DeleteMapping(value = "/customer/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCustomerById(@PathVariable String customer_id) throws CustomerException, RepoCallerException, ServiceDiscoveryException 
	{

		try {
			customerService.deleteCustomerById(customer_id);
			String customerDeletedMsg = "Customer ${" + customer_id + "} deleted successfully from DB.";
			LOGGER.info(customerDeletedMsg);
			return customerDeletedMsg;

		}
		catch (CustomerException exception) 
		{
			throw new CustomerException(exception.getMessage(), exception.getCause());	
		} 

	}

	
}
