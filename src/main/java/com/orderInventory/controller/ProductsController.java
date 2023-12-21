package com.orderInventory.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderInventory.entity.Products;
import com.orderInventory.exception.ProductsNotFoundException;
import com.orderInventory.service.ProductsService;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;


@RestController
@Validated
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	
	@GetMapping("/api/v1/products/fetchAll")
	public  ResponseEntity<List<Products>> getAllProducts() throws ProductsNotFoundException
	{
		List<Products> productList=productsService.fetchAllProducts();
		if(productList == null || productList.isEmpty())
		{
			throw new ProductsNotFoundException("No products found");
		}
		return new ResponseEntity<List<Products>>(productList,HttpStatus.OK);
	}
	
	
	@PostMapping("/api/v1/product/addProduct")
    public Products addProduct(@RequestBody Products products) {
        Products addProduct = productsService.addProduct(products);
        return addProduct;
        
    }
	
	@PutMapping("api/v1/products/updateProducts")
    public String updateCustomer(@RequestBody Products products) throws ProductsNotFoundException
	{
		return productsService.updateProducts(products);
    }
	
	
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> deleteProductById(@PathVariable("id") int productId) throws ProductsNotFoundException {
		productsService.deleteProductsById(productId);
		return new ResponseEntity<String>("Product Deleted", HttpStatus.OK);
    }
	
	@GetMapping("/api/v1/products/unitprice")
	public ResponseEntity<List<Products>> getProductsByUnitPriceRange(
	        @RequestParam(name = "min", required = false)
	        @DecimalMin(value = "1000", inclusive = true, message = "min must be greater than 1000")
	        BigDecimal minUnitPrice,
	        @RequestParam(name = "max", required = false)
	        @DecimalMax(value = "9000", inclusive = true, message = "max must be less than or equal to 9000")
	        BigDecimal maxUnitPrice) throws ProductsNotFoundException {
	    List<Products> products = productsService.getProductsByUnitPriceRange(minUnitPrice, maxUnitPrice);
	    return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
    @GetMapping("/api/v1/products/sort/byField")
	public List<Products> getSortedProductsByField(@RequestParam String field, @RequestParam(defaultValue = "asc")String sortBy) throws ProductsNotFoundException{
	List<Products> products = productsService.getSortedProductsByField(field, sortBy);
	return products;
		
	}
    
    @PutMapping("/update/productname/{id}")
	public  ResponseEntity<Products> updateProductNameById(@PathVariable("id") int productId, @RequestBody Products product) throws ProductsNotFoundException {
		Products newProduct = productsService.updateProductNameById(productId, product);
		return new ResponseEntity<Products>(newProduct, HttpStatus.OK);
	}
	
   
}
