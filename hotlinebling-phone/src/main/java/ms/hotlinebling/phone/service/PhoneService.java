package ms.hotlinebling.phone.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.hotlinebling.phone.dto.PhoneDTO;
import ms.hotlinebling.phone.entity.Phone;
import ms.hotlinebling.phone.repository.PhoneRepository;

@Service
public class PhoneService 
{
	@Autowired
	PhoneRepository phoneRepo;

	public PhoneDTO getCustomerPhone(int phoneId) {

		Optional<Phone> phoneOptional = phoneRepo.findById(phoneId);
		
		if(phoneOptional.isPresent()) return PhoneDTO.valueOf(phoneOptional.get());
		
		return null;
	}

	public PhoneDTO postNewPhone(PhoneDTO phoneDTO) 
	{
		Phone phone = Phone.valueOf(phoneDTO);
		
		phone = phoneRepo.save(phone);
		
		phoneDTO.setPhoneId(phone.getPhoneId());
		
		return phoneDTO;
	}

}
