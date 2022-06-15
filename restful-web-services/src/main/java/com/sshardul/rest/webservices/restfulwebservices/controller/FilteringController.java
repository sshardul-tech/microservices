package com.sshardul.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sshardul.rest.webservices.restfulwebservices.pojo.StaticFilter;

@RestController
public class FilteringController {

	//just comment @JsonFilter
	@GetMapping(path = "/static-filter")
	public List<StaticFilter> staticFilter() {
		return Arrays.asList(new StaticFilter("Sandhya", "Kumari", "Shardul"),
				new StaticFilter("Vaibhav", "Anurag", "Raj"));
	}

	@GetMapping(path = "/dynamic-filter")
	public MappingJacksonValue dynamicFilter() {

		List<StaticFilter> list = Arrays.asList(new StaticFilter("Sandhya", "Kumari", "Shardul"),
				new StaticFilter("Vaibhav", "Anurag", "Raj"));
		SimpleBeanPropertyFilter b = SimpleBeanPropertyFilter.filterOutAllExcept("fname", "lname");

		FilterProvider fp = new SimpleFilterProvider().addFilter("dynamic-filter", b);

		MappingJacksonValue value = new MappingJacksonValue(list);
		value.setFilters(fp);
		return value;
	}
}
