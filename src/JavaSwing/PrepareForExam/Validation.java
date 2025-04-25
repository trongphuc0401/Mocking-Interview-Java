package JavaSwing.PrepareForExam;

import java.sql.Connection;
import java.sql.SQLException;

public class Validation {


    public static void handleSQLException(SQLException e) {
        System.out.println("SQLException. Lỗi hệ thống: " + e.getMessage());
    }


    public static void closeConnection(Connection conn){
        try {
            if(conn != null) {
                conn.close();
            }
        }  catch (SQLException ex) {
            System.out.println("Lỗi hệ thống: " + ex.getMessage());
        }
    }
    public static void erroSystem(Connection conn) {
        System.out.println("Kiểm tra lỗi hệ thống với kết nối: " + conn);
    }
}
