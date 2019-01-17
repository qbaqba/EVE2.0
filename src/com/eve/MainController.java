package com.eve;

import com.eve.model.User;
import com.eve.util.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/MainController")
public class MainController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setLogin("Kuba");
        user.setId(2);
        user.setPassword("blalba");

      /*  try {
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            String text = "INSERT INTO user VALUES(4, 'ja', 'haslo');";
            stmt.executeUpdate(text);
        } catch (SQLException e) {
            e.printStackTrace();
        } */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet test");
        User user = new User(5,"kuba","balaa");


        System.out.println("System");
        System.out.println(user.toString());
        System.out.println(user.hashCode());
    }
}
