package com.orderInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderInventory.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository <Orders,Integer>{

	List<Orders> findByStoreId_StoreId(int storeId);
	
	
	
	

}
