package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookPricingHandler {

	@Autowired
	private BookDiscount bookDiscount;

	@Autowired
	private BookPriceCalculatorStrategy bookPriceCalculatorStrategy;

	public double getPricingWithBetterDiscount(int totalBooksListed, double totalPrice) {

		List<Integer> betterDiscount = new ArrayList<>();
		List<Integer> listOfBooks = bookPriceCalculatorStrategy.getProfitableDiscount(betterDiscount,
				totalBooksListed);

		for (Integer booklist : listOfBooks)
			totalPrice = totalPrice + bookDiscount.getDiscountPrice(booklist);

		return totalPrice;

	}
}
