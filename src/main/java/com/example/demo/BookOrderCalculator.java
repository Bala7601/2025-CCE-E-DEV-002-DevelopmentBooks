package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class BookOrderCalculator {

	double basePrice = 50.0;
	
    List<String> bookList=Arrays.asList("Clean Code","Clean Coder","Clean Architechture","Test Driven Development",
    		"Working Effectively with legacy Code");
	public Double calculateBookPrice(Map<String, Integer> book) throws Exception {
   
		if (book.isEmpty() || book.size() < 0)
			throw new Exception("Book Basket is empty");
		
		Map<String,Integer> books= new ConcurrentHashMap(book);
		
		for(Entry<String,Integer> b:books.entrySet()) {
			if(!bookList.contains(b.getKey())) {
				books.remove(b.getKey());
			}
		}
		
		List<Integer> totalBooks = new ArrayList<>();

		for (Entry<String, Integer> value : books.entrySet()) {
			if (value.getValue() > 0) {
				totalBooks.add(value.getValue());
			}
		}

		double totalPrice = 0;
		while (!checkAllZero(totalBooks)) {
			int uniqueBooks = 0;
			for (int i = 0; i < totalBooks.size(); i++) {

				if (totalBooks.get(i) > 0) {
					uniqueBooks++;
					totalBooks.set(i, totalBooks.get(i) - 1);
				}

			}
			totalPrice = totalPrice + getDiscoutPrice(uniqueBooks);
		}

		return totalPrice;

	}

	public boolean checkAllZero(List<Integer> totalBooks) {
		// TODO Auto-generated method stub
		for (Integer i : totalBooks) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	public double getDiscoutPrice(int uniqueBooks) {
		double finalPrice = 0.0;
		switch (uniqueBooks) {

		case 2:
			finalPrice = basePrice * uniqueBooks * 0.95;
			break;
		case 3:
			finalPrice = basePrice * uniqueBooks * 0.90;
			break;
		case 4:
			finalPrice = basePrice * uniqueBooks * 0.80;
			break;
		case 5:
			finalPrice = basePrice * uniqueBooks * 0.75;
			break;
		default:
			return basePrice * uniqueBooks;

		}
		return finalPrice;
	}
}
