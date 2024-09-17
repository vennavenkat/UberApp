package com.venkat.project.uber.uberApp.Strategies;

import java.util.List;

import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.Driver;

public interface DriverMatchingStrategy {

	public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);

}
