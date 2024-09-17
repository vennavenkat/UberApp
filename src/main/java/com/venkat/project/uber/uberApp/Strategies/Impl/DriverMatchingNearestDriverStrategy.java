package com.venkat.project.uber.uberApp.Strategies.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.Strategies.DriverMatchingStrategy;
import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.Driver;

@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

	@Override
	public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub
		return List.of();
	}
}

