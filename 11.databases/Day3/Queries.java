package DB;

import java.sql.*;

public class Queries {
    private static final String URL = "jdbc:postgresql://192.168.18.64:5432/HR";
    private static final String SEPARATOR = "__________________________________________________________________________";

    private static Connection getConnection(String url) throws SQLException {
        Connection connection = DriverManager
                .getConnection(url, "stoyany", "jw8s0F4");
        return connection;
    }

    public static String displayAllDataFromDBCountries() {
        String displayAll = "SELECT * FROM countries";
        return displayAll;
    }

    public static String displayFirstLastNameAndSalary() {
        String displayFirstLastNameAndSalary = "SELECT (first_name || ' ' || last_name), salary FROM employees";
        return displayFirstLastNameAndSalary;
    }


    public static String displaySalaryAndFirstLastName() {
        String displaySalaryAndFirstLastName = "SELECT salary, (first_name || ' ' || last_name) FROM employees";
        return displaySalaryAndFirstLastName;
    }

    public static String displayEmployeeNameWithTheirSalary() {
        String displayEmployeeNameWithTheirSalary = "SELECT (first_name || ' ' || last_name) AS full_name FROM employees WHERE salary >= 1500";
        return displayEmployeeNameWithTheirSalary;
    }

    public static String displayAllJobs() {
        String displayAllJobs = "SELECT * FROM jobs";
        return displayAllJobs;
    }

    public static void printResult(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnNumber; i++) {
                if (i > 1) System.out.print(", ");
                System.out.print(resultSet.getString(i));
            }
            System.out.println();
        }
    }

    public static void executeQuery(Statement stmt, String query) throws SQLException {
        System.out.println(SEPARATOR);
        ResultSet resultSet = stmt.executeQuery(query);
        printResult(resultSet);
        System.out.println(SEPARATOR);
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection(URL);
            Statement stmt = connection.createStatement();

            executeQuery(stmt, displayAllDataFromDBCountries());
            executeQuery(stmt, displayFirstLastNameAndSalary());
            executeQuery(stmt, displaySalaryAndFirstLastName());
            executeQuery(stmt, displayEmployeeNameWithTheirSalary());
            executeQuery(stmt, displayAllJobs());

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}