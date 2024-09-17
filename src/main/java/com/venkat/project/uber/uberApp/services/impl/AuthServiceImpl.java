package com.venkat.project.uber.uberApp.services.impl;

import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.SingupDto;
import com.venkat.project.uber.uberApp.dto.UserDto;
import com.venkat.project.uber.uberApp.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Override
	public String login(String email, String password) {
		return "";
	}

	@Override
	public UserDto singup(SingupDto signupDto) {
		return null;
	}

	@Override
	public DriverDto onboardNewDriver(Long userId) {
		return null;
	}

}
