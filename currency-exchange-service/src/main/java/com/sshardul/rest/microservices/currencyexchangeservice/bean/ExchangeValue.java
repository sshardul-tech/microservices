package com.sshardul.rest.microservices.currencyexchangeservice.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {

	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to;
	@Id
	private Long id;
	private BigDecimal multipleConversion;
	private int portNum;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getMultipleConversion() {
		return multipleConversion;
	}
	public void setMultipleConversion(BigDecimal multipleConversion) {
		this.multipleConversion = multipleConversion;
	}
	public ExchangeValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getPortNum() {
		return portNum;
	}
	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}
	
	public ExchangeValue(String from, String to, Long id, BigDecimal multipleConversion, int portNum) {
		super();
		this.from = from;
		this.to = to;
		this.id = id;
		this.multipleConversion = multipleConversion;
		this.portNum = portNum;
	}
	
	@Override
	public String toString() {
		return "ExchangeValue [from=" + from + ", to=" + to + ", id=" + id + ", multipleConversion="
				+ multipleConversion + ", portNum=" + portNum + "]";
	}
	
	
}
