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
	

	//postgis is used in this query ST_Distance and ST_DWithin
//	@Query("SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance "  +
//			"FROM drivers d " +
//			"WHERE available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
//			"ORDER BY distance " +
//			"LIMIT 10",nativeQuery = true)
	@Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance " +
            "FROM driver d " +
            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
            "ORDER BY distance " +
            "LIMIT 10", nativeQuery = true)
	List<Driver> findTenNearestDrivers(Point pickupLocation);
	
	
	@Query(value = "SELECT d.* " +
					"FROM driver d" +
					"WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 15000)" +
					"ORDER BY d.rating DESC " +
					"LIMIT 10", nativeQuery = true)
	List<Driver> findNearbyTopRatedDrivers(Point pickupLocation);

}
