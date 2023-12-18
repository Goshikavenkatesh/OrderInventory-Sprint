package com.orderInventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryId;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Stores storeId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products productId;
	
	private int productInventory;

}
