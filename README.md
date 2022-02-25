#Oze Backend Task
***
#GitHub Repository
https://github.com/Leonardra/hospitalManagementSystem
***
# Project Description

This is a hospital management system with CRUD functionality and an  additional feature of downloading a specific patient 
data to a CSV file. The project was built with SpringBoot(Java).


#Prerequisites
* Java 11
* Maven
* PostMan
* MySQL


##To build
```shell
mvn clean install
```

##Database
To set up the database, run the sql script in [./resources/db/setup-db.sql](src/main/resources/db/setup-db.sql) on MySQL

Patient data is populated from the sql script in [./resources/data.sql](src/main/resources/data.sql) 
when server is started.

##To run
```shell
java -jar ./target/hospitalManagementSystem.jar
```


