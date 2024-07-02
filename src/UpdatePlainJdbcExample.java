// UPDATE 기능

// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
//
// public class UpdatePlainJdbcExample {
//    private final static String SQL = "UPDATE students SET name = ?, age = ?, address = ?, WHERE
// id = ?";
//
//    public static void main(String[] args){
//        // 1. DB 접근하기 위한 DB 커넥션 (username, pw, db_url)
//        try (connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db",
// "root", "0000", PreparedStatement pstmt = conn.prepareStatement(QUERY));{
//
//            // 2. 커넥션 맺은 상태에서 스테이트먼트 conn.statement
//            PreparedStatement psmt = conn.prepareStatement(SQL)) {
//                psmt.setString(1, "장이수2");
//                psmt.setInt(2, 41);
//                psmt.setString(3, "제주도");
//                psmt.setInt(4, 3);  // 아이디가 3인 열만
//
//                int rowNum = psmt.executeUpdate();
//                // 3. 실행 결과 출력
//                System.out.println("rowNum = " + rowNum);
//
//        } catch (SQLException e){
//            System.out.println(e.getMessage);
//            }
//
//
//    }
// }

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePlainJdbcExample {
  private static final String SQL = "UPDATE students SET name=?, age=?, address=? WHERE id=?";
  private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
  private static final String username = "root";
  private static final String password = "0000";

  public static void main(String[] args) {
    // 1. DB Conn (username, pw, db_url)
    try (Connection conn = DriverManager.getConnection(DB_URL, username, password);
        PreparedStatement ps = conn.prepareStatement(SQL)) {

      // 2. conn.statement  (SQL)
      ps.setString(1, "장이수2");
      ps.setInt(2, 41);
      ps.setString(3, "제주도");
      ps.setInt(4, 3);

      int rowNum = ps.executeUpdate();
      // 3. 실행 결과 출력
      System.out.println("rowNum = " + rowNum);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
