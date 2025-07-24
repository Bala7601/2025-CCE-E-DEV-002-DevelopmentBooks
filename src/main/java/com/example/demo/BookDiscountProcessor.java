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

	public double getDiscountForBooks(List<List<Integer>> groups, double totalPrice) {

		for (List<Integer> group : groups) {
            int uniqueBooks = (int) group.stream().filter(x -> x > 0).count();
            totalPrice += bookDiscount.getDiscountPrice(uniqueBooks);
        }

		return totalPrice;

	}

}
