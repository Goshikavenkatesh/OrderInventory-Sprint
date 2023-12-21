package com.orderInventory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.orderInventory.Dto.InventoryDto;
import com.orderInventory.Repository.InventoryRepository;
import com.orderInventory.Repository.OrdersRepository;
import com.orderInventory.Repository.ProductsRepository;
import com.orderInventory.Repository.StoresRepository;
import com.orderInventory.controller.InventoryController;
import com.orderInventory.entity.Inventory;
import com.orderInventory.exception.InventoryNotFoundException;
import com.orderInventory.service.InventoryServiceImpl;

    @SpringBootTest
	public class InventoryTest {
    	
    	@Mock
    	private ProductsRepository productRepository;

    	@Mock
    	private InventoryRepository inventoryRepository;

    	@Mock
    	private StoresRepository storeRepository;

    	@InjectMocks
    	private InventoryServiceImpl inventoryService;
    	
    	  @InjectMocks
    	    private InventoryController inventoryController;
    	
    	 @Mock
    	  private OrdersRepository ordersRepository;
    	 
    	 

    	@Test
    	void getAllProductAndStoreDetails() throws InventoryNotFoundException {
    		// Positive test case
    		// Arrange
    		int inventoryId = 1;
    		Inventory expectedInventory = new Inventory();
    		expectedInventory.setInventoryId(inventoryId);

    		when(inventoryRepository.findById(inventoryId)).thenReturn(Optional.of(expectedInventory));

    		// Act
    		Inventory result = inventoryService.getAllProductAndStoreDetails(inventoryId);

    		
    		assertEquals(inventoryId, result.getInventoryId());
    	}
    	
    	
    	 
       
    }


