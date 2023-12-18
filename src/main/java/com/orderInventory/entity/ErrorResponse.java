package com.orderInventory.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private int status; 
	String message;
	LocalDateTime timeStamp;


}
