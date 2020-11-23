About the project

The idea behind this project is about to replace the outdated homepage of a basketball club. As well as granting a platform for the coaches in which they can easily add/modify all the necessary parameters related to the club. Such as, seasons, events, players data, statistics, etc.  
Previously the database manager was part of a different back-end service hence it was available through a different homepage.
Based on monolithic design, this part provides the back-end services for the separated BLF front-end application (Please find it on the following link: https://github.com/Gergo1212/blf-frontend).

The main goals of this project are:
 
•	simplifying the connections between the legacy database tables
•	providing an up to date back-end service, including well separated and well defined interfaces 
•	practicing and gain more experience in Spring Boot


Version

The project is still under development. Remaining parts, for instance security and registration, sending emails, managing permissions by a super user will be implemented in subsequent sprints.

Planned roles and their accessibilities are the following:

•	Admin —> Full control of CRUD actions through the database. Verifying registration by 		connecting player profiles with user profiles.

•	Coach —> Full access(CRUD) for the data of his/her own teams.

•	Player —> Can modify only his/her own information. Get and compare statistics related to 		matches and team members.

•	Parent —> Get information about the child’s/children’s improvement through the coach’s 		feedbacks. 


Technologies used

•	Java 13 (including Hibernate and Lombok)
•	Spring Boot( including Spring Security)
•	MySQL database
•	GIT for version controlling


