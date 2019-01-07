package com.ey.spring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:sqlite:database.db";
        String user = "hbstudent";
        String pass = "hbstudent";
        System.out.println("Connecting to database: " + jdbcUrl);
        try (Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass)) {


            //myConn
            System.out.println("Connection successful!!!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

}



