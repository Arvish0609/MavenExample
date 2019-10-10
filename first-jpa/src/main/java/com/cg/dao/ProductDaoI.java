package com.cg.dao;

import java.util.List;

import com.cg.entity.Product;

public interface ProductDaoI {
	int save(Product p);
	
	Product fetch(int code);
	
	void delete(int code);
	
	List<Product> fetchAll();

}
