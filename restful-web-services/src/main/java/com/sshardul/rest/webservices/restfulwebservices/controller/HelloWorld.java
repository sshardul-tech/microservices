package com.sshardul.rest.webservices.restfulwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sshardul.rest.webservices.restfulwebservices.pojo.HelloWorldBean;

//@RestController
@Controller
public class HelloWorld {

	@Autowired
	MessageSource messageSource;
	
	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello/bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/hello/bean/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	@GetMapping(path = "/hello/i18n")
	public String helloWorldInternationalised() {
		
		return messageSource.getMessage("hello.world",null,"Default Message",LocaleContextHolder.getLocale());
	}
}
