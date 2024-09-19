package com.venkat.project.uber.uberApp.Strategies.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.Strategies.DriverMatchingStrategy;
import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.RideRequest;
import com.venkat.project.uber.uberApp.repositories.DriverRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy{
	
	private final DriverRepository driverRepository;

	@Override
	public List<Driver> findMatchingDriver(RideRequest rideRequest) {
		
		return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
	}
	

}
