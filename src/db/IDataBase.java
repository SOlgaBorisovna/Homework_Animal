package db;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDataBase {

    void requestExecute(String sqlRequest) throws SQLException, IOException;

    ResultSet requestExecuteWithReturned(String sqlRequest) throws SQLException, IOException;

    void close() throws SQLException;
}
