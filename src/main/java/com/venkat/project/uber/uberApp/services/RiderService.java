package com.venkat.project.uber.uberApp.services;

import java.util.List;

import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.RideDto;
import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.Rider;
import com.venkat.project.uber.uberApp.entities.User;

public interface RiderService {

	RideRequestDto requestRide(RideRequestDto rideRequestDto);

	RideDto cancelRide(Long rideId);

	
	RideDto rateDriver(Long rideId, Integer rating);

	DriverDto getMyProfile();

	List<RideDto> getAllMyRides();
	
	Rider createNewRider(User user);
	
	Rider getCurrentRider();

}
