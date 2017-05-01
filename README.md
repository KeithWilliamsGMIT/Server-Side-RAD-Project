# Server-Side-RAD-Project
This is my project for the 3rd year server side RAD module in college. For this project I was required to write a Spring Boot MVC application that allows a logged-in user to manage orders of products for customers.

### Skeleton Project
A skeleton project was provided to base the application on. The Model for the application consists of three objects:

1. Product
    + Product ID
	Description
	Quantity In Stock

2. Customer
	+ Customer ID
	+ Customer Name

3. Order
	+ Order ID
	+ Order Quantity
	+ Order Date

These models were given in the skeleton code for the project and their dependencies already set up.

### Setup
This project was developed using Eclipse Neon JEE. This project requires the following to be installed in Eclipse
+ Maven Integration for Eclipse (Luna and newer) 1.5
+ Spring IDE 3.8.4.RELEASE
+ EGit (Optional)

To install these go to help in the Eclipse menubar and select Eclipse Marketplace. Then search for these in the search bar provided. This project also requires a WAMP to be started and an empty database called `sales` to be created.

### Running the application
To run the application, right click on the poject in the solution explorer and click Run As -> Spring Boot App. The application will then be available at [http://localhost:8080/](http://localhost:8080/). An account is provided which has a username of "user" and a password of "user".