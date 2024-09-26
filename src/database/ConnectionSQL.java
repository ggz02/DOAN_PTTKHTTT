/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author minht
 */
public class ConnectionSQL {
    static final String DB_URL = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyThuVienUFM;ser=sa;password=123456";
   static  final String USER = "sa";
   static final String PASS = "123456";
   
    public static Connection getConnection() {
        Connection c = null;
        
        try {
            //Khởi tạo trình điều khiển nếu dùng sql thì sẽ là sql sever oracle thì sẽ là oracle
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Đang kết nối cơ sở dữ liệu....");
            c = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("Kết nối thất bại");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Kết nối thất bại");
        }
        
        return c;
    }
    
       public static void printInfo (Connection c) {
       try {
       if (c!= null) {
           System.out.println(c.getMetaData().toString());
           System.out.println(c.getMetaData().getDatabaseProductName());
           System.out.println(c.getMetaData().getDatabaseProductVersion());

       }    
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   
       
     public static void closeConnection(Connection c) {
       try {
           if (c != null) {
               c.close();
               System.out.println("Đóng kết nối");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
    
    
    
    
    
}
