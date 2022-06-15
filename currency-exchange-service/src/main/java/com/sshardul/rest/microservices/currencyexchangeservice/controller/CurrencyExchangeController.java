package com.sshardul.rest.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sshardul.rest.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.sshardul.rest.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	Environment environment;

	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/currency-exchange-service/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from,@PathVariable String to) {
		
		ExchangeValue value = currencyExchangeRepository.findByFromAndTo(from, to);
		value.setPortNum(Integer.parseInt(environment.getProperty("server.port")));
		return value;
		
	}
}
