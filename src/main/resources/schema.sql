
CREATE TABLE manager (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    job_type VARCHAR(255),
    manager_id BIGINT,
    CONSTRAINT fk_manager FOREIGN KEY (manager_id) REFERENCES manager(id)
);

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles (
    user_id BIGINT,
    role VARCHAR(255),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user(id)
);
