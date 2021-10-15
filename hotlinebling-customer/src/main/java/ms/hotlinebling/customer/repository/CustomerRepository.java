package ms.hotlinebling.customer.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ms.hotlinebling.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> 
{
	List<Customer> findAll();
	Optional<Customer> findById(Long customer_id);
}
