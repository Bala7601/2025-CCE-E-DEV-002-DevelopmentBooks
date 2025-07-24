package com.book.stratergy;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.book.utilityservice.BookConstant;

@Component
public class BookPriceCalculatorStrategy {

	 public void optimizeGroups(List<List<Integer>> differentBookSets) {
	    	Map<Integer, Integer> groupSizeCountMap  = new HashMap<Integer,Integer>();
	    	
			for (List<Integer> group : differentBookSets) {
				int size = (int) group.stream().filter(number -> number > 0).count();
				groupSizeCountMap .put(size, groupSizeCountMap .getOrDefault(size, 0) + 1);
			}
			
			int pairsToConvert = Math.min(groupSizeCountMap.getOrDefault(BookConstant.Group_Five, 0),   
					groupSizeCountMap .getOrDefault(BookConstant.Group_Three, 0));
			
			for (int i = 0; i < pairsToConvert; i++) {
				groupSizeCountMap .put(BookConstant.Group_Five, groupSizeCountMap .get(BookConstant.Group_Five) - 1);
				groupSizeCountMap .put(BookConstant.Group_Three, groupSizeCountMap .get(BookConstant.Group_Three) - 1);
				groupSizeCountMap .put(BookConstant.Group_Four, groupSizeCountMap .getOrDefault(BookConstant.Group_Four, 0) + 2);
			}

			differentBookSets.clear();
			for (Map.Entry<Integer, Integer> e : groupSizeCountMap .entrySet()) {
				for (int i = 0; i < e.getValue(); i++) {
					differentBookSets.add(Collections.nCopies(e.getKey(), 1));
				}
			}
	    }
}
