package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//User findByEmail(String emailId);
	
    public User findByEmail(String email); 
     
    public User findByResetPasswordToken(String token);
    
    public boolean existsByEmail(String email);
}
