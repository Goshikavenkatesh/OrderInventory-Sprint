package com.orderInventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.orderInventory.Repository.ProductsRepository;
import com.orderInventory.entity.Products;
import com.orderInventory.exception.ProductsNotFoundException;
import com.orderInventory.service.ProductsServiceImpl;

@SpringBootTest
public class ProductsTest {
	
	@Mock
	   private ProductsRepository productRepository;
		@InjectMocks
	   ProductsServiceImpl productService = new  ProductsServiceImpl();
		@Test
		void saveProduct() {
			Products product=new Products();
		    product.setProductId(121);
		    product.setProductName("Iphone");
		   // product.setUnitPrice(989899889.00);
		   when(productRepository.save(product)).thenReturn(product);
		   Products newProduct=productRepository.save(product);
		   assertEquals("Iphone", newProduct.getProductName());
		}
		
		
		 @Test
		    void fetchAllProducts_ReturnsNonEmptyList() throws ProductsNotFoundException {
		        // Mocking the findAll method of the repository
		        List<Products> mockProductList = new ArrayList<>();
		        mockProductList.add(new Products(/* Add product details here */));
		        when(productRepository.findAll()).thenReturn(mockProductList);

		        // Calling the fetchAllProducts method of the service
		        List<Products> result = productService.fetchAllProducts();

		        // Verifying that the findAll method of the repository was called once
		        verify(productRepository, times(1)).findAll();

		        // Asserting that the result is not null and the size is greater than 0
		        assertNotNull(result);
		        assertTrue(result.size() > 0);
		    }
		 
		   @Test
		    void updateProducts_SuccessfulUpdate() throws ProductsNotFoundException {
		        // Mocking an existing product
		        Products existingProduct = new Products();
		        when(productRepository.findById(existingProduct.getProductId())).thenReturn(Optional.of(existingProduct));

		        // Calling the updateProducts method with an updated product
		        String result = productService.updateProducts(existingProduct);

		        // Verifying that findById and save methods of the repository were called once each
		        verify(productRepository, times(1)).findById(existingProduct.getProductId());
		        verify(productRepository, times(1)).save(existingProduct);

		        // Asserting that the result message is as expected
		        assertEquals("Record Updated Successfully", result);
		    }
		   
		   @Test
		    void deleteById() throws ProductsNotFoundException {
		        int id = 121;
		        Products product = new Products();
		        product.setProductId(id);
		        product.setProductName("Iphone");
	 
		        when(productRepository.findById(id)).thenReturn(Optional.of(product));
		        productService.deleteProductsById(id);
	 
		        verify(productRepository, times(1)).deleteById(id);
		    }
		   
		    @Test
		    public void testGetProductsByUnitPriceRange() throws ProductsNotFoundException {
		        // Mock data
		        BigDecimal minUnitPrice = new BigDecimal("10.00");
		        BigDecimal maxUnitPrice = new BigDecimal("20.00");

		        Products product1 = new Products();
		        Products product2 = new Products();
		        List<Products> mockProductList = Arrays.asList(product1, product2);

		        // Mocking repository behavior
		        when(productRepository.findByUnitPriceBetween(minUnitPrice, maxUnitPrice)).thenReturn(mockProductList);

		        // Call the service method
		        List<Products> result = productService.getProductsByUnitPriceRange(minUnitPrice, maxUnitPrice);

		        // Verify repository method was called with correct parameters
		        verify(productRepository, times(1)).findByUnitPriceBetween(minUnitPrice, maxUnitPrice);

		        // Verify the result
		        assertEquals(mockProductList, result);
		    }
		    
		    @Test
		    public void testUpdateProductNameById_Success() throws ProductsNotFoundException {
		        // Arrange
		        int productId = 1;
		        Products existingProduct = new Products();
		        existingProduct.setProductId(productId);
		        existingProduct.setProductName("OldProductName");

		        Products updatedProduct = new Products();
		        updatedProduct.setProductId(productId);
		        updatedProduct.setProductName("NewProductName");

		        // Mocking repository behavior
		        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
		        when(productRepository.save(any())).thenReturn(updatedProduct);

		        // Act
		        Products result = productService.updateProductNameById(productId, updatedProduct);

		        // Assert
		        assertEquals(updatedProduct.getProductName(), result.getProductName());
		        verify(productRepository, times(1)).findById(productId);
		        verify(productRepository, times(1)).save(any());
		    }
		   
		}
