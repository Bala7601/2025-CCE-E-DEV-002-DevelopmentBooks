package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookOrderTest {

	@Autowired
	private BookOrderCalculator bookTest;

	@Test
	public void checkInvalidMap() {
		Map<String, Integer> book = Map.of();

		assertThrows(Exception.class, () -> {
			bookTest.calculateBookPrice(book);
		});
	}

	@Test
	public void checkPriceForSingleBook() throws Exception {

		Map<String, Integer> book = Map.of("Clean Code", 1);
		assertEquals(50, bookTest.calculateBookPrice(book), 0.1);
	}
	
	@Test
	public void checkPriceForTwoDifferentBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",1,"Clean Coder",1);
		assertEquals(95, bookTest.calculateBookPrice(book),0.1);
		
	}

}