package com.masai.entities;

import java.io.Serializable;

public class Transaction implements Serializable {
	private String username;
	private String email;
	
	private String stockName;
	private double price;
	private int quantity;
	private double Total;

	public Transaction() {
		super();
	}


	public Transaction(String username, String email, String stockName, int quantity , double price,double Total) {
		super();
		this.username = username;
		this.email = email;
		this.stockName = stockName;
		this.quantity = quantity;
		this.price= price;
		this.Total=Total;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getStockName() {
		return stockName;
	}


	public void setStockName(String stockName) {
		this.stockName = stockName;
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
		return "Transaction [username=" + username + ", email=" + email + ", StockName=" + stockName + ", quantity="
				+ quantity + "]";
	}


	public double getTotal() {
		return Total;
	}


	public void setTotal(double total) {
		Total = total;
	}
	
	
}
