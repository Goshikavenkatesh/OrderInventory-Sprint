package com.orderInventory.Dto;

import lombok.Data;

@Data
public class LoginInputDto {
	
	private String email;
	private String password;
	private String category;

}
