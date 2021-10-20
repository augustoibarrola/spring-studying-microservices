package ms.hotlinebling.customer.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.hotlinebling.customer.dto.CustomerDTO;
import ms.hotlinebling.customer.entity.Customer;
import ms.hotlinebling.customer.repository.CustomerRepository;

@Service
public class CustomerService 
{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerRepository customerRepo;
	
	public CustomerDTO getCustomerDetailsById(int customer_id)
	{		
		Customer customer = customerRepo.getById(customer_id);
		
		CustomerDTO customerDTO = CustomerDTO.valueOf(customer);
		
		return customerDTO;
	}

	public CustomerDTO postNewCustomer(CustomerDTO postCustomer) 
	{
		
		Customer customer = Customer.valueOf(postCustomer);
		
		customerRepo.save(customer);
		
		CustomerDTO postedCustomer = CustomerDTO.valueOf(customer);
		
		
		return postedCustomer;
	}

}
