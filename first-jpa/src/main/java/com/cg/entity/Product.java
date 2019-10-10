package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity  //mandatory annotation , tells the code that it is an entity now
@Table(name = "prod_master")
@NamedQuery(name = "stockQuery", query = "from Product where stock >:st")
public class Product {
	@Id    //mandatory annotation
	@GeneratedValue // to auto generate value of code
	private int code;
	@Column(name = "prod_name", length = 30) // Explicitly telling to describe the length of the varchar2 
	private String name;
	private double price;
	private int stock;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

}
