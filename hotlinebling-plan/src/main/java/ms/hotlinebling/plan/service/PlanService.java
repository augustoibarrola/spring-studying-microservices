package ms.hotlinebling.plan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.hotlinebling.plan.dto.PlanDTO;
import ms.hotlinebling.plan.entity.Plan;
import ms.hotlinebling.plan.repository.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
	PlanRepository planRepo;

	public List<PlanDTO> getAllPlans() 
	{
		List<Plan> plans = planRepo.findAll();
		List<PlanDTO> planDTOs = new ArrayList<>();
		
		for(Plan plan : plans)
		{
			PlanDTO planDTO = PlanDTO.valueOf(plan);
			planDTOs.add(planDTO);
		}
		
		return planDTOs;
	}

}
