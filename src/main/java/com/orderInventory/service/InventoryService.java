package com.orderInventory.service;

import java.util.List;

import com.orderInventory.Dto.InventoryDetailsDto;
import com.orderInventory.Dto.InventoryDto;
import com.orderInventory.Dto.OrderInventoryDto;
import com.orderInventory.entity.Inventory;
import com.orderInventory.exception.InventoryNotFoundException;

public interface InventoryService {
	
	
	public Inventory getAllProductAndStoreDetails(int inventoryId) throws InventoryNotFoundException;

	List<InventoryDto> getInventoryByStoreId(int storeId) throws InventoryNotFoundException;

	OrderInventoryDto getInventoryByOrderId(int orderId) throws InventoryNotFoundException;
	
	
}

