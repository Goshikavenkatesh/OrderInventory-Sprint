package com.orderInventory.Dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class InventoryDetailsDto {
	
	 private List<ProductsDto> products;
	 private StoresDto store;
	 private ShipsmentsDto shipment;
	 private BigDecimal totalAmount;

}
