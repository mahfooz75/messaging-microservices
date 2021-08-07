package com.example.orderservice.cache;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.orderservice.entity.Product;

public final class MySimpleCache {

	private static final Logger LOGGER = LoggerFactory.getLogger(MySimpleCache.class);
	private final static HashMap<Integer, Product> PRODUCT_CACHE = new HashMap<Integer, Product>();

	private MySimpleCache() {
	}

	public synchronized static Product get(Integer id) {
		Product product = PRODUCT_CACHE.get(id);
		if (product == null) {
			LOGGER.info("cache miss for key: " + id);
		} else {
			LOGGER.info("cache hit for key:" + id);
		}
		return product;
	}

	public synchronized static void put(Product product) {
		LOGGER.info("Insert/Udate key: " + product.getId() + " into cache");
		PRODUCT_CACHE.put(product.getId(), product);
	}

}
