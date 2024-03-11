package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            //JDBC 드라이버 등록
            Class.forName("oracle.jdbc.OracleDriver");

            //DB 연결
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott",
                "tiger");

            System.out.println("DB 연결 성공");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
