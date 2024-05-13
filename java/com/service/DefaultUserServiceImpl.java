package com.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.DTO.PatientDTO;
import com.DTO.UserRegisteredDTO;
import com.model.Patient;
import com.model.Role;
import com.model.User;
import com.repository.PatientRepository;
import com.repository.RoleRepository;
import com.repository.UserRepository;

@Service
public class DefaultUserServiceImpl implements DefaultUserService{
	
   @Autowired
	private UserRepository userRepo;
   @Autowired
    private RoleRepository roleRepo;
   @Autowired
   private PatientRepository patientRepository;
   
   
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		User user = userRepo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRole()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
   
	@Override
	public User save(UserRegisteredDTO userRegisteredDTO) {
		Role role = new Role();
		if(userRegisteredDTO.getRole().equals("USER")) {
		  role = roleRepo.findByRole("USER");
		}else if(userRegisteredDTO.getRole().equals("ADMIN")) {
		 role = roleRepo.findByRole("ADMIN");
		}
		else if(userRegisteredDTO.getRole().equals("EMPLOYEE")) {
			 role = roleRepo.findByRole("EMPLOYEE");
		}
		User user = new User();
		user.setEmail(userRegisteredDTO.getEmail_id());
		user.setName(userRegisteredDTO.getName());
		user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
		user.setRole(role);
		
		return userRepo.save(user);
	}

	@Override
	public User update(PatientDTO patientDTO) {
		String roleName = patientDTO.getRole();
	    Role role = roleRepo.findByRole(roleName);
	    if (role == null) {
	        throw new IllegalArgumentException("Invalid role: " + roleName);
	    }

	    User user = new User();
	    user.setEmail(patientDTO.getEmail());
	    user.setName(patientDTO.getName());
	    user.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
	    user.setRole(role);
	    
	    return userRepo.save(user);
	}
	
	 public void updateResetPasswordToken(String token, String email)  {
	        User customer = userRepo.findByEmail(email);
	        if (customer != null) {
	            customer.setResetPasswordToken(token);
	            userRepo.save(customer);
	        } else {
	        	System.out.println("Could not find any customer with the email " + email);
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
