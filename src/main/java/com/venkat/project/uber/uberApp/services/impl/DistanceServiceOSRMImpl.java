package com.venkat.project.uber.uberApp.services.impl;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.venkat.project.uber.uberApp.services.DistanceService;

import lombok.Data;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {
	
	private static final String OSRM_API_BASE_URL = "http://router.project-osrm.org/route/v1/driving/";
	
	@Override
	public double calculateDistance(Point src, Point dest) {
		
		
		//calls the third party API OSRM
		try {
			String uri = src.getX()+ ","+src.getY()+";"+dest.getX()+","+dest.getY();
			OSRMResponseDto responseDto = RestClient.builder()
					  .baseUrl(OSRM_API_BASE_URL)
					  .build()
					  .get()
					  .uri(uri)
					  .retrieve()
					  .body(OSRMResponseDto.class);

			//converting meters to kilometers from response of OSRM
			return responseDto.getRoutes().get(0).getDistance()/ 1000.0;
		}catch (Exception e) {
			throw new RuntimeException("Error getting data from OSRM" + e.getMessage());
		}
		
	}

}

@Data
class OSRMResponseDto{
	private List<OSRMRoute> routes;
	
}

@Data
class OSRMRoute {
	private Double distance;
}