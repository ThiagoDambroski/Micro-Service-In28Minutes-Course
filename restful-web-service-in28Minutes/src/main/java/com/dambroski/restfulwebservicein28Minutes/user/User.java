package com.dambroski.restfulwebservicein28Minutes.user;

import java.time.LocalDate;

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
	
	private String name;
	
	private LocalDate birthDate;

}
