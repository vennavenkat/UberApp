package com.venkat.project.uber.uberApp.services;

import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.SignupDto;
import com.venkat.project.uber.uberApp.dto.UserDto;

public interface AuthService {
	
	String login(String email, String password);
	
	DriverDto onboardNewDriver(Long userId);

	UserDto signup(SignupDto signupDto);
}
