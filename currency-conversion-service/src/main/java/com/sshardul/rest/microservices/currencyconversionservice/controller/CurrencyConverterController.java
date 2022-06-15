package com.sshardul.rest.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sshardul.rest.microservices.currencyconversionservice.bean.CurrencyConverter;
import com.sshardul.rest.microservices.currencyconversionservice.feign.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConverterController {

	@Autowired
	CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	@GetMapping("/currency-converter/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverter convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> pathVariable = new HashMap<>();
		pathVariable.put("from", from);
		pathVariable.put("to", to);
		ResponseEntity<CurrencyConverter> response = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange-service/{from}/to/{to}", CurrencyConverter.class,
				pathVariable);

		CurrencyConverter currencyConverter = response.getBody();
		// CurrencyConverter con = new CurrencyConverter(101, "from", "to", 65.0,
		// quantity, 8001);
		return new CurrencyConverter(currencyConverter.getId(), currencyConverter.getFrom(), currencyConverter.getTo(),
				currencyConverter.getMultipleConversion(), quantity.multiply(currencyConverter.getMultipleConversion()),
				currencyConverter.getPortNum());
	}

	@GetMapping("/currency-converter-feign/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverter convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConverter currencyConverter = currencyExchangeServiceProxy.getExchangeValue(from, to);
		return new CurrencyConverter(currencyConverter.getId(), currencyConverter.getFrom(), currencyConverter.getTo(),
				currencyConverter.getMultipleConversion(), quantity.multiply(currencyConverter.getMultipleConversion()),
				currencyConverter.getPortNum());
	}

}
