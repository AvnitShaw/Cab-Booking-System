package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @PostMapping("/calculate-price")
    public String calculatePrice(@RequestParam("pickupAddress") String pickupAddress,
                                 @RequestParam("destinationAddress") String destinationAddress,
                                 @RequestParam("timeOfAction") String timeOfAction,
                                 Model model) {
        double distance = calculateDistance(pickupAddress, destinationAddress);
        double baseFare = 25.0;
        double pricePerKm = 10.0;
        double price = baseFare + (distance * pricePerKm);

        model.addAttribute("pickupAddress", pickupAddress);
        model.addAttribute("destinationAddress", destinationAddress);
        model.addAttribute("timeOfAction", timeOfAction);
        model.addAttribute("price", price);
        return "price";
    }

    private double calculateDistance(String pickupAddress, String destinationAddress) {
        pickupAddress = pickupAddress.toLowerCase().trim();
        destinationAddress = destinationAddress.toLowerCase().trim();
        
        if (pickupAddress.equals("delhi") && destinationAddress.equals("mumbai") ||
            pickupAddress.equals("mumbai") && destinationAddress.equals("delhi")) {
            return 1400.0; // Delhi to Mumbai
        } else if (pickupAddress.equals("delhi") && destinationAddress.equals("kolkata") ||
                   pickupAddress.equals("kolkata") && destinationAddress.equals("delhi")) {
            return 1500.0; // Delhi to Kolkata
        } else if (pickupAddress.equals("delhi") && destinationAddress.equals("chennai") ||
                   pickupAddress.equals("chennai") && destinationAddress.equals("delhi")) {
            return 2200.0; // Delhi to Chennai
        } else if (pickupAddress.equals("mumbai") && destinationAddress.equals("kolkata") ||
                   pickupAddress.equals("kolkata") && destinationAddress.equals("mumbai")) {
            return 2000.0; // Mumbai to Kolkata
        } else if (pickupAddress.equals("mumbai") && destinationAddress.equals("chennai") ||
                   pickupAddress.equals("chennai") && destinationAddress.equals("mumbai")) {
            return 1300.0; // Mumbai to Chennai
        } else if (pickupAddress.equals("kolkata") && destinationAddress.equals("chennai") ||
                   pickupAddress.equals("chennai") && destinationAddress.equals("kolkata")) {
            return 1700.0; // Kolkata to Chennai
        } else {
            return 25.0; // Default distance if cities are not recognized
        }
    }
}
