package com.venkat.project.uber.uberApp.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.project.uber.uberApp.dto.SignupDto;
import com.venkat.project.uber.uberApp.dto.UserDto;
import com.venkat.project.uber.uberApp.services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	UserDto signup(@RequestBody SignupDto signupDto) {
		return authService.signup(signupDto);
		
	}

}
