DROP TABLE IF EXISTS currency;
CREATE TABLE currency ( id INT AUTO_INCREMENT PRIMARY KEY, fromcountry VARCHAR(5) NOT NULL, 
tocountry VARCHAR(5) NOT NULL, conversionfactor INT NOT NULL);  
INSERT INTO currency (fromcountry, tocountry,conversionfactor) VALUES
('USD', 'INR' ,65),  
('EUR', 'INR' ,75),
('AUD', 'INR' ,25);