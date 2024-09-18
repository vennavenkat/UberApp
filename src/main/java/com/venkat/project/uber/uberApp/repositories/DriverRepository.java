package com.venkat.project.uber.uberApp.repositories;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.venkat.project.uber.uberApp.entities.Driver;

//ST_Distance(point1, point2)
//ST_DWithin(point1, 10000)

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
	

	//postgis is used in this query
	@Query("SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance "  +
			"FROM driver AS d " +
			"where available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
			"ORDER BY distance " +
			"LIMIT 10"
			)
	
	List<Driver> findNearestDrivers(Point pickupLocation);

}
