package org.example.dataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtils {

    private static Connection connection;

    public static void createConnection() {

        String dbUser = null, dbPassword = null, dbURL = null;

        FileInputStream fileInputStream;
        Properties properties = new Properties();

        try {
            fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInputStream);

            dbUser = properties.getProperty("db.user");
            dbPassword = properties.getProperty("db.password");
            dbURL = properties.getProperty("db.URL");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Class.forName("org.postgresql.Driver");
            if (dbURL != null & dbUser != null & dbPassword != null){
                connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Соединение открыто!");
    }

    public static void closeConnection(){
        try {
            connection.close();
            System.out.println("Соединение закрыто!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConn() {
        return connection;
    }
}
