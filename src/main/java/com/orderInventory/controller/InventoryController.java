package com.orderInventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.orderInventory.Dto.InventoryDto;
import com.orderInventory.Dto.OrderInventoryDto;
import com.orderInventory.entity.Inventory;
import com.orderInventory.exception.InventoryNotFoundException;
import com.orderInventory.service.InventoryService;

import jakarta.validation.Valid;

@RestController
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/api/v1/inventory/{id}")
	public ResponseEntity<Inventory> getAllProductAndStoreDetails(@Valid @PathVariable("id") int inventoryId) throws InventoryNotFoundException {
	    Inventory inventory = inventoryService.getAllProductAndStoreDetails(inventoryId);
	    return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	@GetMapping("/api/v1/inventory/store/{storeId}")
	public ResponseEntity<List<InventoryDto>> getInventoryByStoreId(@PathVariable int storeId) throws InventoryNotFoundException {
		
		List<InventoryDto> inventoryByStoreId = inventoryService.getInventoryByStoreId(storeId);
		
		return new ResponseEntity<List<InventoryDto>>(inventoryByStoreId,HttpStatus.OK);
		
		
	}
	
	

	  @GetMapping("/api/v1/inventory/order/{orderid}")
	   public ResponseEntity<OrderInventoryDto> getInventoryByOrderId(@PathVariable int orderid) {
	        try {
	        	 OrderInventoryDto result = inventoryService.getInventoryByOrderId(orderid);
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } catch (InventoryNotFoundException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}


