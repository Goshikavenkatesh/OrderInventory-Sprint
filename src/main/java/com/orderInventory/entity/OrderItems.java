package com.orderInventory.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderItems {
	
	@EmbeddedId
	private OrderItemsId id;
	
	private int lineItemId;
	    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Products productId;

    private BigDecimal unitPrice;
    private int quantity;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipments_id")
    private Shipments shipmentId;
        

}
