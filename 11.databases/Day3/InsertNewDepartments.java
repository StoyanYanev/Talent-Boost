package DB;

import java.sql.*;

public class InsertNewDepartments {
    private static final String URL = "jdbc:postgresql://192.168.18.64:5432/HR";

    private static Connection getConnection(String url) throws SQLException {
        Connection connection = DriverManager
                .getConnection(url, "stoyany", "jw8s0F4");
        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection(URL);
            Statement stmt = connection.createStatement();

            String q1 = "INSERT INTO departments  VALUES (330, 'department280', 200,1700)";
            String q2 = "INSERT INTO departments  VALUES (340, 'department285', 200,1700)";
            String q3 = "INSERT INTO departments  VALUES (350, 'department290', 200,1700)";
            stmt.executeUpdate(q1);
            stmt.executeUpdate(q2);
            stmt.executeUpdate(q3);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}