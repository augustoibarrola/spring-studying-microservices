package ms.hotlinebling.phone.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ms.hotlinebling.phone.entity.Phone;
import ms.hotlinebling.phone.exception.PhoneException;
import ms.hotlinebling.phone.repository.PhoneRepository;

@Service(value = "repoCaller")
@Transactional
final class RepositoryCommunicator 
{
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PhoneRepository phoneRepo;

	List<Phone> findAllPhones() throws PhoneException
	{
		return phoneRepo.findAll();
	}
	
	Optional<Phone> findPhone(String phone_id) throws PhoneException 
	{
		return phoneRepo.findById(Integer.parseInt(phone_id));
	}
	
	void deletePhone(String phone_id) throws PhoneException
	{
		phoneRepo.deleteById(Integer.parseInt(phone_id));
	}
	
	Phone savePhone(Phone phone) throws PhoneException 
	{
		
		return phoneRepo.save(phone); 
	}
}
