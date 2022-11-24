package com.subscribe.mainp.repository;

import com.subscribe.mainp.entity.Ott;
import com.subscribe.mainp.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plans, Integer> {
}
