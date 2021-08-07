package com.example.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;

@RestController
@RequestMapping(value = "/v1/productservice")
public class ProductServiceController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable(name = "productId") int productId) {
		Product product = productService.getProduct(productId);
		return ResponseEntity.ok(product);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updatePrice(@RequestBody Product product) {
		productService.updatePrice(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

}