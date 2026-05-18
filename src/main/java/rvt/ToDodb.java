package rvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ToDodb {
    public static void main(String[] args) {
        try (
            Connection connection = 
            DriverManager.getConnection(
                "jdbc:sqlite:todo.db"
            );
            Statement statement = connection.createStatement();
        ) {
            String sql = "CREATE TABLE IF NOT EXISTS todo"
            + "(id INTEGER PRIMARY KEY, task TEXT NOT NULL) STRICT";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
