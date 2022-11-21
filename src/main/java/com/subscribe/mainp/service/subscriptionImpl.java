package com.subscribe.mainp.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.subscribe.mainp.dto.subscriptionDto;
import com.subscribe.mainp.entity.Subscription;

@Repository
public interface subscriptionImpl {

	
	public List<Subscription> getAllSubscription();
	
	public Subscription addSubscription(subscriptionDto subs);
	
	public Subscription removeSubscription();

	public List<Subscription> getSubscriptionByUserID(int userid);


	}
