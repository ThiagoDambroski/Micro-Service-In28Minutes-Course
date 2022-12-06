package com.dambroski.restfulwebservicein28Minutes.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-list")//field 2 and filed3
	public MappingJacksonValue filteringList(){
		
		List<SomeBean> list = Arrays.asList(new SomeBean("value1","valu2","value 3")
				,new SomeBean("value4","value5","value6"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","filed3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
		
	}
}
