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
import ms.hotlinebling.customer.repository.CustomerRepository;

@Service(value="customerService")
@Transactional
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

	public List<CustomerDTO> getCustomers() {
		
		List<Customer> customers = customerRepo.findAll();
		
		List<CustomerDTO> customerDTOs = CustomerDTO.valueOf(customers);
		
		return customerDTOs;
	}

	public CustomerDTO updateCustomerById(int customer_id, CustomerDTO updateCustomer) {
		System.out.print("\n\n SERVICE HIT \n\n");
		Customer foundCustomer = customerRepo.getById(customer_id);
		System.out.println(foundCustomer.toString());
		
		foundCustomer = Customer.updateEntity(foundCustomer, updateCustomer);
		
		Customer updatedCustomer = customerRepo.save(foundCustomer); 
		
		CustomerDTO updatedCustomerDTO = CustomerDTO.valueOf(updatedCustomer);
				
		System.out.print("\n\n UPDATED CUSTOMER \n\n");
		
		return updatedCustomerDTO;
	}

}
