package com.capstone.dayj.plan;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app-user/{user_id}/plan")
public class PlanController {
    private final PlanService planService;
    
    public PlanController(PlanService planService) {
        this.planService = planService;
    }
    
    @PostMapping
    public void createPlan(@PathVariable int user_id, @Valid @RequestBody PlanDto.Request dto) {
        planService.createPlan(user_id, dto);
    }
    
    @GetMapping
    public List<PlanDto.Response> readAllPlan() {
        return planService.readAllPlan();
    }
    
    @GetMapping("/{id}")
    public PlanDto.Response readPlanById(@PathVariable int id) {
        return planService.readPlanById(id);
    }
    
    @GetMapping("tag/{plan_tag}")
    public PlanDto.Response readByPlanTag(@PathVariable String plan_tag) {
        return planService.readPlanByPlanTag(plan_tag);
    }
    
    @PatchMapping("/{id}")
    public void patchPlan(@PathVariable int id, @Valid @RequestBody PlanDto.Request dto) {
        planService.updatePlan(id, dto);
    }
    
    @DeleteMapping("/{id}")
    public void deletePlanById(@PathVariable int id) {
        planService.deletePlanById(id);
    }
}
