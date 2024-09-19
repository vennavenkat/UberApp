package com.venkat.project.uber.uberApp.entities;

import java.util.Set;

import org.locationtech.jts.geom.Point;

import com.venkat.project.uber.uberApp.entities.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//used only for authentication purposes
@Entity
@Table(name = "app_user")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	//In SQL if we want to store sets we need to do like this
	@ElementCollection(fetch = FetchType.LAZY)
	@Enumerated(EnumType.STRING)
	private Set<Role> roles;

}
