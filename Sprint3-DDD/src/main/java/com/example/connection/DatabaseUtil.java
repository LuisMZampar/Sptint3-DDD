package com.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    public static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
        String username = "SEU_USUARIO";
        String password = "SUA_SENHA";

        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
