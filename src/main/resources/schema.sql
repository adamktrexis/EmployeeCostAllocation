-- Schema for Manager
CREATE TABLE manager (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL
);

-- Schema for Employee
CREATE TABLE IF NOT EXISTS employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    manager_id BIGINT,
    CONSTRAINT fk_manager FOREIGN KEY (manager_id) REFERENCES employee(id)
);


-- Schema for Users (app_user)
CREATE TABLE app_user (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      username VARCHAR(255) NOT NULL UNIQUE,
      password VARCHAR(255) NOT NULL
);

-- Schema for User Roles
CREATE TABLE user_roles (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     user_id BIGINT,
     role VARCHAR(50),
     FOREIGN KEY (user_id) REFERENCES app_user(id)
);

