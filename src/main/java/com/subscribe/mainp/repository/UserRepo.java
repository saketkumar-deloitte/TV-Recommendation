package com.subscribe.mainp.repository;

import com.subscribe.mainp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
