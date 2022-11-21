package com.subscribe.mainp.controller;

import java.util.List;
import java.util.Optional;

import com.subscribe.mainp.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscribe.mainp.dto.subscriptionDto;
import com.subscribe.mainp.entity.Subscription;
import com.subscribe.mainp.repository.subscriptionrepo;
import com.subscribe.mainp.service.subscriptionImpl;

@RestController
@RequestMapping("/subs")
public class subscriptionController {
	
	@Autowired
	subscriptionImpl subsService;
	
	@PostMapping("/add")
	public Subscription addSubscription(@RequestBody subscriptionDto sub) {
		return subsService.addSubscription(sub);
	}
	
	@GetMapping("/all")
	public List<Subscription> getAll() {
		return subsService.getAllSubscription();
	}
	
	
	@DeleteMapping("/remove")
	public void removeSubscription() {
		
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Subscription>> getSubscriptionByUserID(@PathVariable int userId) {
		List<Subscription> sub = subsService.getSubscriptionByUserID(userId);
		if (sub.size() == 0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		try {
			return ResponseEntity.of(Optional.of(sub));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	}


}
