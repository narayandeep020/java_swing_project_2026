package com.bookstore;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {

    private static Properties proper = new Properties();
    private static final String PROPERTIES_FILE = "system.properties";

    static {
        loadProperties();
    }

    private static void loadProperties() {

        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            proper.load(fis);
            System.out.println("Properties file load successfully :" + PROPERTIES_FILE);
        } catch (Exception e) {
            System.out.println("Error loading properties file " + e.getMessage());
        }
    }

    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName(proper.getProperty("driver"));

        String url = proper.getProperty("url");
        String userName = proper.getProperty("username");
        String password = proper.getProperty("password");

        Connection conn = DriverManager.getConnection(url, userName, password);
        System.out.println("connection Established successfully: " + url);

        return conn;

    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed....:");
            } catch (Exception e) {
                System.out.println("Error closing resource..:");
            }
        }
    }

    public static String getProperty(String key) {
        return proper.getProperty(key);
    }

    public static void reloadProperty() {
        loadProperties();
        System.out.println("Properties Reload Successfully:");
    }
}

