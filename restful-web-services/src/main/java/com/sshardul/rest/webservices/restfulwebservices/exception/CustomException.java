package com.sshardul.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class CustomException {

	private Date ts;
	private String statusCode;
	private String message;
	private String path;
	
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public CustomException(Date ts, String statusCode, String message, String path) {
		super();
		this.ts = ts;
		this.statusCode = statusCode;
		this.message = message;
		this.path = path;
	}
}
