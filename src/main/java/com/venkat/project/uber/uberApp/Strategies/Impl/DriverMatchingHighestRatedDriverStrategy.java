package com.venkat.project.uber.uberApp.Strategies.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.Strategies.DriverMatchingStrategy;
import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.RideRequest;

@Service
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy{

	@Override
	public List<Driver> findMatchingDriver(RideRequest rideRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
