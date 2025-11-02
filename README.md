# softwareQuality
Doing software quality testing on a project

#Program

Part#1

This assignment asks you to create a similarity-based website recommendation system based on Wikipedia pages.
The program reads 10 (or more) Wikipedia pages. The urls for these web pages can be maintained in a control file that is read when the program starts. Use a framewwork such as JSoup to extract text bodies etc from html.
Establish a similarity metric that must include information based on custom frequency tables (as will be discussed in class), possibly weighted by or in conjunction with other attributes.
Create a user interface that allows a user to indicate one topic or site, and displays two similar ones. The presentation details are up to you. It may be a web/browser-based (for example, Spring) or GUI-based (Swing, JavaFX, or Android) for the GUI. For Swing, read through the relevant parts of the Swing tutorial first.
Use appropriate existing libraries for every component other than the custom similarity tracking.


Part #2

Loader
For each of at least 200 sites (URLs), create a persistent file including its word frequencies and any other similarity information
Associate a file for each site. Traverse though them to pre-categorize (and somehow store) records into 5 to 10 clusters using k-means, k-medoids, or a similar metric as discussed in class and outlined in the course notes.
Application
Adapt Assignment 1 to display a category (cluster) and the most similar key from the above data structures.


#Implementation
There are some limitations within the program to meet the requirements within a given time. 
