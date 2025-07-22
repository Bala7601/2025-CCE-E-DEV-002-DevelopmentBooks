package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

@Component
public class BookOrderCalculator {

	public Double calculateBookPrice(Map<String, Integer> book) throws Exception {

		double basePrice = 50.0;

		if (book.isEmpty())
			throw new Exception("Book Basket is empty");

		List<Integer> totalBooks = new ArrayList<>();

		for (Entry<String, Integer> value : book.entrySet()) {
			if (value.getValue() > 0) {
				totalBooks.add(value.getValue());
			}
		}

		int uniqueBooks = 0;
		for (int i = 0; i < totalBooks.size(); i++) {

			if (totalBooks.get(i) > 0) {
				uniqueBooks++;
			}
		}

		double finalPrice = 0.0;
		switch (uniqueBooks) {

		case 2:
			finalPrice = basePrice * uniqueBooks * 0.95;
			break;
		case 3:
			finalPrice = basePrice * uniqueBooks * 0.90;
			break;
		default:
			return basePrice * uniqueBooks;

		}

		return finalPrice;
	}
}
