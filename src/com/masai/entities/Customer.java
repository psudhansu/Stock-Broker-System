package com.masai.entities;

public class Customer extends User {
	private double walletBalance;

	public Customer(double walletBalance, String username, String password, String address, String email) {
		super(username, password, address, email);
		this.walletBalance = walletBalance;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	@Override
	public String toString() {
		return "Customer [walletBalance=" + walletBalance + ", getWalletBalance()=" + getWalletBalance()
				+ ", getUsername()=" + getUsername() + ", getAddress()=" + getAddress() + ", getEmail()=" + getEmail()
				+  "]";
	}
}
