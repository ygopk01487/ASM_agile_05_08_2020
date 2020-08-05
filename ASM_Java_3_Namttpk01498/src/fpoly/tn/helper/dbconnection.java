/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author TRINH THE NAM
 */
public class dbconnection {
    private static String DB_URL = "jdbc:sqlserver://localhost;"
            + "databaseName=QLSanPham;";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "244466666";
    
    public static Connection conn;
    
    public dbconnection() {
    conn = getConnection(DB_URL, USER_NAME, PASSWORD);
    }
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    public static ResultSet ExecuteQuerySelect(String sql) {
        try {
            Statement stm = conn.createStatement();
            return stm.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println("lỗi SQL" + ex.getMessage());
            return null;
        }
        
    }
    //Hàm thực thi lệnh UPDATE, DELETE, INSERT
    public static int ExecuteQueryUpdate(String sql) {
        try {
            //Tạo Statement
            Statement stm = conn.createStatement();
            //Thực hiện truy vấn cập nhật dữ liệu
            return stm.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("lỗi SQL" + ex.getMessage());
            return 0;
        }
    }

}


