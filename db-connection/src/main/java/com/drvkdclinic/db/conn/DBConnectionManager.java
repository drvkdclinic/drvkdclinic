package com.drvkdclinic.db.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/drvkdclinic";
    private static final String USER = "clinic_user";
    private static final String PASSWORD = "strongpassword";

    private DBConnectionManager() { }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
