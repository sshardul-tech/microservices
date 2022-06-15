package com.sshardul.rest.webservices.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sshardul.rest.webservices.limitservice.bean.LimitService;
import com.sshardul.rest.webservices.limitservice.config.LimitConfiguration;

@RestController
public class LimitsServiceController {

	@Autowired
	LimitConfiguration limitConfiguration;
	
	@GetMapping("/limits")
	public LimitService getLimitConfig() {
		return new LimitService(limitConfiguration.getMax(),limitConfiguration.getMin());
	}
}
