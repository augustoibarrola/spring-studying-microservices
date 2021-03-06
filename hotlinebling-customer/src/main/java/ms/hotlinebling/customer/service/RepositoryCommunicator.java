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
import ms.hotlinebling.customer.exception.RepoCallerException;
import ms.hotlinebling.customer.repository.CustomerRepository;

@Service(value = "repoCaller")
@Transactional
public class RepositoryCommunicator 
{
	
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerRepository customerRepo;

	/**
	 * 
	 * @return
	 */
	public List<Customer> findAllCustomers() throws RepoCallerException 
	{

			List<Customer> customers;
			if( customerRepo.count() != 0 )
			{
				customers = new ArrayList<>();
				customers = customerRepo.findAll();
				return customers;
			}
			else if (customerRepo.count() == 0)
			{
				throw new RepoCallerException("NO CUSTOMERS FOUND IN DB");
			}
			return null;

	}

	/**
	 * 
	 * @param String customer_id
	 * @return
	 * @throws CustomerException
	 */
	public Optional<Customer> findCustomer(String customer_id) throws RepoCallerException 
	{
		return customerRepo.findById(Integer.parseInt(customer_id));
	}

	/**
	 * 
	 * @param customer_id
	 * @return
	 * @throws CustomerException
	 */
	public Optional<Customer> findCustomer(int customer_id) throws RepoCallerException 
	{
		return customerRepo.findById(customer_id);
	}

	/**
	 * 
	 * @param customerDTO
	 * @return
	 * @throws CustomerException
	 */
	public Customer postCustomer(Customer customer) throws RepoCallerException 
	{
		return customerRepo.save(customer);
	}
	/**
	 * 
	 * @param customerDTO
	 * @return
	 * @throws CustomerException
	 */
	public Customer postCustomer(CustomerDTO customerDTO) throws RepoCallerException 
	{

		Customer customer = Customer.valueOf(customerDTO);
		return customerRepo.save(customer);
	}


	/**
	 * 
	 * @param customer_id
	 * @throws CustomerException
	 */
	public void deleteCustomer(String customer_id) throws RepoCallerException {
		customerRepo.deleteById(Integer.parseInt(customer_id));
	}
}
