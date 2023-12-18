package com.orderInventory.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	private Timestamp orderTms;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customerId;
	
	private String orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
    private Stores storeId;
	

}
