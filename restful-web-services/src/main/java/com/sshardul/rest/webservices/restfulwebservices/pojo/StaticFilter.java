package com.sshardul.rest.webservices.restfulwebservices.pojo;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("dynamic-filter")
public class StaticFilter {

	String fname;
	String mname;
	String lname;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public StaticFilter(String fname, String mname, String lname) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
	}
	
	@Override
	public String toString() {
		return "StaticFilter [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
	}
	
	
	
	
}
