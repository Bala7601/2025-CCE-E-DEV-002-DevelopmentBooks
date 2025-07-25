package com.book.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.BookApplication;
import com.book.service.BookOrderCalculator;



@SpringBootTest(classes=BookApplication.class)
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
		assertEquals(50.0, bookTest.calculateBookPrice(book), 0.1);
	}
	
	@Test
	public void checkPriceForTwoDifferentBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",1,"Clean Coder",1);
		assertEquals(95.0, bookTest.calculateBookPrice(book),0.1);
		
	}
	
	@Test
	public void checkPriceForThreeDifferentBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",1,"Clean Coder",1,"Clean Architechture",1);
		assertEquals(135.0,bookTest.calculateBookPrice(book),0.1);
	}
	
	@Test
	public void checkPriceForFourDifferentBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",1,"Clean Coder",1,"Clean Architechture",1,"Test Driven Development",1);
		assertEquals(160.0, bookTest.calculateBookPrice(book),0.1);
	}
	
	@Test
	public void checkPriceForFiveDifferentBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",1,"Clean Coder",1,"Clean Architechture",
				1,"Test Driven Development",1,"Working Effectively with legacy Code",1);
		assertEquals(187.5,bookTest.calculateBookPrice(book),0.1);
	}
	
	@Test
	public void checkPriceForDifferentSetOfBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",2,"Clean Coder",2,"Clean Architechture",
				2,"Test Driven Development",1,"Working Effectively with legacy Code",1);
		assertEquals(320.0,bookTest.calculateBookPrice(book),0.1);
	}
	
	@Test 
	public void bookListContainDifferentSets() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",2,"Clean Coder",1,"Test Driven Development",1);
		assertEquals(185.0,bookTest.calculateBookPrice(book),0.1);
	}
	
	@Test 
	public void checkListContainInvalidBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean",2,"Clean Coder",1);
		assertEquals(50.0,bookTest.calculateBookPrice(book),0.1);
	}
	
	@Test
	public void checkPriceForDifferentCombinationSetOne() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",5,"Clean Coder",4);
		assertEquals(430.0,bookTest.calculateBookPrice(book),0.1);
	}
	 
	@Test
	public void checkPriceDifferentCombinationSetTwo() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",8);
		assertEquals(400.0,bookTest.calculateBookPrice(book),0.1);
	}
	
	@Test
	public void checkPriceDifferentCombinationSetThree() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",4,"Clean Coder",3,"Clean Architechture",
				4,"Test Driven Development",5,"Working Effectively with legacy Code",4);
		assertEquals(772.5,bookTest.calculateBookPrice(book),0.1);
	} 
	
	
	@Test
	public void checkPriceForDifferentCombinationSetFour() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",5,"Clean Coder",4);
		assertEquals(430.0,bookTest.calculateBookPrice(book),0.1);
	}
	 
	@Test
	public void checkPriceDifferentCombinationSetFive() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",8);
		assertEquals(400.0,bookTest.calculateBookPrice(book),0.1);
	}
	
	@Test
	public void checkPriceDifferentCombinationSetSix() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",4,"Clean Coder",3,"Clean Architechture",
				4,"Test Driven Development",5,"Working Effectively with legacy Code",4);
		assertEquals(772.5,bookTest.calculateBookPrice(book),0.1);
	}
	
	@Test
	public void checkPriceDifferentCombinationSetSeven() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",4,"Clean Coder",4,"Clean Architechture",
				3,"Test Driven Development",2,"Working Effectively with legacy Code",1);
		assertEquals(575,bookTest.calculateBookPrice(book),0.1);
	}
	
	

}