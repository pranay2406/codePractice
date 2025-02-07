package com.htc.MavenDemo.Exception;

import java.time.LocalDateTime;

public class EmployeeException extends Exception{
	 private String errorMessage;
	 private LocalDateTime errrorOccuredTime;
	 
	public String getErrorMessage() {
		return errorMessage;
	}
	public LocalDateTime getErrrorOccuredTime() {
		return errrorOccuredTime;
	}
	
	public EmployeeException(String errorMessage, LocalDateTime errrorOccuredTime) {
		super();
		this.errorMessage = errorMessage;
		this.errrorOccuredTime = errrorOccuredTime;
	}	 

}
