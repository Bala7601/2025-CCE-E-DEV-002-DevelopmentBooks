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
		Map<Integer, Integer> groupSizeCountMap = new HashMap<Integer, Integer>();

		for (List<Integer> group : differentBookSets) {
			int size = (int) group.stream().filter(number -> number > 0).count();
			groupSizeCountMap.put(size, groupSizeCountMap.getOrDefault(size, 0) + 1);
		}

		groupOptimization(groupSizeCountMap, BookConstant.Group_Three, BookConstant.Group_Two,
				BookConstant.Group_Five, 1);
		groupOptimization(groupSizeCountMap, BookConstant.Group_Five, BookConstant.Group_Three,
				BookConstant.Group_Four, 2);
		groupOptimization(groupSizeCountMap, BookConstant.Group_Three, BookConstant.Group_One, 
                 BookConstant.Group_Four, 1);
		
		differentBookSets.clear();
		for (Map.Entry<Integer, Integer> e : groupSizeCountMap.entrySet()) {
			for (int i = 0; i < e.getValue(); i++) {
				differentBookSets.add(Collections.nCopies(e.getKey(), 1));
			}
		}
	}

	
	
	
	public static Map<Integer, Integer> groupOptimization(Map<Integer, Integer> groupSizeCountMap, int groupA,
			int groupB, int resultantGroup, int incrementGroup) {

		int pairs = Math.min(groupSizeCountMap.getOrDefault(groupA, 0), groupSizeCountMap.getOrDefault(groupB, 0));

		for (int i = 0; i < pairs; i++) {
			groupSizeCountMap.put(groupA, groupSizeCountMap.get(groupA) - 1);
			groupSizeCountMap.put(groupB, groupSizeCountMap.get(groupB) - 1);
			groupSizeCountMap.put(resultantGroup, groupSizeCountMap.getOrDefault(resultantGroup, 0) + incrementGroup);
		}

		return groupSizeCountMap;

	}
}
