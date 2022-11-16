package com.subscribe.mainp.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.subscribe.mainp.dto.subscriptionDto;
import com.subscribe.mainp.entity.Subscription;
import com.subscribe.mainp.repository.subscriptionrepo;

@Service
public class subscriptionService implements subscriptionImpl {
	
	  private final Logger logger = LoggerFactory.getLogger(subscriptionService.class);
	
	@Autowired
	subscriptionrepo subsrepo;

	@Override
	public List<Subscription> getAllSubscription() {
		
		return subsrepo.findAll();
	}

	
	@Override
	@Scheduled(initialDelay = 10000,fixedDelay = 60000)
	public Subscription removeSubscription() {
		// TODO Auto-generated method stub cronjobs
		
		List<Subscription> listSubs=subsrepo.findAll();
		
		for(Subscription subsVal:listSubs) {
			if(subsVal.getEndDate().compareTo(new Date())<0) {
				subsrepo.deleteById(subsVal.getId());
			}
		}
		
		
		logger.info("calling all function"+new Date());
		
		
		return null;
	}

	@Override
	public Subscription addSubscription(subscriptionDto subs) {
	
		
		removeSubscription();
	
	    Date today = new Date();  
	    long ltime = today.getTime()+subs.getNoOfDays()*24*60*60*1000;
	    Date endtime = new Date(ltime);
		
		Subscription sub=new Subscription();
		sub.setUserId(subs.getUserId());
		sub.setMovieId(subs.getMovieId());
		sub.setStartDate(today);
		sub.setEndDate(endtime);
		sub.setTotalPrice(subs.getPrice());
		subsrepo.save(sub);
		
		return null;
	}


	@Override
	public void getSubscriptionByUserID(long UserId) {
		// TODO Auto-generated method stub
		
	}

}
