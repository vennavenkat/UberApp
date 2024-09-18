package com.venkat.project.uber.uberApp.Strategies;

import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {
	
	 double RIDE_FARE_MULTIPLIER = 10;
	
	double calculateFare(RideRequest rideRequest);

}
