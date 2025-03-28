package utils;

import java.sql.*;

public class ConnectionManager {
    private final String url = System.getenv("url");
    private final String user = System.getenv("login");
    private final String password = System.getenv("pass");

    private Connection connection;
    private Statement statement;

    private static ConnectionManager instance;

    private ConnectionManager(){
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConnectionManager getInstance(){
        if(instance == null)
            instance = new ConnectionManager();
        return instance;
    }

    public ResultSet executeQueryWithAnswer(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void executeQuery(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }
}