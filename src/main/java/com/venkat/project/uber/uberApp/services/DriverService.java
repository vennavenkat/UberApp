package com.venkat.project.uber.uberApp.services;

import java.util.List;

import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.RideDto;

public interface DriverService {
	
	RideDto acceptRide(Long rideId);
	
	RideDto cancelRide(Long rideId);
	
	RideDto startRide(Long rideId);
	
	RideDto endRide(Long rideId);
	
	RideDto rateRider(Long rideId, Integer rating);
	
	DriverDto getMyProfile();
	
	List<RideDto> getAllMyRides();
	
	

}
