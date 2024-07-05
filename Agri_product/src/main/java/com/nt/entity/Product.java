package com.nt.entity;

import java.util.Objects;

public class Product {

	int id;
	String name;
	int batch;
	int price;
	int stock;
	String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Product(int id, String name, int batch, int price, int stock, String type) {
		super();
		this.id = id;
		this.name = name;
		this.batch = batch;
		this.price = price;
		this.stock = stock;
		this.type = type;
	}
	

	

}
