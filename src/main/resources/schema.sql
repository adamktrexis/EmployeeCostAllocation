CREATE TABLE department (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     location VARCHAR(255) NOT NULL
);

CREATE TABLE employee (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      role VARCHAR(50) NOT NULL,
      manager_id INT,
      department_id INT,
      CONSTRAINT fk_manager FOREIGN KEY (manager_id) REFERENCES employee(id) ON DELETE SET NULL,
      CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE SET NULL
);

CREATE TABLE TESTDB.PUBLIC.app_user (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(255) NOT NULL UNIQUE,
       password VARCHAR(255) NOT NULL
);

CREATE TABLE TESTDB.PUBLIC.user_roles (
       id INT AUTO_INCREMENT PRIMARY KEY,
       user_id INT,
       role VARCHAR(50) NOT NULL,
       CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES TESTDB.PUBLIC.app_user(id) ON DELETE CASCADE
);
