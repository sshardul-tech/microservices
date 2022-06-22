package com.sshardul.rest.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConverter {

	private Long Id;
	private String from;
	private String to;
	private BigDecimal multipleConversion;
	private BigDecimal quantity;
	private int portNum;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getMultipleConversion() {
		return multipleConversion;
	}
	public void setMultipleConversion(BigDecimal multipleConversion) {
		this.multipleConversion = multipleConversion;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public int getPortNum() {
		return portNum;
	}
	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}
	public CurrencyConverter(Long id, String from, String to, BigDecimal multipleConversion, BigDecimal quantity,
			int portNum) {
		super();
		Id = id;
		this.from = from;
		this.to = to;
		this.multipleConversion = multipleConversion;
		this.quantity = quantity;
		this.portNum = portNum;
	}
	public CurrencyConverter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CurrencyConverter [Id=" + Id + ", from=" + from + ", to=" + to + ", multipleConversion="
				+ multipleConversion + ", quantity=" + quantity + ", portNum=" + portNum + "]";
	}
	
}
