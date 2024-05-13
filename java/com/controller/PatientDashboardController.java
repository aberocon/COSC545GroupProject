package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DTO.PatientDTO;
import com.DTO.UserRegisteredDTO;
import com.model.Patient;
import com.model.User;
import com.repository.PatientRepository;
import com.repository.UserRepository;




@Controller
@RequestMapping("/patientdashboard")
public class PatientDashboardController {
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PatientRepository patientRepository;
	
	

    @GetMapping
    public String displayDashboard(Model model) {
        String username = returnUsername();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        model.addAttribute("userDetails", username);
        model.addAttribute("user", user);
        return "patientDashboard";
    }
    
    @GetMapping("/update/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        // Retrieve user by id from the database
        User user = userRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "update"; // Update with the name of your edit user page
    }
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
//        User existingUser = userRepository.findById(user.getId()).orElse(null);
//        if (existingUser != null) {
//            existingUser.setName(user.getName());
//            existingUser.setEmail(user.getEmail());
//            userRepository.save(existingUser);
//        }
        userRepository.save(user);
        return "redirect:/patientDashboard";
    }


    
    private String returnUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails userDetails = (UserDetails) securityContext.getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }
}
