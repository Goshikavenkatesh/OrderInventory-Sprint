package com.orderInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderInventory.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer>{
	
	

}
