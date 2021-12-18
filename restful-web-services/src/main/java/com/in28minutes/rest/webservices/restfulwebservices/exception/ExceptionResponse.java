package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamps;
	private String message;
	private String details;


	public ExceptionResponse(Date timestamps, String message, String details) {
		super();
		this.timestamps = timestamps;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(Date timestamps) {
		this.timestamps = timestamps;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
