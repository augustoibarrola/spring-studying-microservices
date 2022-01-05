package ms.hotlinebling.phone.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import ms.hotlinebling.phone.dto.PhoneDTO;
import ms.hotlinebling.phone.entity.Phone;
import ms.hotlinebling.phone.exception.PhoneException;
import ms.hotlinebling.phone.repository.PhoneRepository;

@Service(value = "phoneService")
@Transactional
public class PhoneService 
{
	
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RepositoryCommunicator repoCaller;
	
	public List<PhoneDTO> getAllPhones() throws PhoneException
	{
		try {			
			List<Phone> phones = repoCaller.findAllPhones();
			List<PhoneDTO> phoneDTOs  = PhoneDTO.valueOf(phones);
			
			return phoneDTOs;
		}catch(PhoneException exception) 
		{
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(), exception.getCause());
		}
		
		
	}
	public PhoneDTO getPhoneById(String phoneId) throws PhoneException 
	{
		try 
		{
			Optional<Phone> phoneOptional = repoCaller.findPhone(phoneId);
			if(phoneOptional.isPresent()) return PhoneDTO.valueOf(phoneOptional.get());
			return null;
		}catch(PhoneException exception)
		{
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(), exception.getCause());
		}
		
		
	}

	public PhoneDTO postNewPhone(PhoneDTO phoneDTO) throws PhoneException 
	{
		try
		{
			Phone phone = Phone.valueOf(phoneDTO);
			
			phone = repoCaller.savePhone(phone);
			
			phoneDTO.setPhoneId(phone.getPhoneId());
			
			return phoneDTO;
		}catch(PhoneException exception) 
		{
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(), exception.getCause());
		}
	}


	public PhoneDTO updatePhoneById(String phone_id, PhoneDTO updatePhone) throws PhoneException 
	{
		try
		{
			Optional<Phone> foundPhone = repoCaller.findPhone(phone_id);
			if(foundPhone.isPresent())
			{
				Phone phone = foundPhone.get();
				phone = Phone.updateEntity(phone, updatePhone);
				Phone updatedPhone = repoCaller.savePhone(phone);
				PhoneDTO updatedPhoneDTO = PhoneDTO.valueOf(updatedPhone);
				
				return updatedPhoneDTO;
			}
			
			return null;
		}catch(PhoneException exception) 
		{
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(), exception.getCause());
		}
	}
	
	public void deletePhoneById(String phone_id) throws PhoneException
	{
		try
		{
			repoCaller.deletePhone(phone_id);
		}catch(PhoneException exception) 
		{
			throw new PhoneException("\n\n Something went wrong: \n\n" + exception.getMessage(), exception.getCause());
		}
		
	}



}
