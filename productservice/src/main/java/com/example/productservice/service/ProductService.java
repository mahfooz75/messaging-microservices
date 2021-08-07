package com.example.productservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.productservice.entity.Product;

@Service
@EnableBinding(Source.class)
public class ProductService {

	@Autowired
	private Source source;

	private List<Product> productList = new ArrayList<Product>();

	public ProductService() {
		productList.add(new Product(1, 10.00, "Product 1"));
		productList.add(new Product(2, 20.00, "Product 2"));
		productList.add(new Product(3, 30.00, "Product 3"));
		productList.add(new Product(4, 40.00, "Product 4"));
		productList.add(new Product(5, 50.00, "Product 5"));
		productList.add(new Product(6, 60.00, "Product 6"));
		productList.add(new Product(7, 70.00, "Product 7"));
		productList.add(new Product(8, 80.00, "Product 8"));
		productList.add(new Product(9, 90.00, "Product 9"));
		productList.add(new Product(10, 100.00, "Product 10"));
	}

	public Product getProduct(int productId) {
		return productList.stream().filter(product -> productId == product.getId()).findFirst().get();
	}

	public void updatePrice(Product product) {
		Product p = getProduct(product.getId());
		p.setPrice(product.getPrice());
		source.output().send(MessageBuilder.withPayload(p).build());
	}

}
