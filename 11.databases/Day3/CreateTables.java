package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    private static final String URL = "jdbc:postgresql://192.168.18.64:5432/HR";

    private static Connection getConnection(String url) throws SQLException {
        Connection connection = DriverManager
                .getConnection(url, "stoyany", "jw8s0F4");
        return connection;
    }


    private static String createTableAddressCode() {
        String createTableAddressCode = "CREATE TABLE AddressCode(\n" +
                "\taddress_code_ID INT NOT NULL,\n" +
                "\tZIP_code VARCHAR(20),\n" +
                "\tcity VARCHAR(20),\n" +
                "\tsuburb VARCHAR(20),\n" +
                "\tPRIMARY KEY (address_code_ID)\n" +
                ")";
        return createTableAddressCode;
    }

    private static String createTableTeacher() {
        String createTableTeacher = "CREATE TABLE Teacher(\n" +
                "\tteacherID INT NOT NULL, \n" +
                "\tteacher_name VARCHAR(30),\n" +
                "\tFOREIGN KEY (address_code_ID) REFERENCES AddressCode (address_code_ID)\n" +
                "\tPRIMARY KEY (teacherID)\n" +
                ")";
        return createTableTeacher;
    }

    private static String createTableCourse() {
        String createTableCourse = "CREATE TABLE Course(\n" +
                "\tcourseID INT NOT NULL, \n" +
                "\tteacherID INT NOT NULL,\n" +
                "\tcourse_name VARCHAR(30),\n" +
                "\tPRIMARY KEY (courseID),\n" +
                "\tFOREIGN KEY (teacherID) REFERENCES Teacher(teacherID)\n" +
                ")";
        return createTableCourse;
    }

    private static String createTableStudent() {
        String createTableStudent = "CREATE TABLE Student(\n" +
                "\tstudentID INT NOT NULL, \n" +
                "\tcourseID INT NOT NULL,\n" +
                "\tstudent_name VARCHAR(30),\n" +
                "\tfees_paid NUMERIC(10, 5),\n" +
                "\tdate_of_birth DATE,\n" +
                "\tPRIMARY KEY (studentID),\n" +
                "\tFOREIGN KEY (courseID) REFERENCES Course(courseID)\n" +
                "\tFOREIGN KEY (address_code_ID) REFERENCES AddressCode (address_code_ID)\n" +
                ")";
        return createTableStudent;
    }

    private static String createTableSubject() {
        String createTableSubject = "CREATE TABLE Subject( \n" +
                "\tsubjectID INT NOT NULL,\n" +
                "\tsubject_name VARCHAR(30),\n" +
                "\tPRIMARY KEY (subjectID)\n" +
                ")";
        return createTableSubject;
    }

    private static String createTableSubjectEnrolment() {
        String createTableSubjectEnrolment = "CREATE TABLE SubjectEnrolment(\n" +
                "\tsubjectID INT NOT NULL, \n" +
                "\tstudentID INT NOT NULL,\n" +
                "\tPRIMARY KEY (subjectID, studentID),\n" +
                "\tFOREIGN KEY (subjectID) REFERENCES Subject(subjectID),\n" +
                "\tFOREIGN KEY (studentID) REFERENCES Student(studentID)\n" +
                ")";
        return createTableSubjectEnrolment;
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection(URL);
            Statement stmt = connection.createStatement();

            stmt.executeUpdate(createTableAddressCode());
            stmt.executeUpdate(createTableTeacher());
            stmt.executeUpdate(createTableCourse());
            stmt.executeUpdate(createTableStudent());
            stmt.executeUpdate(createTableSubject());
            stmt.executeUpdate(createTableSubjectEnrolment());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}