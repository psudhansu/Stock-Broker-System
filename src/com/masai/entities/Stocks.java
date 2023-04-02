package com.masai.entities;

import java.io.Serializable;

public class Stocks implements Serializable{
     private String name;
     private int quantity;
     private double price;
	public Stocks(String name, int quantity,double price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Stocks [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
     
}
