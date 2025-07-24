package com.book.stratergy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GroupingBooks {

	public boolean checkAllZero(List<Integer> booksCount) {
		// TODO Auto-generated method stub
		for (Integer i : booksCount) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	public List<List<Integer>> createInitialGroups(List<Integer> booksCount) {
		List<List<Integer>> groups = new ArrayList<List<Integer>>();

		while (!checkAllZero(booksCount)) {
			List<Integer> group = new ArrayList<>(booksCount.size());
			for (int i = 0; i < booksCount.size(); i++) {
				if (booksCount.get(i) > 0) {
					group.add(1);
					booksCount.set(i, booksCount.get(i) - 1);
				}
			}
			groups.add(group);
		}

		return groups;
	}

}