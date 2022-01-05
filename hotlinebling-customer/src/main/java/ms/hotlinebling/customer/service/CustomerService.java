package ms.hotlinebling.customer.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ms.hotlinebling.customer.dto.CustomerDTO;
import ms.hotlinebling.customer.entity.Customer;
import ms.hotlinebling.customer.exception.CustomerException;
import ms.hotlinebling.customer.repository.CustomerRepository;

@Service(value="customerService")
@Transactional
public class CustomerService 
{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerRepository customerRepo;
	
	public CustomerDTO getCustomerById(int customer_id)
	{		
		Customer customer = customerRepo.getById(customer_id);
		CustomerDTO customerDTO = CustomerDTO.valueOf(customer);
		
		return customerDTO;
	}

	public CustomerDTO postNewCustomer(CustomerDTO customerDTO) 
	{
		
		Customer customer = Customer.valueOf(customerDTO);
		customerRepo.save(customer);
		CustomerDTO postedCustomer = CustomerDTO.valueOf(customer);
		
		return postedCustomer;
	}

	public List<CustomerDTO> getAllCustomers() 
	{
		
		List<Customer> customers = customerRepo.findAll();
		List<CustomerDTO> customerDTOs = CustomerDTO.valueOf(customers);
		
		return customerDTOs;
	}

	public CustomerDTO updateCustomerById(String customer_id, CustomerDTO updateCustomer) throws CustomerException
	{
		try 
		{
			Optional<Customer> foundCustomer = findCustomer(customer_id);
			if(foundCustomer.isPresent())
			{				
				Customer customer = foundCustomer.get();
				customer = Customer.updateEntity(customer, updateCustomer);
				Customer updatedCustomer = customerRepo.save(customer); 
				CustomerDTO updatedCustomerDTO = CustomerDTO.valueOf(updatedCustomer);
				
				return updatedCustomerDTO;
			}
			
			return null;
		} catch (CustomerException exception)
		{
			throw new CustomerException(exception.getMessage(), exception.getCause());
		}
	}

	public void deleteCustomerById(String customer_id) throws CustomerException
	{
		try 
		{	
			deleteCustomer(customer_id);
		} catch(CustomerException exception)
		{
			throw new CustomerException("\n\n Something went wrong: \n\n" + exception.getMessage(), exception.getCause());
		}
	}

	private Optional<Customer> findCustomer(String customer_id) throws CustomerException
	{
		return customerRepo.findById(Integer.parseInt(customer_id));
	}
	
	private void deleteCustomer(String customer_id) throws CustomerException
	{	
		customerRepo.deleteById(Integer.parseInt(customer_id));	
	}
}
