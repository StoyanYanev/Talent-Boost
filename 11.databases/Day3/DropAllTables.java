package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropAllTables {
    private static final String URL = "jdbc:postgresql://192.168.18.64:5432/HR";

    private static Connection getConnection(String url) throws SQLException {
        Connection connection = DriverManager
                .getConnection(url, "stoyany", "jw8s0F4");
        return connection;
    }

    private static String dropTableSubjectEnrolment() {
        String dropTableSubjectEnrolment = "DROP TABLE SubjectEnrolment";
        return dropTableSubjectEnrolment;
    }

    private static String dropTableAddress() {
        String dropTableAddress = "DROP TABLE Address";
        return dropTableAddress;
    }

    private static String dropTableSubject() {
        String dropTableSubject = "DROP TABLE Subject";
        return dropTableSubject;
    }

    private static String dropTableStudent() {
        String dropTableStudent = "DROP TABLE Student";
        return dropTableStudent;
    }

    private static String dropTableCourse() {
        String dropTableCourse = "DROP TABLE Course";
        return dropTableCourse;
    }

    private static String dropTableTeacher() {
        String dropTableTeacher = "DROP TABLE Teacher";
        return dropTableTeacher;
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection(URL);
            Statement stmt = connection.createStatement();

            stmt.executeUpdate(dropTableSubjectEnrolment());
            stmt.executeUpdate(dropTableAddress());
            stmt.executeUpdate(dropTableSubject());
            stmt.executeUpdate(dropTableStudent());
            stmt.executeUpdate(dropTableCourse());
            stmt.executeUpdate(dropTableTeacher());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}