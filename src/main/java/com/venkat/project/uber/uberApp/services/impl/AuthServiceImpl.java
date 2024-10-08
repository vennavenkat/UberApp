package com.venkat.project.uber.uberApp.services.impl;

import java.util.Set;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.SignupDto;
import com.venkat.project.uber.uberApp.dto.UserDto;
import com.venkat.project.uber.uberApp.entities.Rider;
import com.venkat.project.uber.uberApp.entities.User;
import com.venkat.project.uber.uberApp.entities.enums.Role;
import com.venkat.project.uber.uberApp.exceptions.RuntimeConflictException;
import com.venkat.project.uber.uberApp.repositories.UserRepository;
import com.venkat.project.uber.uberApp.services.AuthService;
import com.venkat.project.uber.uberApp.services.RiderService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	private final RiderService riderService;
	
	
	@Override
	public String login(String email, String password) {
		return "";
	}

	@Override
	@Transactional
	public UserDto signup(SignupDto signupDto) {
		
		User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
		if(user != null) {
			throw new RuntimeException("Cannot signup, User already exists with email" + signupDto.getEmail());
		}
		User mappedUser = modelMapper.map(signupDto, User.class);
		mappedUser.setRoles(Set.of(Role.RIDER));
		User savedUser = userRepository.save(mappedUser);
		
		//create user related entities
		
	    riderService.createNewRider(savedUser);
	    //TODO add wallet related services here
		
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public DriverDto onboardNewDriver(Long userId) {
		return null;
	}

}
