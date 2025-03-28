package db;

import properties.FilePropertyReader;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

public class MySqlConnectionDb implements IDataBase {

    private Connection connection = null;
    private Statement statement = null;

    private String url = "jdbc:";
    private String login = System.getProperty("login");
    private String password = System.getProperty("password");

    private void openConnectToDb() throws SQLException, IOException {
        if(connection == null) {
            Map<String, String> settings = new FilePropertyReader().getSettings();
            connection = DriverManager.getConnection(settings.get("url"), settings.get("login"), settings.get("password"));
        }

        if (statement == null) {
            statement = connection.createStatement();
        }
    }

    public void requestExecute(String sqlRequest) throws SQLException, IOException {
        openConnectToDb();
        statement.execute(sqlRequest);
    }

    public ResultSet requestExecuteWithReturned(String sqlRequest) throws SQLException, IOException {
        openConnectToDb();
        return statement.executeQuery(sqlRequest);
    }

    public void close() throws SQLException {
        if(statement != null) {
            statement.close();
        }

        if(connection != null) {
            connection.close();
        }
    }
}
