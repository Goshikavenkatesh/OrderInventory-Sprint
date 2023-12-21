package com.orderInventory.service;

import com.orderInventory.Dto.CustomerInputDto;
import com.orderInventory.Dto.CustomerOutputDto;
import com.orderInventory.entity.Customers;
import com.orderInventory.exception.CustomersNotFoundException;

public interface CustomersService {
	
	CustomerOutputDto addCustomerDto(CustomerInputDto customerIputDto);
	Customers updateCustomerDto(CustomerInputDto customerIputDto) throws CustomersNotFoundException;


}
