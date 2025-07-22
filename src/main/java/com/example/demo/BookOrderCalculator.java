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

		for (Integer i : totalBooks) {
			if (i == 1) {
				return basePrice;
			}
		}

		return 0.0;
	}
}
