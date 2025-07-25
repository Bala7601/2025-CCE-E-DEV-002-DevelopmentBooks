package com.book.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.stratergy.GroupingBooks;

@Component
public class BookDiscountProcessor {


	@Autowired
	private DiscountPrice bookDiscount;

	public double calculateTotalDiscountedPrice(List<List<Integer>> groups, double totalPrice) {
		
		for (List<Integer> group : groups) {
			int uniqueBooks = (int) group.stream().filter(x -> x > 0).count();
			totalPrice += bookDiscount.getDiscountPrice(uniqueBooks);
		}

		return totalPrice;

	}

}
