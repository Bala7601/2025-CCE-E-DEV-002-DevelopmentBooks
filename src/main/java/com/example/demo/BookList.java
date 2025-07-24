package com.example.demo;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookList {


	public  boolean checkAllZero(List<Integer> totalBooks) {
		// TODO Auto-generated method stub
		for (Integer i : totalBooks) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	
	public List<List<Integer>> createInitialGroups(List<Integer> bookCount) {
        List<List<Integer>> groups = new ArrayList();

        while (!checkAllZero(bookCount)) {
            List<Integer> group = new ArrayList<>(bookCount.size());
            for (int i = 0; i < bookCount.size(); i++) {
                if (bookCount.get(i) > 0) {
                    group.add(1);
                    bookCount.set(i,bookCount.get(i) - 1);
                }
            }
            groups.add(group);
        }

        return groups;
    }
	

}