package com.orderInventory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderInventory.Dto.LoginInputDto;
import com.orderInventory.Dto.LoginOutputDto;
import com.orderInventory.Repository.LoginRepository;
import com.orderInventory.entity.Login;
import com.orderInventory.exception.CustomersNotFoundException;
import com.orderInventory.exception.InvalidCredentialsException;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginRepository loginRepository;

	@Override
	public LoginOutputDto customerLogin(LoginInputDto loginInputDto) throws InvalidCredentialsException,CustomersNotFoundException {
		
		Optional<Login> optionalList=loginRepository.findById(loginInputDto.getEmail());
		
		if(optionalList.isPresent()) {
			
			Login login = optionalList.get();
			
			if(loginInputDto.getPassword().equals(login.getPassword()) && loginInputDto.getCategory().equals(login.getCategory())) {
				
				login.setLogin(true);
				
				Login newLogin = loginRepository.save(login);
				
				LoginOutputDto loginOutputDto = new LoginOutputDto();
				
				loginOutputDto.setEmail(newLogin.getEmail());
				loginOutputDto.setCategory("customer");
				loginOutputDto.setLogin(newLogin.isLogin());
				
				return loginOutputDto;
				
			}
			else {
				throw new InvalidCredentialsException("Invalid email/Password, try again");
			}
		}
		else {
			
			throw new CustomersNotFoundException("No Customer found with email: "+loginInputDto.getEmail());
		}		
		
	}	

}
