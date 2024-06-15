/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection myConnection = null;
    private static final String myUrl = "jdbc:mysql://localhost:3306/csm3023";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public DBConnection() {}

    public static Connection getConnection() throws ClassNotFoundException {
        if (myConnection != null) {
            return myConnection;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                myConnection = DriverManager.getConnection(myUrl, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return myConnection;
        }
    }

    public static void closeConnection() {
        if (myConnection != null) {
            try {
                myConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
