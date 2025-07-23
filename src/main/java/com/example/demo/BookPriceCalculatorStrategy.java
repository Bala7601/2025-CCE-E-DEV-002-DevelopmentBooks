package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookPriceCalculatorStrategy {

	
	public int betterDicount_Combination=4;
	public List<Integer> getProfitableDiscount(List<Integer> bookList,int sum) {
		
		List<Integer> betterDiscountcombination=new ArrayList<>();
		
	
		while (sum>=betterDicount_Combination && sum%betterDicount_Combination==0) {
			
			betterDiscountcombination.add(betterDicount_Combination);
	         sum-=betterDicount_Combination;
			}
		
		return betterDiscountcombination;
			
	}
}
