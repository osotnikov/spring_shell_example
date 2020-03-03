# Spring Shell Example Application

This Application is meant to be a simple working example of Spring Shell.
Users of the Spring Shell project can easily build a full featured shell (aka command line) application
by depending on the Spring Shell jars and adding their own commands (which come as methods on spring beans). 
Creating a command line application can be useful e.g. to interact with your project's REST API, or to work 
with local file content.

### Run

java -jar spring_shell_example_application-1.0.0-SNAPSHOT.jar

### Functionalities

#### diffeq: 

Find the number of differences in two strings of equal legnth.

##### usage: 

diffeq "abcde" "abXXX"

... which would return 3

#### find: 

Find all employees by these parameters in this specific order: 
1. payment type
1. department id
1. education level.

Alternatively you can prefix arguments with *--ptype/-p*, *--depId/-d* and *--eduLvl/-e* flags for ease of use 
(prefixes allow any ordering of arguments). 

__You can omit some or all of the arguments, the query will not be restricted by these arguments in that case.__

##### usage:

find -p "Monthly" --eduLvl "Graduate Degree" -d 1

... which will list the employees from the test database from the first department with a Graduate Degree that pay monthly fees

### tests

Unit and integration tests are provided, ran by surefire and failsafe plugins. Unit and integration tests are in their 
own separate folders. The CLI class is unit tested using mockito to create mocks of the services it depends on.
