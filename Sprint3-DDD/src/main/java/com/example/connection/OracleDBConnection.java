package com.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBConnection {
    private static final String DB_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"; // Exemplo de URL do banco de dados Oracle
    private static final String DB_USER = "rm89162";
    private static final String DB_PASSWORD = "280400";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
