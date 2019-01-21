package com.eve.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

    private static DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        return getDSInstance().getConnection();
    }

    private static DataSource getDSInstance() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/eve");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }
}
