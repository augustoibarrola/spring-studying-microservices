package ms.hotlinebling.calandar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms.hotlinebling.calandar.entity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Integer> 
{

}
