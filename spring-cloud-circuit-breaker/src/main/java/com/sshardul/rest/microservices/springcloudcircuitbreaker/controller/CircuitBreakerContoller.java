package com.sshardul.rest.microservices.springcloudcircuitbreaker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerContoller {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/sample-api")
	//@Retry(name = "sample-api", fallbackMethod = "defaultResponse")
	@CircuitBreaker(name = "sample-api", fallbackMethod = "defaultResponse")
	@RateLimiter(name = "sample-api")
	public String getSample() {
		logger.info("circuit breaker example started...");
		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/dummy-url", String.class);
		return entity.getBody();
	}
	
	public String defaultResponse(Exception ex) {
		return "You are under fallbackMethod";
	}
}
