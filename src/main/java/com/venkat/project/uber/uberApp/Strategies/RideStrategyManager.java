package com.venkat.project.uber.uberApp.Strategies;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.venkat.project.uber.uberApp.Strategies.Impl.DriverMatchingHighestRatedDriverStrategy;
import com.venkat.project.uber.uberApp.Strategies.Impl.DriverMatchingNearestDriverStrategy;
import com.venkat.project.uber.uberApp.Strategies.Impl.RideFareDefaultFareCalculationStrategy;
import com.venkat.project.uber.uberApp.Strategies.Impl.RideFareSurgePricingCalculationStrategy;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

	 private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
	    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
	    private final RideFareSurgePricingCalculationStrategy surgePricingFareCalculationStrategy;
	    private final RideFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

	    public DriverMatchingStrategy driverMatchingStrategy(double riderRating) {
	        if(riderRating >= 4.8) {
	            return highestRatedDriverStrategy;
	        } else {
	            return nearestDriverStrategy;
	        }
	    }

	    public RideFareCalculationStrategy rideFareCalculationStrategy() {

//	        6PM to 9PM is SURGE TIME
	        LocalTime surgeStartTime = LocalTime.of(18, 0);
	        LocalTime surgeEndTime = LocalTime.of(21, 0);
	        LocalTime currentTime = LocalTime.now();

	        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

	        if(isSurgeTime) {
	            return surgePricingFareCalculationStrategy;
	        } else {
	            return defaultFareCalculationStrategy;
	        }
	    }

}
