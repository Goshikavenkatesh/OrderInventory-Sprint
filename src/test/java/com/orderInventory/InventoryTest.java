package com.orderInventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.orderInventory.Repository.InventoryRepository;
import com.orderInventory.Repository.OrdersRepository;
import com.orderInventory.Repository.ProductsRepository;
import com.orderInventory.Repository.StoresRepository;
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
