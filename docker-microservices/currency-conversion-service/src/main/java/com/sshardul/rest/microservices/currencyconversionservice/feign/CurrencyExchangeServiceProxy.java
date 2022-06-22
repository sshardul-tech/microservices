package com.sshardul.rest.microservices.currencyconversionservice.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sshardul.rest.microservices.currencyconversionservice.bean.CurrencyConverter;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")//need to pass request through gateway
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//@GetMapping("/currency-exchange-service/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange-service/{from}/to/{to}")
	public CurrencyConverter getExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);
	
}
