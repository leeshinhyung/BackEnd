package com.capstone.dayj.plan;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.appUser.AppUserRepository;
import com.capstone.dayj.exception.CustomException;
import com.capstone.dayj.exception.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;
    private final AppUserRepository appUserRepository;
    
    @Transactional
    public void createPlan(int userId, PlanDto.Request dto) {
        AppUser appUser = appUserRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.APP_USER_NOT_FOUND));
        dto.setAppUser(appUser);
        planRepository.save(dto.toEntity());
    }
    
    @Transactional
    public List<PlanDto.Response> readAllPlan() {
        List<Plan> plans = planRepository.findAll();
        
        if (plans.isEmpty())
            throw new CustomException(ErrorCode.PLAN_NOT_FOUND);
        
        return plans.stream().map(PlanDto.Response::new).collect(Collectors.toList());
    }
    
    @Transactional
    public PlanDto.Response readPlanById(int id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
        
        return new PlanDto.Response(plan);
    }
    
    @Transactional
    public PlanDto.Response readPlanByPlanTag(String planTag) {
        Plan plan = planRepository.findByPlanTag(planTag)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
        
        return new PlanDto.Response(plan);
    }
    
    @Transactional
    public void updatePlan(int id, PlanDto.Request dto) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
        
        plan.update(dto.getPlanAlarmDate(), dto.getPlanTag(),
                dto.getGoal(), dto.getPlanPhoto(), dto.getPlanTime(), dto.getPlanDay(), dto.isPublic(), dto.isComplete());
    }
    
    @Transactional
    public void deletePlanById(int id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
        PlanDto.Response planDto = new PlanDto.Response(plan);
        
        planRepository.deleteById(planDto.getId());
    }
}