package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripCalculatorController {

    @GetMapping("/calculate")
    public String showCalculator() {
        return "price";
    }
    
}