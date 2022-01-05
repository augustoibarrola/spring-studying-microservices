package ms.hotlinebling.plan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ms.hotlinebling.plan.dto.PlanDTO;
import ms.hotlinebling.plan.entity.Plan;
import ms.hotlinebling.plan.exception.PlanException;
import ms.hotlinebling.plan.repository.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
	PlanRepository planRepo;

	public List<PlanDTO> getAllPlans() throws PlanException
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

	public PlanDTO getPlanById(int plan_id) throws PlanException 
	{
		try
		{			
			Optional<Plan> planOptional = findPlan(plan_id);
			
			if(planOptional.isPresent())
			{
				return PlanDTO.valueOf(planOptional.get());
			}
			return null;
		}catch(PlanException exception)
		{
			throw new PlanException("\n\n SOMETHING WENT WRONG: \n\n" + exception.getMessage(), exception.getCause());
		}
	}
	public PlanDTO postNewPlan(PlanDTO planDTO) throws PlanException
	{
		try
		{
			planDTO = postPlan(planDTO);
			return planDTO;
			
		}catch (PlanException exception)
		{
			throw new PlanException("\n\n SOMETHING WENT WRONG: \n\n" + exception.getMessage(), exception.getCause());
		}
	}
	public PlanDTO updatePlanById(String plan_id, PlanDTO planDTO) throws PlanException
	{
		try {
				Optional<Plan> foundPlan = findPlan(plan_id);
				if(foundPlan.isPresent())
				{
					planDTO = updatePlan(foundPlan, planDTO);
					return planDTO;
				}
				return null;
			}catch(PlanException exception)
			{
				throw new PlanException("\n\n SOMETHING WENT WRONG: \n\n" + exception.getMessage(), exception.getCause());
			}
	}
	
	public void deletePlanById(String plan_id) throws PlanException
	{
		try
		{
			deletePlan(plan_id);
		}catch(PlanException exception)
		{
			throw new PlanException("\n\n SOMETHING WENT WRONG: \n\n" + exception.getMessage(), exception.getCause());
		}
	}
	


	/**
	 * 
	 * @param plan_id
	 * @return
	 * @throws PlanException
	 */
	private Optional<Plan> findPlan(String plan_id) throws PlanException
	{
		return planRepo.findById(Integer.parseInt(plan_id));
	}
	/**
	 * 
	 * @param plan_id
	 * @return
	 * @throws PlanException
	 */
	private Optional<Plan> findPlan(int plan_id) throws PlanException
	{
		return planRepo.findById(plan_id);
	}
	

	/**
	 * 
	 * @param postPlan
	 * @return
	 * @throws PlanException
	 */
	private PlanDTO postPlan(PlanDTO postPlan) throws PlanException
	{
	
		Plan plan = planRepo.save(Plan.valueOf(postPlan));
		postPlan.setPlanId(plan.getPlanId());
		
		return postPlan;
	}
	
	/**
	 * 
	 * @param foundPlan
	 */
	private PlanDTO updatePlan(Optional<Plan> foundPlan, PlanDTO planDTO) throws PlanException 
	{
		Plan plan = Plan.updateEntity(foundPlan, planDTO);
		
		plan = planRepo.save(plan);
		
		planDTO = PlanDTO.valueOf(plan);
		
		return planDTO;
		
	}
	
	private void deletePlan(String plan_id) throws PlanException
	{
		planRepo.deleteById(Integer.parseInt(plan_id));
	}


}
