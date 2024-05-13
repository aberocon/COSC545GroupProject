package com.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.DTO.PatientDTO;
import com.DTO.UserRegisteredDTO;
import com.model.User;


public interface DefaultUserService extends UserDetailsService{

	User save(UserRegisteredDTO userRegisteredDTO);
	User update(PatientDTO patientDTO);
	
}
