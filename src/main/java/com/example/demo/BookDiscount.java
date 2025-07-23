package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class BookDiscount {
	
	private static final double basePrice = 50.0;
	
	public double getDiscountPrice(int uniqueBooks) {
		double finalPrice = 0.0;
		switch (uniqueBooks) {

		case 2:
			finalPrice = basePrice * uniqueBooks * 0.95;
			break;
		case 3:
			finalPrice = basePrice * uniqueBooks * 0.90;
			break;
		case 4:
			finalPrice = basePrice * uniqueBooks * 0.80;
			break;
		case 5:
			finalPrice = basePrice * uniqueBooks * 0.75;
			break;
		default:
			return basePrice * uniqueBooks;

		}
		return finalPrice;
	}

}
