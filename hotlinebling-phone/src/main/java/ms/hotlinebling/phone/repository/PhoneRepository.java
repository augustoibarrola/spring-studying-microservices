package ms.hotlinebling.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ms.hotlinebling.phone.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer> 
{

}
