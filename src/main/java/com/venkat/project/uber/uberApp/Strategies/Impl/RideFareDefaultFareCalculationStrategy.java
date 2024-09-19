package com.venkat.project.uber.uberApp.Strategies.Impl;

import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.Strategies.RideFareCalculationStrategy;
import com.venkat.project.uber.uberApp.entities.RideRequest;
import com.venkat.project.uber.uberApp.services.DistanceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy{
	
	private final DistanceService distanceService;

	@Override
	public double calculateFare(RideRequest rideRequest) {

		Double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), 
						rideRequest.getDropOffLOcation());
		return distance * RIDE_FARE_MULTIPLIER;
	}

}
