package com.masai;
import java.util.List;

import com.masai.entities.Customer;
import com.masai.entities.Stocks;
public class Broker {
    final String admin_username = "admin";
    final String admin_password = "admin";
   public  List<Customer> customers;
   public List<Stocks> stocks;
   Broker(){
	   
   }
   public boolean Adminlogin(String username,String password) {
	   return username.equals(admin_username) && password.equals(admin_password);
   }
}
