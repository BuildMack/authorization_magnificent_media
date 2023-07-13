# Magnificent Media (In Progress)

## Purpose
Track and rate movies, books, and videos games that you have played, read, and watched. A one stop shop for tracking and rating media.

This project is project is primarily for learning. I am using it as a way to learn about a NoSQL database (Cassandra) and Spring Boot.

## Tools
It was developed using Java, Cassandra, 

## Development Process
This application was developed as part of a master's course on Software Development Processes. This course emphasized agile development methodologies and placed a focus on test driven development. Class diagrams, component diagrams, and use case diagrams were all made for the project design plan. A test plan was created based on key requirements before development began.

## Demonstration

The following is a video showing the application in use: https://www.youtube.com/watch?v=h4NF1WuD4uk

<br>Here are screenshots of the applications user interface. The main page allows you to navigate between your current job, job offers, your comparison weight settings, and comparison screen.

<center><img src="app_images/main.png" alt="drawing" width="250"/></center>

<br>You may notice that the compare jobs button is greyed out. This option only becomes available once two jobs have been entered:

<p align="center"><img src="app_images/mainactive.png" alt="drawing" width="250"/></p>

<br>The first button on the main menu leads to a screen where you can enter and edit your current job information:

<p align="center"><img src="app_images/currentjob.png" alt="current job" width="250"/></p>

<br>The second button on the main screen allows you to enter job offers:

<p align="center"><img src="app_images/joboffer.png" alt="job offer" width="250"/></p>

<br>The weights are used to rank and compare the different job opportunites. All weights are equal by default. These weights can be changed if the user values one criteria more than others. The third menu button allows the user to change the weights. For example, if you value salary, relocation stipend, and stock options the most then you might select the following weights:

<p align="center"><img src="app_images/weights.png" alt="weights" width="250"/></p>

<br>The final button on the main screen displays all of the user's job opportunities in ranked order based on the weights that were selected. The user's current job is highlighted in blue. Any two of the job opportunities can be selected and compared side by side.

<p align="center"><img src="app_images/ranking.png" alt="job rankings" width="250"/></p>

<br>The following is what the comparison screen looks like:

<p align="center"><img src="app_images/comparison.png" alt="job comparisons" width="250"/></p>

<br>You will notice that the salary and bonus are adjusted for the cost of living index that was entered earlier to provide a better comparison. Persistance is achieved in this application thanks to the SQLite database. You can watch the demonstration above to observe this. This application will also throw errors messages to the user if not all of the information or incorrect information is filled out for a job opportunity. For example, if you enter a province that does not exist then you will get the following: 

<p align="center"><img src="app_images/errorprovince.png" alt="job comparisons" width="250"/><</p>



