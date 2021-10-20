package ms.hotlinebling.plan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public PlanDTO getById(int plan_id) {
		Optional<Plan> planOptional = planRepo.findById(plan_id);
		
		if(planOptional.isPresent())
		{
			return PlanDTO.valueOf(planOptional.get());
		}
		return null;
	}

	public PlanDTO postNewPlan(PlanDTO newPlan) 
	{
	
		Plan plan = planRepo.save(Plan.valueOf(newPlan));
		
		
		return PlanDTO.valueOf(plan);
	}

}
