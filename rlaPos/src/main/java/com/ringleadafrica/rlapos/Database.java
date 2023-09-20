package com.ringleadafrica.rlapos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static Connection DbConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/rlapos", "root", "");
            return connect;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
