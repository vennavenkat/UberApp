package com.venkat.project.uber.uberApp.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.Strategies.RideStrategyManager;
import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.RideDto;
import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.RideRequest;
import com.venkat.project.uber.uberApp.entities.Rider;
import com.venkat.project.uber.uberApp.entities.User;
import com.venkat.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.venkat.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.venkat.project.uber.uberApp.repositories.RideRequestRepository;
import com.venkat.project.uber.uberApp.repositories.RiderRepository;
import com.venkat.project.uber.uberApp.services.RiderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService{
	
	private final ModelMapper modelMapper;
	private RideStrategyManager rideStrategyManager;
	private final RideRequestRepository rideRequestRepository;
	private final RiderRepository riderRepository;

	@Override
	public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
		
		Rider rider = getCurrentRider();
		RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
		rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
		
		Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
		rideRequest.setFare(fare);
		
		RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);
		
		rideStrategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);
//		log.info(rideRequest.toString());
		return modelMapper.map(savedRideRequest, RideRequestDto.class);
	}

	@Override
	public RideDto cancelRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDto rateDriver(Long rideId, Integer rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDto getMyProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RideDto> getAllMyRides() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Rider createNewRider(User user) {
		Rider rider = Rider
					.builder()
					.user(user)
					.rating(0.0)
					.build();
		return riderRepository.save(rider);
	}
	
	@Override
	public Rider getCurrentRider() {
		//TO DO: impleemt Spring Security
		return riderRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(
				"Rider not found with id:" +1
				));
	}
	
	

}
