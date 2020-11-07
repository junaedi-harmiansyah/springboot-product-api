package com.example.springboot.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dao.ProductRepository;
import com.example.springboot.handling.ResourceNotFoundException;
import com.example.springboot.model.Product;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	// method do get data all product
	@GetMapping("/all-product")
	public ResponseEntity<List<Product>> getAllProduct() throws ResourceNotFoundException {
		List<Product> result = productRepository.findAll();
		return ResponseEntity.ok().body(result);
	}

	// method do save data product
	@PostMapping("/add-product")
	public Product addProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}

	// method do get data product by id
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product id not found =" + id));
		return ResponseEntity.ok().body(product);
	}
	
	// method do update with get data product by id
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody Product product) throws ResourceNotFoundException {
		Product productBefore = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product id not found =" + id));
		productBefore.setModifiedBy("developer");
		productBefore.setModifiedDate(new Date());
		productBefore.setBuyDate(product.getBuyDate());
		productBefore.setDiscription(product.getDiscription());
		productBefore.setBuyPrice(product.getBuyPrice());
		productBefore.setMarketingId(product.getMarketingId());
		productBefore.setName(product.getName());
		productBefore.setSellingDate(product.getSellingDate());
		productBefore.setSellingPrice(product.getSellingPrice());
		if (product.getMarketingId() != null) {
			if (product.getMarketingId() == 1) {
				productBefore.setMarketing("OLX");
			} else if (product.getMarketingId() == 2) {
				productBefore.setMarketing("BUKA LAPAK");
			} else if (product.getMarketingId() == 3) {
				productBefore.setMarketing("TOKO PEDIA");
			} else {
				productBefore.setMarketing("LAIN-LAIN");
			}

		}
		if (product.getBuyPrice() != null && product.getSellingPrice() != null) {
			BigDecimal result = product.getSellingPrice().subtract(product.getBuyPrice());
			productBefore.setMargin(result);
		}
		productRepository.save(productBefore);
		return ResponseEntity.ok(productBefore);
	}

	// method do delete with get data product by id
	@DeleteMapping("/product/{id}")
	public Map<String, Boolean> deleteProductById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
