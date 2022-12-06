package com.dambroski.restfulwebservicein28Minutes.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties("field2")
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	private String field1;
	
	//@JsonIgnore
	private String field2;
	private String field3;
	
}
