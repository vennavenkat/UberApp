package com.venkat.project.uber.uberApp.Strategies.Impl;

import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.Strategies.RideFareCalculationStrategy;
import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.RideRequest;
import com.venkat.project.uber.uberApp.services.DistanceService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RideFareSurgePricingCalculationStrategy implements RideFareCalculationStrategy {

	private final DistanceService distanceService;
	private static final double SURGE_FACTOR = 2;

	@Override
	public double calculateFare(RideRequest rideRequest) {

		Double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), 
						rideRequest.getDropOffLOcation());
		return distance * RIDE_FARE_MULTIPLIER* SURGE_FACTOR;
	}

}
