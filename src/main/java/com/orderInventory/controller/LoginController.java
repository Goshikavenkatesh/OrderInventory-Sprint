package com.orderInventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderInventory.Dto.LoginInputDto;
import com.orderInventory.Dto.LoginOutputDto;
import com.orderInventory.exception.CustomersNotFoundException;
import com.orderInventory.exception.InvalidCredentialsException;
import com.orderInventory.service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/customers/login")
	public ResponseEntity<LoginOutputDto> customerLogin(@RequestBody LoginInputDto loginInputDto) throws InvalidCredentialsException,CustomersNotFoundException {
		
		LoginOutputDto loginOutputDto = loginService.customerLogin(loginInputDto);
		
		return new ResponseEntity<LoginOutputDto>(loginOutputDto,HttpStatus.OK);
	}

}
