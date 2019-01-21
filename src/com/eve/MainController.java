package com.eve;

import com.eve.model.User;
import com.eve.util.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/MainController")
public class MainController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setLogin("Kuba");
        user.setId(2);
        user.setPassword("blalba");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet test");
        User user = new User(5,"kuba","balaa");


        System.out.println("System");
        System.out.println(user.toString());
        System.out.println(user.hashCode());

        try (Connection conn = ConnectionProvider.getConnection()) {
            Statement statement = conn.createStatement();
            final String sqlQuery = "INSERT INTO user VALUES(582, 'fsdfdsfcxf', 'hfdsfdsaslo');";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        /*try {
            // Connection conn = ConnectionProvider.getConnection();

            //  Statement stmt = conn.createStatement();

             final String driver = "com.mysql.jdbc.Driver";
             Class.forName(driver);

            final String dbPath = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&serverTimezone=UTC&useSSL=false";
            Connection conn = DriverManager.getConnection(dbPath, "root","admin");

            Statement statement = conn.createStatement();
            final String sqlQuery = "INSERT INTO user VALUES(58, 'fsdfdsff', 'hfdsfdsaslo');";
            statement.executeUpdate(sqlQuery);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}
