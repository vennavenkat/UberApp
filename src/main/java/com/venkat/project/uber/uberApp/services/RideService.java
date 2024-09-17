package com.venkat.project.uber.uberApp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.Ride;
import com.venkat.project.uber.uberApp.entities.enums.RideStatus;

public interface RideService {
	Ride getRideById(Long rideId);
	
	void matchWithDrivers(RideRequestDto rideRequestDto);
	
	Ride createNewRie(RideRequestDto rideRequestDto, Driver driver);
	
	Ride updateRideStatus(Long rideId, RideStatus rideStatus);
	
	Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest);
	
	Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);

}
