package com.orderInventory.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderInventory.Dto.InventoryDto;
import com.orderInventory.Repository.InventoryRepository;
import com.orderInventory.Repository.OrdersRepository;
import com.orderInventory.Repository.ProductsRepository;
import com.orderInventory.Repository.StoresRepository;
import com.orderInventory.entity.Inventory;
import com.orderInventory.entity.Orders;
import com.orderInventory.exception.InventoryNotFoundException;


@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private ProductsRepository productRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private StoresRepository storeRepository;
	@Autowired
	OrdersRepository ordersRepository;

	
	
	@Override
	public Inventory getAllProductAndStoreDetails(int inventoryId) throws InventoryNotFoundException {
		
		Optional<Inventory> optionalInventory=inventoryRepository.findById(inventoryId);
		if(optionalInventory.isEmpty())
		{
			throw new InventoryNotFoundException("Inventory id not found with "+inventoryId);
		}
		Inventory inventoryList=optionalInventory.get();
		return inventoryList;
	}


	
	@Override
	public List<InventoryDto> getInventoryByStoreId(int storeId) throws InventoryNotFoundException{
		
		List<Inventory> inventoryList = inventoryRepository.findByStoreId_storeId(storeId);
		
		if(inventoryList.isEmpty()) {
			
			throw new InventoryNotFoundException("No Inventory found for store with Id: "+storeId);
			
		}		

        return inventoryList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private InventoryDto mapToDto(Inventory inventory) {
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setInventoryId(inventory.getInventoryId());
        inventoryDto.setStoreId(inventory.getStoreId().getStoreId());
        inventoryDto.setProductId(inventory.getProductId().getProductId());
        inventoryDto.setProductInventory(inventory.getProductInventory());

        // Fetch additional details from other repositories
        inventoryDto.setStoreName(inventory.getStoreId().getStoreName());
        inventoryDto.setProductName(inventory.getProductId().getProductName());
        inventoryDto.setUnitPrice(inventory.getProductId().getUnitPrice());
        inventoryDto.setColour(inventory.getProductId().getColour());
        inventoryDto.setBrand(inventory.getProductId().getBrand());
        inventoryDto.setSize(inventory.getProductId().getSize());
        inventoryDto.setRating(inventory.getProductId().getRating());

        // Fetch order status from Orders repository
        
        List<Orders> ordersList = ordersRepository.findByStoreId_StoreId(inventory.getStoreId().getStoreId());

     
     if (!ordersList.isEmpty()) {
         inventoryDto.setOrderStatus(ordersList.get(0).getOrderStatus());
     } else {
         inventoryDto.setOrderStatus(null);
     }

        return inventoryDto;
    }
		
		
	
	
	

	

}
