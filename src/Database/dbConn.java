package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class dbConn {
    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String pw = "admin";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버 오류" + e.getMessage());
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, pw);
            System.out.println("정상적으로 연결되었습니다.");
        } catch (SQLException e) {
            System.err.println("localhost url 오류:" + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    // Auto-Close
    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Auto-Close
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Auto-Close
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


