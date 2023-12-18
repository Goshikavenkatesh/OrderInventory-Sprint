package com.orderInventory.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class OrderItemsId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orderId;

}
