package com.htc.orderProduct.Exception;

import java.time.LocalDateTime;

public class OrderManagementException extends Exception {
	
	private String errorMessage;
    private LocalDateTime errorOccuredTime;	
    
	public OrderManagementException(String errorMessage, LocalDateTime errorOccuredTime) {
		super();
		this.errorMessage = errorMessage;
		this.errorOccuredTime = errorOccuredTime;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public LocalDateTime getErrorOccuredTime() {
		return errorOccuredTime;
	}
    

}