package com.sshardul.rest.webservices.limitservice.bean;

public class LimitService {

	private Integer max;
	private Integer min;
	
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	
	public LimitService(Integer max, Integer min) {
		super();
		this.max = max;
		this.min = min;
	}
	
	public LimitService() {
		super();
	}
	
	@Override
	public String toString() {
		return "LimitService [max=" + max + ", min=" + min + "]";
	}
	
	
	
	
}
