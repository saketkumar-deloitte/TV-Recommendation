package com.subscribe.mainp.controller;

import com.subscribe.mainp.entity.OttPlatforms;
import com.subscribe.mainp.repository.OttPlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ottPlatform")
public class OttPlatformController {
    @Autowired
    OttPlatformRepository ottPlatformRepository;

    @GetMapping("/")
    public List<OttPlatforms> getAllOtt(){
        return ottPlatformRepository.findAll();
    }

    @PostMapping("/")
    public OttPlatforms addOtt(@RequestBody OttPlatforms ott){
        return ottPlatformRepository.save(ott);
    }
}
