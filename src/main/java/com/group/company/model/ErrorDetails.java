package com.group.company.model;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String message;
	
		
	public ErrorDetails() {
		super();
	}
	public ErrorDetails(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
