package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class SignupController {

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@ModelAttribute SignupForm signupForm, Model model) {
        // Save data to a .txt file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("signup_data.txt", true))) {
            writer.write("Username: " + signupForm.getUsername());
            writer.newLine();
            writer.write("Email: " + signupForm.getEmail());
            writer.newLine();
            writer.write("Password: " + signupForm.getPassword());
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return success message to the view
        model.addAttribute("message", "Signup successful! Your data has been saved.");
        return "signup";
    }
}