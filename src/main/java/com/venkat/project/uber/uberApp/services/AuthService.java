package com.venkat.project.uber.uberApp.services;

import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.SingupDto;
import com.venkat.project.uber.uberApp.dto.UserDto;

public interface AuthService {
	
	String login(String email, String password);
	
	UserDto singup(SingupDto signupDto);
	
	DriverDto onboardNewDriver(Long userId);
}
