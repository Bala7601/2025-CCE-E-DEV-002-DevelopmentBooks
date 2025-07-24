package com.book.cleaner;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class BookCatalogCleaner {
	public Map<String, Integer> removeBooksNotListedInCatalog(Map<String, Integer> book,List<String> catalogBooks) {

		 return book.entrySet().stream()
		            .filter(entry -> catalogBooks.contains(entry.getKey()))
		            .collect(Collectors.toMap(
		                Entry::getKey,
		                Entry::getValue
		            ));
	}


}