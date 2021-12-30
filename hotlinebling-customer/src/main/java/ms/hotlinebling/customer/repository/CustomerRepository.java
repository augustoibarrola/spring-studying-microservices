package ms.hotlinebling.customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms.hotlinebling.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findAll();

	Optional<Customer> findById(int customer_id);

	Customer getById(int customer_id);
}

/*
 * findBy returns Optional<T> objects; getBy returns T objects.
 */
