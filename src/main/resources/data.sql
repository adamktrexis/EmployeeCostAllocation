-- Updated data.sql
-- Managers
INSERT INTO manager (name) VALUES ('Manager A');
INSERT INTO manager (name) VALUES ('Manager B');

-- Employees reporting to Manager A
INSERT INTO employee (name, role, manager_id) VALUES ('Developer 1', 'DEVELOPER', 1);
INSERT INTO employee (name, role, manager_id) VALUES ('QA Tester 1', 'QA', 1);

-- Employees reporting to Manager B
INSERT INTO employee (name, role, manager_id) VALUES ('Developer 2', 'DEVELOPER', 2);

-- Users
INSERT INTO app_user (username, password) VALUES ('admin', '$2a$10$wIYZ5kfwVpxpTeEhU4lQWuMha8F/3EvWR0cyWoz1H3/u8JAWgjeOi'); -- password: adminPass
INSERT INTO app_user (username, password) VALUES ('user', '$2a$10$JdNmTaCmNzQAfFwU8SbQleYtaGVzIHtZbyF0rvYknp4DgoF4oYz/S'); -- password: userPass

-- User roles
INSERT INTO user_roles (user_id, role) VALUES (1, 'ADMIN');
INSERT INTO user_roles (user_id, role) VALUES (2, 'USER');
