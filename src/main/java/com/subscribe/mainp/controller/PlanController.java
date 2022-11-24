package com.subscribe.mainp.controller;

import com.subscribe.mainp.dto.PlanDto;
import com.subscribe.mainp.entity.OttPlatforms;
import com.subscribe.mainp.entity.Plans;
import com.subscribe.mainp.repository.OttPlatformRepository;
import com.subscribe.mainp.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlanController {
    @Autowired
    PlanRepository planRepository;

    @Autowired
    OttPlatformRepository ottPlatformRepository;

    @GetMapping("/plans")
    public List<Plans> getAllPlans(){
        return planRepository.findAll();
    }

    @PostMapping("/plans")
    public Plans addPlan(@RequestBody PlanDto plan){
        Plans p = new Plans();
        p.setPlanName(plan.getName());
        p.setDuration(plan.getDuration());
        p.setPrice(plan.getPrice());
        p.setPlatformsList(new ArrayList<>());
        return planRepository.save(p);
    }

    @PostMapping("ott/{ottId}/plan/{planId}")
    public Plans addOttToPlan(@PathVariable Integer ottId, @PathVariable Integer planId){
        OttPlatforms ottPlatform = ottPlatformRepository.findById(ottId).get();
        Plans plans = planRepository.findById(planId).get();
        plans.getPlatformsList().add(ottPlatform);
        return planRepository.save(plans);
    }
}
