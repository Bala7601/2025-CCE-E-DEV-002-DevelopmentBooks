package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookPriceCalculatorStrategy {

	public List<Integer> getProfitableDiscount(List<Integer> bookList, int sum) {

		List<Integer> betterDiscountcombination = new ArrayList<>();

		while (sum >= BookConstant.betterDiscount_Combination && sum % BookConstant.betterDiscount_Combination == 0) {

			betterDiscountcombination.add(BookConstant.betterDiscount_Combination);
			sum -= BookConstant.betterDiscount_Combination;  
		}

		return betterDiscountcombination;

	}
}
