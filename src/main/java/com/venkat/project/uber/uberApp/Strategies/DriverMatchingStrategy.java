package com.venkat.project.uber.uberApp.Strategies;

import java.util.List;

import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.RideRequest;

public interface DriverMatchingStrategy {

	public List<Driver> findMatchingDriver(RideRequest rideReques);

}
