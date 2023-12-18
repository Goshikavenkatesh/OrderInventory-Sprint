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

public class Shipments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shipmentId;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Stores storeId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customerId;
	
	private String deliveryAddress;
	private String shipmentStatus;

}