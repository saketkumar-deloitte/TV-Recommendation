package com.subscribe.mainp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subscribe.mainp.entity.Subscription;

public interface subscriptionrepo extends JpaRepository<Subscription, Long>{

}
