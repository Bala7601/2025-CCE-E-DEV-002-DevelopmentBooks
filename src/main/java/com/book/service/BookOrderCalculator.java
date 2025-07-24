package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.cleaner.BookCatalogCleaner;
import com.book.discount.BookDiscountProcessor;
import com.book.stratergy.GroupingBooks;
import com.book.stratergy.BookPriceCalculatorStrategy;
import com.book.utilityservice.BookConstant;

@Service
public class BookOrderCalculator {

	@Autowired
	private BookCatalogCleaner bookCatalogCleaner;

	@Autowired
	private BookDiscountProcessor bookDiscountProcessor;

	@Autowired
	private BookPriceCalculatorStrategy bookPriceCalculatorStrategy;

	@Autowired
	private GroupingBooks bookList;

	public Double calculateBookPrice(Map<String, Integer> book) throws Exception {

		double totalPrice = 0.0;

		if (book.isEmpty())
			throw new Exception(BookConstant.Basket_Empty);

		book = bookCatalogCleaner.removeBooksNotListedInCatalog(book, BookConstant.bookCatalog);

		List<Integer> totalBooks = new ArrayList<>();

		for (Entry<String, Integer> value : book.entrySet()) {
			if (value.getValue() > 0) {
				totalBooks.add(value.getValue());
			}
		}

		List<List<Integer>> groups = bookList.createInitialGroups(totalBooks);
		bookPriceCalculatorStrategy.optimizeGroups(groups);

		totalPrice = bookDiscountProcessor.calculateTotalDiscountedPrice(groups, BookConstant.finalPrice);

		return totalPrice;

	}

}
