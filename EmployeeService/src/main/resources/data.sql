DROP TABLE IF EXISTS employee;
CREATE TABLE employee ( id INT AUTO_INCREMENT PRIMARY KEY, empname VARCHAR(25) NOT NULL, age  INT  NOT NULL);  
INSERT INTO employee (empname,age ) VALUES
('Rahul', 42),
  ('Rohan', 32),
  ('Amit', 35);