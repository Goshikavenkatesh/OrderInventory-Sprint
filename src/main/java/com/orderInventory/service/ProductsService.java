package com.orderInventory.service;

import java.math.BigDecimal;
import java.util.List;

import com.orderInventory.entity.Products;
import com.orderInventory.exception.ProductsNotFoundException;

public interface ProductsService {
	
	public List<Products> fetchAllProducts()throws ProductsNotFoundException;
	Products addProduct(Products product);
	String updateProducts(Products products)throws ProductsNotFoundException;
	String deleteProductsById(int productsId)throws ProductsNotFoundException;;
	List<Products> getProductsByUnitPriceRange(BigDecimal minUnitPrice, BigDecimal maxUnitPrice) throws ProductsNotFoundException;
	List<Products> getSortedProductsByField(String field, String sortBy)throws ProductsNotFoundException;
	public Products updateProductNameById(int productId,Products product) throws ProductsNotFoundException;
}
