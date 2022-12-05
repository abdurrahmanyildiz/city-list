# city-list-app
This is a repository for city manuals. Repository includes 2 main projects as Spring Boot for Backend API and Angular for Frondend.

## How to run
* To run Spring Boot Application and Angular application please do followings:

* Check for JDK on your environment(Spring Boot created with Java 17)
* Open the path that you downloaded the Backend project and go to the same level on pom.file
  * For windows: mvnw.cmd clean test install 
  * For Unix : mvnw clean test install
  
* To Start the Backend
  * Windows: mvnw.cmd spring-boot:run
  * Unix: mvnw spring-boot:run

* To Start Frontend
  * npm install
  * npm run proxy

* After application started you can check
  * http://localhost:4200/cities
  
 
![Sample UI](https://github.com/abdurrahmanyildiz/city-list-app/blob/master/city-list-ng/src/assets/images/cities.png)

## Also you can manually trigger the "build" Action to run unit tests.

![GitHub Manuel Triggered Action](https://github.com/abdurrahmanyildiz/city-list-app/blob/master/city-list/src/main/resources/static/cities-tests.png)

