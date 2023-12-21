package com.orderInventory.service;

import com.orderInventory.Dto.LoginInputDto;
import com.orderInventory.Dto.LoginOutputDto;
import com.orderInventory.exception.CustomersNotFoundException;
import com.orderInventory.exception.InvalidCredentialsException;

public interface LoginService {
	
	LoginOutputDto customerLogin(LoginInputDto loginInputDto) throws InvalidCredentialsException, CustomersNotFoundException;


}
