package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.DTO.UserRegisteredDTO;
import com.service.DefaultUserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	 private DefaultUserService userService;

	    public RegistrationController(DefaultUserService userService) {
	        super();
	        this.userService = userService;
	    }

	    @ModelAttribute("user")
	    public UserRegisteredDTO userRegistrationDto() {
	        return new UserRegisteredDTO();
	    }

	    @GetMapping
	    public String showRegistrationForm() {
	        return "register";
	    }
	    

	   
	    @PostMapping
	    public String registerUserAccount(@ModelAttribute("user") UserRegisteredDTO registrationDto) {
	        userService.save(registrationDto);
	        return "redirect:/login";
	    }
}
