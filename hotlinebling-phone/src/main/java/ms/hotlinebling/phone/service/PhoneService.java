package ms.hotlinebling.phone.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import ms.hotlinebling.phone.dto.PhoneDTO;
import ms.hotlinebling.phone.entity.Phone;
import ms.hotlinebling.phone.exception.PhoneException;
import ms.hotlinebling.phone.repository.PhoneRepository;

@Service
public class PhoneService 
{
	
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PhoneRepository phoneRepo;

	public List<PhoneDTO> getAllPhones() 
	{
		
		List<Phone> phones = phoneRepo.findAll();
		List<PhoneDTO> phoneDTOs  = PhoneDTO.valueOf(phones);
		
		return phoneDTOs;
		
	}
	public PhoneDTO getPhoneById(String phoneId) 
	{

		Optional<Phone> phoneOptional = phoneRepo.findById(Integer.parseInt(phoneId));
		
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


	public PhoneDTO updatePhoneById(String phone_id, PhoneDTO updatePhone) 
	{
		Optional<Phone> foundPhone = findPhone(phone_id);
		if(foundPhone.isPresent())
		{
			Phone phone = foundPhone.get();
			phone = Phone.updateEntity(phone, updatePhone);
			Phone updatedPhone = phoneRepo.save(phone);
			PhoneDTO updatedPhoneDTO = PhoneDTO.valueOf(updatedPhone);
			
			return updatedPhoneDTO;
		}
		
		return null;
	}
	
	public void deletePhoneById(String phone_id) throws PhoneException
	{
		try
		{
			deletePhone(phone_id);
		}catch(PhoneException exception) 
		{
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(), exception.getCause());
		}
		
	}

//
	private Optional<Phone> findPhone(String phone_id) 
	{
		return phoneRepo.findById(Integer.parseInt(phone_id));
	}
	private void deletePhone(String phone_id) throws PhoneException
	{
		phoneRepo.deleteById(Integer.parseInt(phone_id));
	}


}
