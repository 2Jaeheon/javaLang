package ch20.oracle.sec06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UserInsertExample {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott",
                "tiger");

            //매개변수화된 SLQ문 작성
            String sql = "" +
                "INSERT INTO users (userid, username, userpassword, userage, useremail) "
                + "VALUES(?, ?, ?, ?, ?)";

            //PreparedStatement 객체 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");
            pstmt.setString(2, "겨울");
            pstmt.setString(3, "1234");
            pstmt.setInt(4, 25);
            pstmt.setString(5, "winter@myCompany.com");

            //SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수 : " + rows);

            pstmt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
