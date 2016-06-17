package com.mtraina.springapp.domain;

public class Product {
	private int id;
	private String description;
	private Double price;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String toString(){
		return new StringBuffer("Id: ").append(id).append(";Description: ").append(description).append(";Price: ").append(price).toString();
	}
}
