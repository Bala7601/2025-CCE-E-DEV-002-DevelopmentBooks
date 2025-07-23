package com.example.demo;



import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookList {
	
	public boolean checkAllZero(List<Integer> totalBooks) {
		// TODO Auto-generated method stub
		for (Integer i : totalBooks) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}


}