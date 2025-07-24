#BookOrderPrice Calculator 

Spring boot application to calculates the total price of a collection of books with discount rules applied. 
It takes a list of books and their quantities via a POST API and returns the total discounted price.


#Features

- Accepts a `Map<String, Integer>` of book titles and quantities via POST API.
- Applies a optimized grouping to minimize the total price.
- Removes books that are not listed in the book catalog.
- Calculates discount based on the number of unique books in each group.


#TechStack

- Java 8
- Spring Boot
- Junit


#Discount Rules

|       UniqueBooks     |  Discount    |
------------------------------------
| 2                     | 5%           |
| 3                     | 10%          |
| 4                     | 20%          |
| 5                     | 25%          |
| 1 or others           | No Discount  |


#Book Catalog

Only the following books are eligible:

- Clean Code
- Clean Coder
- Clean Architecture
- Test Driven Development
- Working Effectively with Legacy Code


#API EndPoint
#Post request "/books/bookPrice"

json request----
{
  "Clean Code": 4,
  "Clean Coder": 4,
  "Clean Architechture": 3,
  "Working Effectively with legacy Code": 2,
  "Test Driven Development": 1
}
#Response:(String)
Total Price for the Listed books : 575.0
