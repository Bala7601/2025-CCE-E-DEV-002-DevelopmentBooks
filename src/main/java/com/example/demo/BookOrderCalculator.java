package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookOrderCalculator {
	
	@Autowired
	private BookPriceCalculatorStrategy bookPriceCalculatorStrategy;

	double basePrice = 50.0;

	List<String> bookList = Arrays.asList("Clean Code", "Clean Coder", "Clean Architechture", "Test Driven Development",
			"Working Effectively with legacy Code");

	public Double calculateBookPrice(Map<String, Integer> book) throws Exception {

		if (book.isEmpty() || book.size() < 0)
			throw new Exception("Book Basket is empty");

		book = removeUnwantedBooks(book);

		List<Integer> totalBooks = new ArrayList<>();

		for (Entry<String, Integer> value : book.entrySet()) {
			if (value.getValue() > 0) {
				totalBooks.add(value.getValue());
			}
		}

		int totalBooksListed = totalBooks.stream().mapToInt(Integer::intValue).sum();
		
		double totalPrice = 0;
		

		if (totalBooksListed > 4 && totalBooksListed % 4 == 0) {
			List<Integer> listToBetterDiscount = new ArrayList<>();
			totalBooks = bookPriceCalculatorStrategy.getProfitableDiscount(listToBetterDiscount, totalBooksListed);

			for (Integer booklist : totalBooks)
				totalPrice = totalPrice + getDiscoutPrice(booklist);
		} else {

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
		}
		
		return totalPrice;

	}

	public Map<String, Integer> removeUnwantedBooks(Map<String, Integer> book) {

		Map<String, Integer> dummyMap = new ConcurrentHashMap(book);

		for (Entry<String, Integer> b : dummyMap.entrySet()) {

			if (!bookList.contains(b.getKey())) {
				dummyMap.remove(b.getKey());
			}

		}
		return dummyMap;
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
