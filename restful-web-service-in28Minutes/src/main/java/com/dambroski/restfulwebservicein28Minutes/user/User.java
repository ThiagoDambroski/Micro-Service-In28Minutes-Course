package com.dambroski.restfulwebservicein28Minutes.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	private Long id;
	
	@Size(min = 2,message = "name should have at least 2 characters")
	private String name;
	
	@Past(message = "the date must be on the past")
	private LocalDate birthDate;

}
