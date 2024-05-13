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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DTO.UserRegisteredDTO;
import com.model.User;
import com.repository.UserRepository;



@Controller
@RequestMapping("/adminScreen")
public class AdminController {
	
	@Autowired
	UserRepository userRepository;
	
	
	// @GetMapping("/adminScreen")
	//    public String displayAdminDashboard(Model model) {
	        // Fetch all users from the database
	   //     Iterable<User> users = userRepository.findAll();
	        // Add users to the model
	    //    model.addAttribute("user", users);
	     //   return "adminScreen";
	   // }
	 
	@GetMapping
    public String displayDashboard(Model model){
		// Fetch all users from the database
        Iterable<User> users = userRepository.findAll();
		//String user= returnUsername();
        model.addAttribute("users", users);
        return "adminScreen";
    }
	
	  @GetMapping("/edit/{id}")
	    public String editUser(@PathVariable("id") int id, Model model) {
	        // Retrieve user by id from the database
	        User user = userRepository.findById(id).orElse(null);
	        model.addAttribute("user", user);
	        return "editUser"; // Update with the name of your edit user page
	    }
	    
	    @GetMapping("/delete/{id}")
	    public String deleteUser(@PathVariable("id") int id) {
	        // Delete user by id from the database
	        userRepository.deleteById(id);
	        return "redirect:/adminScreen";
	    }
	
	 // Add this method to your controller
	    @PostMapping("/update")
	    public String updateUser(@ModelAttribute("user") User updatedUser) {
	        User originalUser = userRepository.findById(updatedUser.getId()).orElse(null);
	        if (originalUser != null) {
	            originalUser.setName(updatedUser.getName());
	            originalUser.setEmail(updatedUser.getEmail());
	            userRepository.save(originalUser);
	        }
	        return "redirect:/adminScreen";
	    }
//	    
//	    @PutMapping("/adminScreen/update")
//	    public String updateUser(@ModelAttribute("user") User updatedUser) {
//	    	
//	        // Retrieve the original user from the database
//	        User originalUser = userRepository.findById(updatedUser.getId()).orElse(null);
//	        if (originalUser != null) {
//	            // Update the original user with the new information
//	            originalUser.setName(updatedUser.getName());
//	            originalUser.setEmail(updatedUser.getEmail());
//	            // Save the updated user
//	            userRepository.save(originalUser);
//	        }
//	        return "redirect:/adminScreen"; // Redirect to the admin screen
//	    }
	    
	private String returnUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByEmail(user.getUsername());
		return users.getName();
	}
	
}
