package com.orderInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderInventory.entity.Shipments;

@Repository
public interface ShipmentsRepository extends JpaRepository<Shipments,Integer>{

}
