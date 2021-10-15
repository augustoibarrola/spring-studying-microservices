package ms.hotlinebling.friendfamily.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ms.hotlinebling.friendfamily.entity.FriendFamily;
import ms.hotlinebling.friendfamily.service.FriendFamilyService;

@RestController
@CrossOrigin
public class FriendFamilyController 
{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FriendFamilyService friendFamilyService;
	
	@GetMapping(value = "/customer/friends", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FriendFamily> getAllFriends()
	{
		return friendFamilyService.getAllFriends();
	}
	
	
	@RequestMapping(value = "/customers/{phoneNumber}/friends", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Long> getSpecificFriends(@PathVariable Long phoneNumber)
	{
		return friendFamilyService.getSpecificFriends(phoneNumber);
	}	
	/*
	 * http://localhost:8300/customers/303030/friends
	 */
}
