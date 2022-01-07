package ms.hotlinebling.customer.service;

import java.util.ArrayList;
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

@Service(value = "customerService")
@Transactional
public class CustomerService {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CustomerRepository customerRepo;

	public List<CustomerDTO> getAllCustomers() throws CustomerException {
		try {

			List<Customer> customers = findAllCustomers();
			List<CustomerDTO> customerDTOs = CustomerDTO.valueOf(customers);

			return customerDTOs;
		} catch (CustomerException exception) {
			throw new CustomerException(exception.getMessage(), exception.getCause());
		}
	}

	public CustomerDTO getCustomerById(int customer_id) throws CustomerException {
		try {
			Optional<Customer> foundCustomer = findCustomer(customer_id);
			if (foundCustomer.isPresent()) {
				CustomerDTO customerDTO = CustomerDTO.valueOf(foundCustomer);
				return customerDTO;
			}
			return null;
		} catch (CustomerException exception) {
			throw new CustomerException(exception.getMessage(), exception.getCause());
		}
	}

	public CustomerDTO postNewCustomer(CustomerDTO customerDTO) throws CustomerException {

		try {
			Customer customer = postCustomer(customerDTO);
			CustomerDTO postedCustomer = CustomerDTO.valueOf(customer);

			return postedCustomer;
		} catch (CustomerException exception) {
			throw new CustomerException(exception.getMessage(), exception.getCause());
		}
	}

	public CustomerDTO updateCustomerById(String customer_id, CustomerDTO updateCustomer) throws CustomerException {
		try {
			Optional<Customer> foundCustomer = findCustomer(customer_id);
			if (foundCustomer.isPresent()) {
				Customer customer = foundCustomer.get();
				customer = Customer.updateEntity(customer, updateCustomer);
				Customer updatedCustomer = customerRepo.save(customer);
				CustomerDTO updatedCustomerDTO = CustomerDTO.valueOf(updatedCustomer);

				return updatedCustomerDTO;
			}

			return null;
		} catch (CustomerException exception) {
			throw new CustomerException(exception.getMessage(), exception.getCause());
		}
	}

	public void deleteCustomerById(String customer_id) throws CustomerException {
		try {
			deleteCustomer(customer_id);
		} catch (CustomerException exception) {
			throw new CustomerException("\n\n Something went wrong: \n\n" + exception.getMessage(),
					exception.getCause());
		}
	}

	/**
	 * 
	 * @return
	 */
	private List<Customer> findAllCustomers() throws CustomerException {
		List<Customer> customers = new ArrayList<>();
		customers = customerRepo.findAll();
		return customers;
	}

	/**
	 * 
	 * @param String customer_id
	 * @return
	 * @throws CustomerException
	 */
	private Optional<Customer> findCustomer(String customer_id) throws CustomerException {
		return customerRepo.findById(Integer.parseInt(customer_id));
	}

	/**
	 * 
	 * @param customer_id
	 * @return
	 * @throws CustomerException
	 */
	private Optional<Customer> findCustomer(int customer_id) throws CustomerException {
		return customerRepo.findById(customer_id);
	}

	/**
	 * 
	 * @param customerDTO
	 * @return
	 * @throws CustomerException
	 */
	private Customer postCustomer(CustomerDTO customerDTO) throws CustomerException {

		Customer customer = Customer.valueOf(customerDTO);
		return customerRepo.save(customer);
	}

	/**
	 * 
	 * @param customer_id
	 * @throws CustomerException
	 */
	private void deleteCustomer(String customer_id) throws CustomerException {
		customerRepo.deleteById(Integer.parseInt(customer_id));
	}
}
