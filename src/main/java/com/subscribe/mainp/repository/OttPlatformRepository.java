package com.subscribe.mainp.repository;

import com.subscribe.mainp.entity.Ott;
import com.subscribe.mainp.entity.OttPlatforms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OttPlatformRepository extends JpaRepository<OttPlatforms, Integer> {
}
