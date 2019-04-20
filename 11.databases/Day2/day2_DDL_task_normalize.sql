CREATE TABLE AddressCode(
	address_code_ID INT NOT NULL,
	ZIP_code VARCHAR(20),
	city VARCHAR(20),
	suburb VARCHAR(20),
	PRIMARY KEY (address_code_ID)
);

ALTER TABLE Student
DROP COLUMN address;

ALTER TABLE Teacher
DROP COLUMN teacher_address;

ALTER TABLE Student
ADD address_code_ID INT;

ALTER TABLE Teacher
ADD address_code_ID INT;

ALTER TABLE Student
ADD FOREIGN KEY (address_code_ID) REFERENCES AddressCode (address_code_ID);

ALTER TABLE Teacher
ADD FOREIGN KEY (address_code_ID) REFERENCES AddressCode (address_code_ID);