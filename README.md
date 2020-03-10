# PopulationCount

This repository hosts the source code to show the year in which the population count is lower than last year.

The function takes in a list of lifespan years for population. And it returns the set of years in which the population was less than the preceding year.

Inside the function, a map of population years is created which will contain the change in population as compared to previous years.

After this for each For each deathYear the code is checking whether the overall change in population is positive or not. If change is positive then add it to the set of low population years.

Also in addition there are acceptance test cases which are written in the code.


# How to Run

Navigate into the root folder
Run javac PopulationCount.java.
Run java PopulationCount
