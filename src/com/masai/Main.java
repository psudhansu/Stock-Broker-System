package com.masai;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.masai.entities.Customer;
import com.masai.entities.Transaction;
import com.masai.entities.Stocks;
public class Main {
	private static void adminFunctionality(Scanner sc, Map<String, Customer> customers) {
		
	}
	// customer functionality
		public static void customerFunctionality(Scanner sc, Map<String, Customer> customers)
				throws InvalidDetailsException, TransactionException {

			CustomerService cusService = new CustomerService();
			// Customer login
			System.out.println("please enter the following details to login");
			System.out.println("please enter the email");
			String email = sc.next();
			System.out.println("Enter the password");
			String pass = sc.next();
			customerLogin(email,pass, customers, cusService);
			System.out.println("comp");
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
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   Broker br = new Broker();
//	   System.out.println("username");
//	   String username = sc.next();
//	   System.out.println("password");
//	   String password = sc.next();
//	   if(br.login(username, password)) {;
//	   System.out.println("sucess");
//	   }else {
//		   System.out.println("unsucess");
//	   }
//	   System.out.println("Welcome , in Product Management System");
	   Map<String, Customer> customers = new TreeMap<>();
		try {

			int preference = 0;
			do {
				System.out.println("Please enter your preference, " + " '1' --> Admin login , '2' --> Customer login , "
				+ "'3' for Customer signup, '0' for exit");
				preference = sc.nextInt();
				switch (preference) {
				case 1:
					adminFunctionality(sc,customers);
					break;
				case 2:
					customerFunctionality(sc, customers);
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
