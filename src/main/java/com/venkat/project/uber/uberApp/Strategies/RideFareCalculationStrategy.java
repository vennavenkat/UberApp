package com.venkat.project.uber.uberApp.Strategies;

import com.venkat.project.uber.uberApp.dto.RideRequestDto;

public interface RideFareCalculationStrategy {
	
	double calculateFare(RideRequestDto rideRequestDto);

}
