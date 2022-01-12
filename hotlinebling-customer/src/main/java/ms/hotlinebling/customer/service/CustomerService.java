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
import ms.hotlinebling.customer.exception.RepoCallerException;

@Service(value = "customerService")
@Transactional
public class CustomerService {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RepositoryCommunicator repoCaller;

	public List<CustomerDTO> getAllCustomers() throws CustomerException, RepoCallerException 
	{
		try {

			List<Customer> customers = repoCaller.findAllCustomers();
			List<CustomerDTO> customerDTOs = CustomerDTO.valueOf(customers);

			return customerDTOs;
		}catch (RepoCallerException exception) {
			throw new RepoCallerException(exception.getMessage(), exception.getCause());
		} 
	}

	public CustomerDTO getCustomerById(int customer_id) throws CustomerException, RepoCallerException 
	{
		try {
			Optional<Customer> foundCustomer = repoCaller.findCustomer(customer_id);
			if (foundCustomer.isPresent()) {
				CustomerDTO customerDTO = CustomerDTO.valueOf(foundCustomer);
				return customerDTO;
			}
			return null;
		} catch (RepoCallerException exception) {
			throw new CustomerException(exception.getMessage(), exception.getCause());
		}
	}

	public CustomerDTO postNewCustomer(CustomerDTO customerDTO) throws CustomerException, RepoCallerException
	{

		try {
			Customer customer = repoCaller.postCustomer(customerDTO);
			CustomerDTO postedCustomer = CustomerDTO.valueOf(customer);

			return postedCustomer;
		} catch (RepoCallerException exception) {
			throw new CustomerException(exception.getMessage(), exception.getCause());
		}
	}

	public CustomerDTO updateCustomerById(String customer_id, CustomerDTO updateCustomer) throws CustomerException, RepoCallerException 
	{
		try {
			Optional<Customer> foundCustomer = repoCaller.findCustomer(customer_id);
			if (foundCustomer.isPresent()) {
				Customer customer = foundCustomer.get();
				customer = Customer.updateEntity(customer, updateCustomer);
				Customer updatedCustomer = repoCaller.postCustomer(customer);
				CustomerDTO updatedCustomerDTO = CustomerDTO.valueOf(updatedCustomer);

				return updatedCustomerDTO;
			}

			return null;
		} catch (RepoCallerException exception) {
			throw new CustomerException(exception.getMessage(), exception.getCause());
		}
	}

	public void deleteCustomerById(String customer_id) throws CustomerException 
	{
		try {
			repoCaller.deleteCustomer(customer_id);
		} catch (RepoCallerException exception) {
			throw new CustomerException("\n\n Something went wrong: \n\n" + exception.getMessage(),
					exception.getCause());
		}
	}
}
