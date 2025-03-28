package dao;

import utils.ConnectionManager;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AbsTable {

    protected String tableName;
    protected Map<String, String> columns = new HashMap<>();

    public AbsTable (String tableName) {
        this.tableName = tableName;
    }

    public void create() {
        String sqlRequest = String.format("CREATE TABLE IF NOT EXISTS %s (%S)", this.tableName, convertMapColumnsToString());
        try {
            ConnectionManager.getInstance().executeQuery(sqlRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertMapColumnsToString() {
        String result = "";
        for(Map.Entry<String, String> el : columns.entrySet()){
            result += el.getKey() + "" + el.getValue() + ",";
        }
        result = result.substring(0, result.length()-1);
        return result;
    }
}
