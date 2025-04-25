package JavaSwing.PrepareForExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataProvider {

    public static Connection ketNoi(){
        //return ketNoiSQLServer();
        return ketNoiMySQL();
    }

    /** Kết nối Cơ sở dữ liệu MySQL */
    public static Connection ketNoiMySQL(){
        Connection conn = null; //Khai báo đối tượng kết nối
        String username = "root";
        String password = "root";
        String DATABASE_LINK_MYSQL="jdbc:mysql://localhost:3306/qlnv";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");	//Dang ky driver
            conn = DriverManager.getConnection (DATABASE_LINK_MYSQL, username, password); //Thực hiện kết nối đến csdl
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Không kết nối được đến MySQL. Chi tiết:" + ex.getMessage());
        }
        return conn; //Trả về kết nối
    }


    /** Kết nối Cơ sở dữ liệu SQL Server */
    public static Connection ketNoiSQLServer(){
        Connection conn = null; //Khai báo đối tượng kết nối
        String username = "sa";
        String password = "pass";
        String DATABASE_LINK_SQLSERVER="jdbc:sqlserver://localhost:1433;databaseName=QLNV;trustServerCertificate=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Dang ky driver
            conn = DriverManager.getConnection (DATABASE_LINK_SQLSERVER, username, password); //Thực hiện kết nối đến csdl
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Không kết nối được đến SQLServer. Chi tiết:" + ex.getMessage());
        }
        //Trả về kết nối
        return conn;
    }

}
