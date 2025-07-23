package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookConstant {

	public static final String Basket_Empty = "Book Basket is empty, Please add some books";
	public static final List<String> bookCatalog = Arrays.asList("Clean Code", "Clean Coder", "Clean Architechture",
			"Test Driven Development", "Working Effectively with legacy Code");

	public static final int minimumBooksToGetBetterDiscount = 4;

	public static final double basePrice = 50.0;

	public static final double finalPrice = 0.0;

	public static final int betterDiscount_Combination = 4;

	public static final double discount_TwoDifferentBooks = 0.95;
	public static final double discount_ThreeDifferentBooks = 0.90;
	public static final double discount_FourDifferentBooks = 0.80;
	public static final double discount_FiveDifferentBooks = 0.75;

}
