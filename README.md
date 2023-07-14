# Magnificent Media

## Purpose
Track and review movies, books, and video games that you have watched, read, and played. It is a one stop shop for tracking and reviewing media.

This project is primarily so I can learn a NoSQL database (Cassandra) and Spring Boot. This gave me exposure to using Thymeleaf, Spring MVC, Spring Data, and Spring Security. 

## Tools
It was developed using Java, Spring Boot, and Cassandra. Most of the front end code was borrowed from Bootstrap and modified slightly. 

## Development Process
A data loader application was created to upload the data dumps of books and movies from open library and IMDB to the cassandra repository set up using datastax. 

From there a basic github authenticator was set up. Then the book MVC was established. A component was made to allow for search at the top of each view by connecting to the open library API. Then a table was set up to hold the books read by the user and a view created to display them as a home page. 

## Remaining Work/ Next Steps:
1. Set up data loader from IMDB datasource.
2. Connect to IMDB search API
3. Add radio button to switch between search options or find alternative
4. Modify home and books views.
5. Set up authentication using google and facebook.

## Demonstration

The following is a video showing the application in use: https://youtu.be/QHvqeg_2J4g