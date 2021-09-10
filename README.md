Employee Expense Reimbursement System

Overview: Employees can add their Expense Reimbursement and view the status of Reimbursements. As a Manager can Approve or Deny the submitted Employee Reimbursement and also register an account for an Employee for the first time and also sends an email about registration details.
Design Details:
Back-End: Java, Servlet
Front-End: HTML, CSS, JavaScript, AJAX
Database: PostgreSQL using DBeaver

Project Setup:
- Set up database in Amazon RDS through the AWS website.
- Save the endpoint connection(URL), the username, and the password used to set up your database.
- Created ConnectionUtil.java class in our application project structure with database URL, username and password details
- Set up a connection in DBeaver using the url to establish a connection.
- Installed Apache Tomcat version 9.0  and Edit Configuration for Tomcat server port details while building our application.
- Created database and tables in DBeaver
- Add java code in layered manner like models, dao, services, and controller classes as per the requirement
- created a Disptcher.java class as a frontcontroller

Business Requirement:
- As a registered Employee is able to add new reimbursement ticket to the respective approver
- System has different reimbursement types available
- As a Manager can Approve or Deny the submitted reimbursements by Employee
- Both Employees and Manger can view their reimbursement status.

Technologies:
- Java 1.8
- Servlets
- JDBC
- PL/SQL
- HTML
- CSS
- JavaScript
- Bootstrap (optional)
- AJAX
- JUnit and Mockito Testing
- Tomcat Server
- PostgreSQL
- IntelliJ IDE
- DBeaver

