package com.otpexample.repository;

import com.otpexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
   User findByMobile(String mobile);
}
