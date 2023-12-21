package com.orderInventory.Dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductsDto {
	
	 private int productId;
	    private String productName;
	    private BigDecimal unitPrice;
	    private String colour;
	    private String brand;
	    private String size;
	    private int rating;

}
