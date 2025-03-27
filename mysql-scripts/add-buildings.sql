-- Resets the database everytime this is run
-- DELETE FROM chicagoarchitecture.buildings;
-- TRUNCATE TABLE chicagoarchitecture.buildings;

-- Insert new buildings (testing 5 of them)
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Shure Corporate Headquarters", "5800 West Touhy Avenue", "Niles", 2004);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Levy Senior Center", "300 Dodge Avenue", "Evanston", 2002);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Jewish Reconstructionist Congregation", "303 Dodge Avenue", "Evanston", 2008);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Optima Horizons", "800 Elgin Road", "Evanston", 2004);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Segal Visitors Center", "1841 Sheridan Road", "Evanston", 2014);


-- Show everything that was added
SELECT * FROM chicagoarchitecture.building;