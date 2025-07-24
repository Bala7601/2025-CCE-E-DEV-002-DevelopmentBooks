package com.book.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.utilityservice.BookConstant;

@Component
public class DiscountPrice {

	public double getDiscountPrice(int uniqueBooks) {
		double finalPrice = BookConstant.finalPrice;
		
		switch (uniqueBooks) {

		case 2:
			finalPrice = BookConstant.basePrice * uniqueBooks * BookConstant.discount_TwoDifferentBooks;
			break;
		case 3:
			finalPrice = BookConstant.basePrice * uniqueBooks * BookConstant.discount_ThreeDifferentBooks;
			break;
		case 4:
			finalPrice = BookConstant.basePrice * uniqueBooks * BookConstant.discount_FourDifferentBooks;
			break;
		case 5:
			finalPrice = BookConstant.basePrice * uniqueBooks * BookConstant.discount_FiveDifferentBooks;
			break;
		default:
			return BookConstant.basePrice * uniqueBooks;

		}
		return finalPrice;
	}

}