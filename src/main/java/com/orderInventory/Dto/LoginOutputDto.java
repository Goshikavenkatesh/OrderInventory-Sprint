package com.orderInventory.Dto;

import lombok.Data;

@Data
public class LoginOutputDto {
	
	private String email;
	private String category;
	private boolean isLogin;

}
