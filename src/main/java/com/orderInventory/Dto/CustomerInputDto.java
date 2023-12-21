package com.orderInventory.Dto;

import lombok.Data;

@Data
public class CustomerInputDto {
	
	private int customerId;
	private String fullName;
	private String emailAddress;
	private String password;
	private String category;

}
