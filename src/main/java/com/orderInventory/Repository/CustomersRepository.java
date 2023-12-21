package com.orderInventory.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderInventory.entity.Customers;
import com.orderInventory.entity.Inventory;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer>{

	 Optional<Customers> findById(Integer customerId);
	
	

}
