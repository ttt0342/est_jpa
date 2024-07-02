// Plain Java JDBC Code - 조회 기능

//import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class PlainJdbcExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "root";   // DB username
    static final String PASS = "0000";   // DB Password
    static final String QUERY = "SELECT * FROM students";   // 조회

    public static void main(String[] args) {
        // Open & get a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            // Extract data from result set after execute query
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", name: " + rs.getString("name"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.println(", address: " + rs.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
    } // JDBC API 직접 사용해서 java 코드상에서 DBMS에 접근/출력해본 것
      // 디버깅에서 f8, f9 사용하기
}

