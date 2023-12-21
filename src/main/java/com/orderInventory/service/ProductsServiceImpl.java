package com.orderInventory.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderInventory.Repository.ProductsRepository;
import com.orderInventory.entity.Products;
import com.orderInventory.exception.ProductsNotFoundException;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;

	@Override
	public List<Products> fetchAllProducts()throws ProductsNotFoundException {
    List<Products> productList=productsRepository.findAll();
    if (productList.isEmpty()) {
     throw new ProductsNotFoundException("No products found");
    }
		
    return productList;
}

	@Override
	public Products addProduct(Products products) {
		Products addProduct = productsRepository.save(products);
		System.out.println("Getting data from DB:" + addProduct);
	    return addProduct;
		
	}
	
	@Override
	public String updateProducts(Products products) throws ProductsNotFoundException {
    Optional<Products> existingProduct = productsRepository.findById(products.getProductId());
    if (existingProduct.isPresent()) {
    productsRepository.save(products);
	return "Record Updated Successfully";
	}else {
        throw new ProductsNotFoundException("No product found with ID: " + products.getProductId());
          }
}

	 

	@Override
	public String deleteProductsById(int productsId) throws ProductsNotFoundException {
	Optional<Products> optionalProduct=productsRepository.findById(productsId);
		if (optionalProduct.isPresent()) {
		productsRepository.deleteById(productsId);
		return "Record Deleted Succesfully";
		}else 
		{
	         throw new ProductsNotFoundException("Product with ID " + productsId + " not found");
	    }
	}

	@Override
	public List<Products> getProductsByUnitPriceRange(BigDecimal minUnitPrice, BigDecimal maxUnitPrice) throws ProductsNotFoundException {
		 if (minUnitPrice != null && maxUnitPrice != null) {
             return productsRepository.findByUnitPriceBetween(minUnitPrice, maxUnitPrice);
         } else if (minUnitPrice != null) {
             return productsRepository.findByUnitPriceGreaterThanEqual(minUnitPrice);
         } else if (maxUnitPrice != null) {
             return productsRepository.findByUnitPriceLessThanEqual(maxUnitPrice);
        } else {
        	throw new ProductsNotFoundException("Both min and max unit prices are null");
         }
     }

	@Override
	public List<Products> getSortedProductsByField(String field, String sortBy) throws ProductsNotFoundException {
	List<Products> products= productsRepository.findAllProductsByField(field, sortBy);
	 if (products.isEmpty()) {
         throw new ProductsNotFoundException("No products found");
     }
		
		return products;
	}

	@Override
	public Products updateProductNameById(int productId, Products product) throws ProductsNotFoundException {
		Optional<Products> optionalProduct=productsRepository.findById(productId);
		if(optionalProduct.isEmpty())
		{
			throw new ProductsNotFoundException("Product id is not available with "+productId);
		}
		Products updateProduct=optionalProduct.get();
		updateProduct.setProductName(product.getProductName());
		//updateProduct.setUnitPrice(product.getUnitPrice());
		
		productsRepository.save(updateProduct);	
		
		return updateProduct;
		
	}
	
	

}
