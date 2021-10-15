package ms.hotlinebling.friendfamily.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.hotlinebling.friendfamily.entity.FriendFamily;
import ms.hotlinebling.friendfamily.repository.FriendFamilyRepository;

@Service
public class FriendFamilyService 
{
	
	@Autowired
	FriendFamilyRepository friendFamilyRepo;
	
	public List<Long> getSpecificFriends(Long phoneNumber)
	{
		List<Long> friendsAndFamilyList = new ArrayList<>();
		
		List<FriendFamily> friendsAndFamily = friendFamilyRepo.getByPhoneNumber(phoneNumber);
		
		for(FriendFamily palOrFam : friendsAndFamily)
		{
			friendsAndFamilyList.add(palOrFam.getPhoneNumber());
		}
		
		return friendsAndFamilyList;
	}

	public List<FriendFamily> getAllFriends() {
		
		return friendFamilyRepo.findAll();
	}

}
