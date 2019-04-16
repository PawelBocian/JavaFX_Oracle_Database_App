package database;


import java.sql.*;


public class DBConnection {

    public static Connection getConnection(Connection connection) {

        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf", "PBOCIAN", "pbocian");
        } catch (SQLException e) {

            System.out.println("Conngetection Failed! Wrong data !");
            e.printStackTrace();
            return connection;
        }

        return connection;
    }
}