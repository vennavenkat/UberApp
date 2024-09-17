package com.venkat.project.uber.uberApp.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.Rider;
import com.venkat.project.uber.uberApp.entities.enums.PaymentMethod;
import com.venkat.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.venkat.project.uber.uberApp.entities.enums.RideStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {
	
	private Long id;
	private Point pickupLocation;
	
	private Point dropOffLOcation;
	
	private LocalDateTime requestTime;
	
	private RiderDto rider;
	
	private PaymentMethod paymentMethod;
	
	private RideRequestStatus rideRequestStatus;


}
