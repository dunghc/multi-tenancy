-- Create table and insert data for tenant1
CREATE TABLE IF NOT EXISTS tenant1.department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO tenant1.department (name) VALUES ('HR');
INSERT INTO tenant1.department (name) VALUES ('Finance');

-- Create table and insert data for tenant2
CREATE TABLE IF NOT EXISTS tenant2.department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO tenant2.department (name) VALUES ('Engineering');
INSERT INTO tenant2.department (name) VALUES ('Sales');
