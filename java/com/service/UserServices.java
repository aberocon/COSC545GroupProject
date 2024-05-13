package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
	@Transactional
	public class UserServices {
	 
	    @Autowired
	    private UserRepository userRepo;
	     
	 
	    public void updateResetPasswordToken(String token, String email) throws Exception {
	        User user = userRepo.findByEmail(email);
	        if (user != null) {
	        	user.setResetPasswordToken(token);
	            userRepo.save(user);
	        } else {
	            throw new Exception("Could not find any user with the email " + email);
	        }
	    }
	     
	    public User getByResetPasswordToken(String token) {
	        return userRepo.findByResetPasswordToken(token);
	    }
	     
	    public void updatePassword(User user, String newPassword) {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(newPassword);
	        user.setPassword(encodedPassword);
	         
	        user.setResetPasswordToken(null);
	        userRepo.save(user);
	    }
}
