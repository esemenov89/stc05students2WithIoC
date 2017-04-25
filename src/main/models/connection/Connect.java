package main.models.connection;

import java.sql.*;

/**
 * Created by admin on 18.04.2017.
 */
public class Connect {

    public static Connection initConnection() {
        java.sql.Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
