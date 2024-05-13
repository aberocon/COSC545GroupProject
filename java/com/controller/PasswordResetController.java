package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.service.PasswordResetService;

@Controller
@RequestMapping("/forgotPassword")
public class PasswordResetController {

    @Autowired
    private PasswordResetService passwordResetService;

    @GetMapping
    public String showForgotPasswordForm() {
        return "forgot_password_form";
    }

    @PostMapping
    public String processForgotPassword(@RequestParam("email") String email, Model model) {
        boolean result = passwordResetService.sendResetPasswordEmail(email);
        if (result) {
            model.addAttribute("message", "Password reset link sent to your email.");
        } else {
            model.addAttribute("error", "Failed to process password reset.");
        }
        return "forgot_password_form";
    }
}

