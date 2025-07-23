package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class BookCatalogCleaner {
	public Map<String, Integer> removeBooksNotListedInCatalog(Map<String, Integer> book,List<String> bookList) {

		Map<String, Integer> filterBooks = new ConcurrentHashMap<String, Integer>(book);

		for (Entry<String, Integer> b : filterBooks.entrySet()) {

			if (!bookList.contains(b.getKey())) {
				filterBooks.remove(b.getKey());
			}

		}
		return filterBooks;
	}


}