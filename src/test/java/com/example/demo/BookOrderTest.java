package com.example.demo;

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

}