package com.masai;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.masai.entities.Customer;
import com.masai.entities.Transaction;
import com.masai.entities.Stocks;
public class Main {
	//broker functionality
	private static void adminFunctionality(Scanner sc,Map<String, Stocks> stocks, Map<String, Customer> customers) throws InvalidDetailsException{
		//Admin login 
		
		adminLogin(sc);
		CustomerService cusService = new CustomerService();
		StockService stoService = new StockService();
		int choice = 0;
		try {
			do {
				System.out.println("Press 1 add the stock");
				System.out.println("Press 2 view all the stock");
				System.out.println("Press 3 view all customers");
				System.out.println("Press 4 to view all transactions");
				System.out.println("Press 5 delete the stock");
				System.out.println("Press 6 delete the customer");
				System.out.println("Press 7 to log out");
				choice = sc.nextInt();

				
				switch (choice) {
				case 1:
					String added = adminAddStock(sc, stocks, stoService);
					System.out.println(added);
					break;
				case 2:

					adminViewAllStocks(stocks, stoService);
					break;
				case 3:
					adminViewAllCustomers(customers,cusService);
					break;
				case 5:
					adminDeleteStock(sc,stocks,stoService);
					break;
				}
			}while (choice <= 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// admin login method
	public static void adminLogin(Scanner sc) throws InvalidDetailsException{
		
		System.out.println("Enter Admin Username");
		String userName = sc.next();
		System.out.println("Enter the Admin Password");
		String passWord=sc.next();
		if(userName.equals("admin") && passWord.equals("admin")) {
			System.out.println("Admin login succesful");
		}else {
			throw new InvalidDetailsException("Wrong Credential");
		}
	}
	//admin add stock method
	public static String adminAddStock(Scanner sc, Map<String, Stocks> stocks, StockService stoService) {

		String str = null;
		System.out.println("please enter the stock details");
		System.out.println("Enter the stock name");
		String name = sc.next();
		System.out.println("Enter the stock qty(fixed 500)");
		int qty = sc.nextInt();
		System.out.println("Enter the stock price/piece");
		double price = sc.nextDouble();
		

		Stocks sto = new Stocks( name, qty, price);

		str = stoService.addStock(sto, stocks);// considering all details are valid

		return str;

	}
	// 
	public static void adminViewAllStocks(Map<String, Stocks> stocks, StockService stoService)
			throws ProductException {
		stoService.viewAllStocks(stocks);
	}
	public static void adminViewAllCustomers(Map<String, Customer> customers, CustomerService cusService)
			throws ProductException {
		List<Customer> list = cusService.viewAllCustomers(customers);

		for (Customer c : list) {
			System.out.println(c);
		}
	}
	// deleteStock
	public static void adminDeleteStock(Scanner sc,Map<String, Stocks>stocks,StockService stoService) throws ProductException{
		System.out.println("Enter the name of the stock which you want to delete");
		String nm = sc.next();
		stoService.deleteStock(nm,stocks);
	}
	// customer functionality
		public static void customerFunctionality(Scanner sc,Map<String, Stocks> stocks, Map<String, Customer> customers)
				throws InvalidDetailsException, TransactionException {
			StockService stoService = new StockService();
			CustomerService cusService = new CustomerService();
			// Customer login
			System.out.println("please enter the following details to login");
			System.out.println("please enter the email");
			String email = sc.next();
			System.out.println("Enter the password");
			String pass = sc.next();
			customerLogin(email,pass, customers, cusService);
			try {
				int choice = 0;
				do {
					System.out.println("Select the option of your choice");
					System.out.println("Press 1 to view all stocks");
					System.out.println("Press 2 to buy a stock");
					System.out.println("Press 3 view my transactions");
					System.out.println("Press 4 to add money to my wallet");
					System.out.println("Press 5 view wallet balance");
					System.out.println("Press 6 to logout");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						customerViewAllStocks(stocks, stoService);
						break;
					}
				}while(choice<=6);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			//System.out.println("comp");
		}
		public static void customerSignup(Scanner sc, Map<String, Customer> customers) throws DuplicateDataException {
			System.out.println("please enter the following details to Signup");
			System.out.println("please enter the user name");
			String name = sc.next();
			System.out.println("Enter the password");
			String pass = sc.next();
			System.out.println("enter the address");
			String address = sc.next();
			System.out.println("Enter the email id");
			String email = sc.next();
			System.out.println("Enter the balance to be added into the wallet");
			double balance = sc.nextDouble();
			Customer cus = new Customer(balance, name, pass, address, email);

			CustomerService cusService = new CustomerService();
			cusService.signUp(cus, customers);
			System.out.println("customer has Succefully sign up");

		}

		public static void customerLogin(String email,String pass, Map<String, Customer> customers, CustomerService cusService)
				throws InvalidDetailsException {
			cusService.login(email, pass,customers);
			System.out.println("Customer has successfully login");

		}
		public static void customerViewAllStocks(Map<String, Stocks> stocks, StockService stoService)
				throws ProductException {
			stoService.viewAllStocks(stocks);
		}
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   Map<String, Stocks> stocks = new TreeMap<>();
	   Map<String, Customer> customers = new TreeMap<>();
		try {

			int preference = 0;
			do {
				System.out.println("Please enter your preference, " + " '1' --> Admin login , '2' --> Customer login , "
				+ "'3' for Customer signup, '0' for exit");
				preference = sc.nextInt();
				switch (preference) {
				case 1:
					adminFunctionality(sc,stocks,customers);
					break;
				case 2:
					customerFunctionality(sc,stocks, customers);
					break;

				case 3:
					customerSignup(sc, customers);
					break;

				case 0:
					System.out.println("successfully existed from the system");

					break;

				default:
					throw new IllegalArgumentException("Invalid Selection");
				}

			}

			while (preference != 0);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
   }
}
