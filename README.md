Key Features:
Add Employee: Create and store new employee records in the database.

Retrieve All Employees: Get a list of all employees, with caching to reduce database calls for frequent requests.

Update Employee: Update existing employee records, with cache updates to reflect changes in Redis.

Delete Employee: Remove employee records from the database, with cache eviction to ensure data consistency.

Technologies Used:
Spring Boot: For backend API development.

Spring Data JPA: To interact with a relational database.

Redis: For caching frequently accessed data and improving application performance.

H2 Database: For development and testing purposes (can be swapped for a production database).

Setup Instructions:
Clone the repository.

bash
Copy
Edit
git clone https://github.com/your-username/redis-employee-management.git
Ensure you have Redis installed and running locally. You can download Redis from here.

Build the project using Maven or Gradle.

bash
Copy
Edit
mvn clean install
Run the application:

bash
Copy
Edit
mvn spring-boot:run
