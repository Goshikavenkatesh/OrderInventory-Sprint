package com.orderInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderInventory.entity.Stores;

@Repository
public interface StoresRepository extends JpaRepository<Stores,Integer>{

}
