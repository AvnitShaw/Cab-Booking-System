package com.example.demo;

public class TripCostCalculator {

    public double CalculateTripCost(double distance) {
        if (distance < 0 ) {
            throw new IllegalArgumentException("Distance must be positive values.");
        }

        // Calculate the trip cost
        double tripCost = distance * 10;
        return tripCost;
    }
}