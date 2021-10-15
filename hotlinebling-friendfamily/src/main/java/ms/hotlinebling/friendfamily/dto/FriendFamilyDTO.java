package ms.hotlinebling.friendfamily.dto;

import ms.hotlinebling.friendfamily.entity.FriendFamily;

public class FriendFamilyDTO 
{
	
	private long phoneNumber;
	private long friendAndFamily;
	
	public FriendFamilyDTO() 
	{
		super();
	}
	public FriendFamilyDTO(long phoneNumber, long friendAndFamily)
	{
		this();
		this.phoneNumber = phoneNumber;
		this.friendAndFamily = friendAndFamily;
	}
	public long getPhoneNumber() 
	{
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}
	public Long getFriendAndFamily() 
	{
		return friendAndFamily;
	}
	public void setFriendAndFamily(Long friendAndFamily) 
	{
		this.friendAndFamily = friendAndFamily;
	}
	public FriendFamily createFriendFamilyEntity()
	{
		FriendFamily friendFamily = new FriendFamily();
		friendFamily.setPhoneNumber(this.getPhoneNumber());
		friendFamily.setFriendAndFamily(this.getFriendAndFamily());
		
		return friendFamily;
	}
}