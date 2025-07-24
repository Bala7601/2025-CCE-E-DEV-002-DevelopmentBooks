package com.book.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.BookOrderCalculator;
import com.book.utilityservice.BookConstant;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	public BookOrderCalculator bookOrderCalculator;

	@PostMapping(value = "/bookPrice")
	public ResponseEntity<String> calculateBookprice(@RequestBody Map<String, Integer> bookList) throws Exception {
		Double bookPrice = BookConstant.finalPrice;
		try {
			bookPrice = bookOrderCalculator.calculateBookPrice(bookList);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>("Total Price for the Listed books : " + String.valueOf(bookPrice), HttpStatus.OK);
	}
}
