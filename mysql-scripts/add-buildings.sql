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

INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Ryan Center for the Musical Arts", "70 Arts Circle Drive", "Evanston", 2015);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Kellogg School of Management Global Hub", "2211 Campus Drive", "Evanston", 2017);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Optima Old Orchard Woods", "9739 Woods Drive", "Skokie", 2008);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Illinois Holocaust Museum & Education Center", "9603 Woods Drive", "Skokie", 2009);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Lipton Thayer House", "2600 Thayer Street", "Evanston", 2018);

INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Wilmette Residence", "1019 Linden Avenue", "Wilmette", 2016);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Glass House & 7RR Eco-Home", "Rolling Ridge Lane", "Northfield", 2012);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Crate & Barrel Headquarters", "1250 Techny Road", "Northbrook", 2002);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Writers Theatre", "325 Tudor Court", "Glencoe", 2016);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Daniel F. and Ada L. Rice Plant Science Conservation Center", "1000 Lake Cook Road", "Glencoe", 2009);

INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Ravinia Festival Dining Pavilion", "418 Sheridan Road", "Glencoe", 2007);
INSERT INTO chicagoarchitecture.building (name, address, city, creation_year)
VALUES ("Ragdale Meadow Studio", "1260 Green Bay Road", "Lake Forest", 2008);

-- Show everything that was added
SELECT * FROM chicagoarchitecture.building;