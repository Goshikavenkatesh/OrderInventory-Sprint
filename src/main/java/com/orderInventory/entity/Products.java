package com.orderInventory.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 1, message = "Product ID must be greater than 0")
	private int productId;
	private String productName;
	private BigDecimal unitPrice;
	private String colour;
	private String brand;
	private String size;
	private int rating;


}
