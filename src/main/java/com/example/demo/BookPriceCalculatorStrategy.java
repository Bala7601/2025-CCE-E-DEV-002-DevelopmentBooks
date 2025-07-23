package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookPriceCalculatorStrategy {

	public int betterDiscount_Combination = 4;

	public List<Integer> getProfitableDiscount(List<Integer> bookList, int sum) {

		List<Integer> betterDiscountcombination = new ArrayList<>();

		while (sum >= betterDiscount_Combination && sum % betterDiscount_Combination == 0) {

			betterDiscountcombination.add(betterDiscount_Combination);
			sum -= betterDiscount_Combination;
		}

		return betterDiscountcombination;

	}
}
