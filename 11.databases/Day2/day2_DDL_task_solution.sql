CREATE TABLE Teacher(
	teacherID INT NOT NULL, 
	teacher_name VARCHAR(30),
	teacher_address VARCHAR(20),
	PRIMARY KEY (teacherID)
);

CREATE TABLE Course(
	courseID INT NOT NULL, 
	teacherID INT NOT NULL,
	course_name VARCHAR(30),
	PRIMARY KEY (courseID),
	FOREIGN KEY (teacherID) REFERENCES Teacher(teacherID)
);

CREATE TABLE Student(
	studentID INT NOT NULL, 
	courseID INT NOT NULL,
	student_name VARCHAR(30),
	fees_paid NUMERIC(10, 5),
	date_of_birth DATE,
	address VARCHAR(20),
	PRIMARY KEY (studentID),
	FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

CREATE TABLE Subject( 
	subjectID INT NOT NULL,
	subject_name VARCHAR(30),
	PRIMARY KEY (subjectID)
);

CREATE TABLE SubjectEnrolment(
	subjectID INT NOT NULL, 
	studentID INT NOT NULL,
	PRIMARY KEY (subjectID, studentID),
	FOREIGN KEY (subjectID) REFERENCES Subject(subjectID),
	FOREIGN KEY (studentID) REFERENCES Student(studentID)
);