
# Employee Allocation Spring Boot Application

## Overview

This Spring Boot application helps organizations track and report on employee cost allocations based on the number and types of employees within the organization. It supports complex organizational hierarchies, enabling users to calculate the monthly cost allocations for managers and departments. Additionally, the application is secured using Spring Security, ensuring that only authorized users can access sensitive data.

## Functional Requirements

### Employee Cost Allocation:
- **Developers**: $2000 each
- **QA Testers**: $1000 each
- **Managers**: $600 each

### Organizational Hierarchy:
- Managers can have other managers, developers, and QA testers reporting to them.
- Departments may have one or more managers at the top level.

### User Capabilities:
1. **Calculate Manager Allocation**: Users can determine the monthly cost allocation for a manager and their direct/indirect reports, even for deep hierarchies.
2. **Calculate Department Allocation**: Users can determine the total monthly cost allocation for a department.
3. **List Managers Without Reports**: Users can list any managers who have no employees reporting to them.

## Example Scenario

Consider the following organizational hierarchy:

- Manager A
  - Manager B
    - Developer
    - QA Tester 
  - Manager C
    - Manager D 
  - Manager E
    - Developer

Based on this hierarchy:

- Manager A’s allocation: $4200
- Manager B’s allocation: $3600
- Manager C’s allocation: $1200
- Manager D’s allocation: $600
- Manager E’s allocation: $2600
- The department’s total allocation: $8000
- Manager D has no reports.

## Technical Requirements

### REST APIs:
1. **GET /api/managers/{id}/allocation**: Calculate and return the monthly allocation for a specific manager.
2. **GET /api/departments/{id}/allocation**: Calculate and return the monthly allocation for a specific department.
3. **GET /api/managers/no-reports**: List all managers who have no employees reporting to them.

### Security:
- Authentication and authorization are handled using Spring Security with in-memory credentials.
- Only authorized users can access the API endpoints.

## Running the Application

### Prerequisites:
- Java 17 or above.
- Maven installed.

### Steps to Run:
1. Clone the repository or extract the zip file.
2. Navigate to the project folder in your terminal.
3. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application endpoints using `curl`, Postman, or a web browser.

   Example:
   ```
   curl -u admin:admin123 http://localhost:8080/api/managers/1/allocation
   ```

   **Note:** The default credentials for accessing the APIs are:
   - Username: `admin`
   - Password: `admin123`

### In-Memory Database:
The application uses an H2 in-memory database for simplicity. You can access the H2 console at:
```
http://localhost:8080/h2-console
```
The default database credentials are:
- **Username**: `sa`
- **Password**: `password`

### Testing:
Unit tests are provided using Spring Boot's testing framework. You can run the tests with Maven:
```bash
mvn test
```

## Packaging

The application can be packaged into a JAR file using the following Maven command:
```bash
mvn clean package
```

The resulting JAR file can be found in the `target` directory.

## Future Enhancements
- Extend the business logic for cost allocation calculations.
- Add integration tests for API endpoints.
- Implement caching for frequently accessed data.

