package ms.hotlinebling.friendfamily.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ms.hotlinebling.friendfamily.entity.FriendFamily;

public interface FriendFamilyRepository extends JpaRepository<FriendFamily, Long>
{
	List<FriendFamily> getByPhoneNumber(Long phoneNumber);
}
