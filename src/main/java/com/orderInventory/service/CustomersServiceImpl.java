package com.orderInventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderInventory.Dto.CustomerInputDto;
import com.orderInventory.Dto.CustomerOutputDto;
import com.orderInventory.Repository.CustomersRepository;
import com.orderInventory.entity.Customers;
import com.orderInventory.entity.Login;
import com.orderInventory.exception.CustomersNotFoundException;

@Service
public class CustomersServiceImpl implements CustomersService{
	
	@Autowired
	CustomersRepository customersRepository;

	@Override
	public CustomerOutputDto addCustomerDto(CustomerInputDto customerIputDto) {
Customers customers = new Customers();
		
		customers.setEmailAddress(customerIputDto.getEmailAddress());
		customers.setFullName(customerIputDto.getFullName());
		
		// create login instance
		
		Login login = new Login();
		
		login.setEmail(customerIputDto.getEmailAddress());
		login.setPassword(customerIputDto.getPassword());
		login.setCategory("customer");
		login.setLogin(false);
		
		customers.setLogin(login);
		
		Customers newCustomer = customersRepository.save(customers);
		
		CustomerOutputDto customerOutputDto = new CustomerOutputDto();
		
		customerOutputDto.setEmailAddress(newCustomer.getEmailAddress());
		customerOutputDto.setFullName(newCustomer.getFullName());
		
		return customerOutputDto;
	}

	

	@Override
	public Customers updateCustomerDto(CustomerInputDto customerIputDto) throws CustomersNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
