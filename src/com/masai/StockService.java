package com.masai;

import java.util.Map;

import com.masai.entities.Stocks;

public class StockService {
   public String addStock(Stocks sto, Map<String, Stocks> stocks) {
	   
	   stocks.put(sto.getName(), sto);
	   
	   return "Stock added succesfully";
   }
   public void viewAllStocks(Map<String, Stocks> stocks) throws ProductException {
		// TODO Auto-generated method stub
		if (stocks != null && stocks.size() > 0) {
			for (Map.Entry<String, Stocks> me : stocks.entrySet()) {
				System.out.println(me.getValue());
			}

		} else {
			throw new ProductException("Stocks List is empty");
		}
	}
   public void deleteStock(String name,Map<String, Stocks>stocks) throws ProductException {

		// System.out.println(products);
		if ( stocks!= null && stocks.size() > 0) {

			if (stocks.containsKey(name)) {
				stocks.remove(name);
				System.out.println("stocks deleted successfully");

			} else {
				throw new ProductException("stocks not found");
			}

		} else {
			throw new ProductException("stocks list is empty");
		}

	}
}
