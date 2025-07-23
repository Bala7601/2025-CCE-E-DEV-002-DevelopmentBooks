package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDiscountProcessor {

	@Autowired
	private BookList booklist;

	@Autowired
	private BookDiscount bookDiscount;

	public double getDiscountForBooks(List<Integer> totalBooks, double totalPrice) {

		while (!booklist.checkAllZero(totalBooks)) {
			int uniqueBooks = 0;
			for (int i = 0; i < totalBooks.size(); i++) {

				if (totalBooks.get(i) > 0) {
					uniqueBooks++;
					totalBooks.set(i, totalBooks.get(i) - 1);
				}

			}
			totalPrice+= bookDiscount.getDiscountPrice(uniqueBooks);
		}

		return totalPrice;

	}

}
