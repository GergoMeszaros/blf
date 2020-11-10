About the project

The idea behind this micro-service web project is about to replace the outdated homepage of a basketball club. As well as granting a platform for the coaches in which they can easily add/modify all the necessary parameters related to the club. Such as, seasons, events, players data, statistics, etc. 
Until this time, the database manager was part of a different back-end service thus was available on a different homepage.
This part provides the back-end services for the separated front-end of the BLF front-end application project.

The main goals of this project are to simplify the connections between the existing database tables, practice and gain more experience in the micro-service architecture.

Services

api-gateway: Netflix Zuul API Gateway, including authentication
game-service: controls matches, seasons, teams, leagues
people-service: controls all the players and coaches
service-registry: Eureka Server for registering services independently

Version

Under development.

Technologies used

Spring Boot (including Lombok and Hibernate)
MySQL database
Netflix Zuul API Gateway
Eureka
REST API
GIT
IntelliJ IDEA