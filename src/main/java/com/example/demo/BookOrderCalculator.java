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
	private BookCatalogCleaner bookCatalogCleaner;

	@Autowired
	private BookPricingHandler bookPricingHandler;

	@Autowired
	private BookDiscountProcessor bookDiscountProcessor;

	public Double calculateBookPrice(Map<String, Integer> book) throws Exception {

		if (book.isEmpty())
			throw new Exception(BookConstant.Basket_Empty);

		book = bookCatalogCleaner.removeBooksNotListedInCatalog(book, BookConstant.bookCatalog);

		List<Integer> totalBooks = new ArrayList<>();

		for (Entry<String, Integer> value : book.entrySet()) {
			if (value.getValue() > 0) {
				totalBooks.add(value.getValue());
			}
		}

		int totalBooksListed = totalBooks.stream().mapToInt(Integer::intValue).sum();

		double totalPrice = 0;
    
		if (book.size() > 1 && totalBooksListed > BookConstant.minimumBooksToGetBetterDiscount
				&& totalBooksListed % BookConstant.minimumBooksToGetBetterDiscount == 0) {

			totalPrice = bookPricingHandler.getPricingWithBetterDiscount(totalBooksListed, totalPrice);
		} else {

			totalPrice = bookDiscountProcessor.getDiscountForBooks(totalBooks, totalPrice);

		}

		return totalPrice;

	}

}
