package com.orderInventory.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderInventory.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository <Inventory,Integer>{

	List<Inventory> findByStoreId_storeId(int storeId);

	Optional<Inventory> findByStoreId_StoreId(int storeId);
	
	

	

	
}
