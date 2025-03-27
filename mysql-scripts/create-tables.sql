DROP TABLE IF EXISTS building; -- correct spelling
CREATE TABLE IF NOT EXISTS building (
	id INT AUTO_INCREMENT PRIMARY key,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    creation_year INT NOT NULL,
    district VARCHAR(255) NOT NULL,
    is_endorsed BOOLEAN DEFAULT FALSE
)
