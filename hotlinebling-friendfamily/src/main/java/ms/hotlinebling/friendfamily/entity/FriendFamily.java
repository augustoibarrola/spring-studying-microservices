package ms.hotlinebling.friendfamily.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FriendFamily")
public class FriendFamily 
{
	
	@Id
	@GeneratedValue
	int id;
	@Column(name = "phone_number", nullable = false)
	long phoneNumber;
	@Column(name = "friend_and_family", nullable = false)
	private Long friendAndFamily;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getFriendAndFamily() {
		return friendAndFamily;
	}
	public void setFriendAndFamily(Long friendAndFamily) {
		this.friendAndFamily = friendAndFamily;
	}
}
