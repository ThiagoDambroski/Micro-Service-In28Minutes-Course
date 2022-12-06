package com.dambroski.restfulwebservicein28Minutes.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue(generator = "user_id",strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min = 2,message = "name should have at least 2 characters")
	@JsonProperty("user_name")
	private String name;
	
	@Past(message = "the date must be on the past")
	@JsonProperty("birth_date")
	private LocalDate birthDate;

}
