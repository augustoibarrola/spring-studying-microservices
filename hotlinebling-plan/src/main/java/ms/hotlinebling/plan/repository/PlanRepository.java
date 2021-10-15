package ms.hotlinebling.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ms.hotlinebling.plan.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
