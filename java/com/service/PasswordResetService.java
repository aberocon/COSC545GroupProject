package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

import java.util.UUID;

@Service
public class PasswordResetService {

	 @Autowired
		private UserRepository userRepo;

    @Autowired
    private EmailService emailService; // Implement this service for sending emails

    // Method to send reset password email
    public boolean sendResetPasswordEmail(String email) {
        // Find user by email
        User user = userRepo.findByEmail(email);
        if (user == null) {
            return false; // User not found with the given email
        }

        // Generate reset token
        String resetToken = UUID.randomUUID().toString();
        user.setResetPasswordToken(resetToken);
        userRepo.save(user);

        // Send email with reset link
        String resetPasswordLink = "https://mail.google.com/resetPassword?token=" + resetToken;
        String emailContent = "Dear " + user.getFirst_name() + ",\n\n"
                + "You have requested to reset your password. Please click on the following link to reset your password:\n\n"
                + resetPasswordLink + "\n\n"
                + "If you did not request this, please ignore this email.\n\n"
                + "Regards,\n"
                + "Your Application Team";
        emailService.sendHtmlEmail(user.getEmail(), "Password Reset Request", emailContent);

        return true; // Email sent successfully
    }
}


