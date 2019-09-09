package com.stacksimplify.restservices.exceptions;

import java.util.Date;

//Simple Customer error details

public class CustomErrorDetails {
	
	public CustomErrorDetails(java.util.Date timestamp, String message, String errorDetails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	private Date timestamp;
	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getErrorDetails() {
		return errorDetails;
	}
	private String message;
	private String errorDetails;
	
}
