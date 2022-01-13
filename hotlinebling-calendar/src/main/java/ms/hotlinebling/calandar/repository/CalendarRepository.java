package ms.hotlinebling.calandar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ms.hotlinebling.calandar.entity.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> 
{

}
