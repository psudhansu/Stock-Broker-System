package com.masai;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.masai.entities.Customer;
import com.masai.entities.Transaction;
import com.masai.entities.Stocks;
public class CustomerService {
	public void signUp(Customer cus, Map<String, Customer> customers) throws DuplicateDataException {

		if (customers.containsKey(cus.getEmail())) {
			throw new DuplicateDataException("Customer already exists , please login");
		} else {

			customers.put(cus.getEmail(), cus);

		}

	}
	public boolean login(String email,String password, Map<String, Customer> customers) throws InvalidDetailsException {

		if (customers.containsKey(email) ) {
			
			if(customers.get(email).getPassword().equals(password)) {
				return true;
			}
			else {
				throw new InvalidDetailsException("Invalid Credentials");
			}
			
		} else {
			throw new InvalidDetailsException("you have not sign up yet, please signup");
		}

	}
	public boolean buyStock(String name, int quantity, String email, Map<String, Stocks> stocks,
			Map<String, Customer> customers, List<Transaction> transactions)
			throws InvalidDetailsException, ProductException {

		if (stocks.size() == 0)
			throw new ProductException("Product list is empty");

		if (stocks.containsKey(name)) {

			Stocks sto = stocks.get(name);

			if (sto.getQuantity() >= quantity) {

				Customer cus = customers.get(email);

				double buyingPrice = quantity * sto.getPrice();

				if (cus.getWalletBalance() >= buyingPrice) {
					cus.setWalletBalance(cus.getWalletBalance() - buyingPrice);

					sto.setQuantity(sto.getQuantity() - quantity);

					stocks.put(name, sto);

					Transaction tr = new Transaction(cus.getUsername(), email,sto.getName(), quantity, sto.getPrice(),
							sto.getPrice() * quantity);

					transactions.add(tr);

				} else {
					throw new InvalidDetailsException("wallet balance is not sufficient");
				}

			} else {
				throw new InvalidDetailsException("product quantity is not suffiecient");
			}

		} else {
			throw new InvalidDetailsException("product not available with id: " + name);
		}

		return false;
	}
	public List<Customer> viewAllCustomers(Map<String, Customer> customers) throws ProductException {
		// TODO Auto-generated method stub
		List<Customer> list = null;

		if (customers != null && customers.size() > 0) {
			Collection<Customer> coll = customers.values();
			list = new ArrayList<>(coll);
		} else {
			throw new ProductException("Customer list is empty");
		}

		return list;
	}
	public boolean addMoneyToWallet(double amount, String email, Map<String, Customer> customers) {
		// TODO Auto-generated method stub

		Customer cus = customers.get(email);

		cus.setWalletBalance(cus.getWalletBalance() + amount);

		customers.put(email, cus);

		return true;
	}
	public double viewWalletBalance(String email, Map<String, Customer> customers) {
		// TODO Auto-generated method stub

		Customer cus = customers.get(email);

		return cus.getWalletBalance();
	}
	
}
