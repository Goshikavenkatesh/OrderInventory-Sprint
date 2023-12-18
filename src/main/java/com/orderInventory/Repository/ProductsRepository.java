package com.orderInventory.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orderInventory.entity.Inventory;
import com.orderInventory.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {

	List<Products> findByUnitPriceBetween(BigDecimal minUnitPrice, BigDecimal maxUnitPrice);

	List<Products> findByUnitPriceGreaterThanEqual(BigDecimal minUnitPrice);

	List<Products> findByUnitPriceLessThanEqual(BigDecimal maxUnitPrice);
	
	@Query(nativeQuery = true, value="SELECT * from products ORDER BY :field :sortBy")
	List<Products> findAllProductsByField(String field, String sortBy);
	

}
