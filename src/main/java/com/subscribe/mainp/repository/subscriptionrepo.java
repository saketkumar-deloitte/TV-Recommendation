package com.subscribe.mainp.repository;

import com.subscribe.mainp.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import com.subscribe.mainp.entity.Subscription;

import java.util.List;

public interface subscriptionrepo extends JpaRepository<Subscription, Long>{
    public List<Subscription> findByUserId(int userid);


}
