package com.venkat.project.uber.uberApp.services.impl;

import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.services.DistanceService;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {
	
	@Override
	public double calculateDistance(Point src, Point dest) {
		
		//call the third party API OSRM
		
		return 0;
	}

}
