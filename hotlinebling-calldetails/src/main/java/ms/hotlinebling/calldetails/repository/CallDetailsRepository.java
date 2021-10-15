package ms.hotlinebling.calldetails.repository;

import ms.hotlinebling.calldetails.entity.CallDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CallDetailsRepository extends JpaRepository<CallDetails, Long> 
{
	List<CallDetails> findByCallFrom(long calledBy);
}
