package rvt.todo_list;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ToDodb {

    private static final String DB_URL = "jdbc:sqlite:todo.db";
    public ToDodb(){
        initSchema();
    }

    private Connection connect() throws SQLException{
        return DriverManager.getConnection(DB_URL);
    }

    public void initSchema(){
        String sql = "CREATE TABLE IF NOT EXISTS todo ("
        + "id INTEGER PRIMARY KEY," 
        + "task TEXT NOT NULL) STRICT";
        try(
            Connection conn = connect();
            Statement stmt = conn.createStatement()
        ) {
            stmt.execute(sql);
        }catch (SQLException e){
            throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }

    public void add(String task){
        String sql = "INSERT INTO todo ("
        + "task TEXT NOT NULL) STRICT";
        try(
            Connection conn = connect();
            Statement stmt = conn.createStatement()
        ) {
            stmt.execute(sql);
        }catch (SQLException e){
            throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }
    
}
