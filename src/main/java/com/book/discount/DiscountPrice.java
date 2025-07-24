package com.book.discount;

import org.springframework.stereotype.Component;

import com.book.utilityservice.BookConstant;

@Component
public class DiscountPrice {

	public double getDiscountPrice(int uniqueBooks) {

		switch (uniqueBooks) {
		case 2:
			return BookConstant.basePrice * uniqueBooks * BookConstant.discount_TwoDifferentBooks;
		case 3:
			return BookConstant.basePrice * uniqueBooks * BookConstant.discount_ThreeDifferentBooks;
		case 4:
			return BookConstant.basePrice * uniqueBooks * BookConstant.discount_FourDifferentBooks;
		case 5:
			return BookConstant.basePrice * uniqueBooks * BookConstant.discount_FiveDifferentBooks;
		default:
			return BookConstant.basePrice * uniqueBooks;

		}
	}

}