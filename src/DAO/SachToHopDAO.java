/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.ConnectionSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PhieuNhapToHop;
import model.SachToHop;

/**
 *
 * @author minht
 */
public class SachToHopDAO implements DaoInterface<SachToHop>{

    public static SachToHopDAO getInstance(){
        return new SachToHopDAO();
    }
    
    @Override
    public void insert(SachToHop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(SachToHop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(SachToHop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<SachToHop> selectAll() {
         ArrayList<SachToHop> listS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select  ds.ISBN,tl.TenLoai,TenSach,Tacgia,NXB, SoLuong,Thongtinsach\n" +
"                from DauSach ds  join TheLoai tl on tl.MaLoai = ds.MaLoai";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                SachToHop pn = new SachToHop(resultSet.getString("ISBN"),resultSet.getString("TenLoai"),resultSet.getString("TenSach"),resultSet.getString("Tacgia"),resultSet.getString("NXB"),resultSet.getInt("SoLuong"),resultSet.getString("Thongtinsach"));
                listS.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listS;
    }

    @Override
    public ArrayList<SachToHop> selectByCondition(String Condition) {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
    
     public ArrayList<SachToHop> selectByCondition(String ConditionString, int index) {
        ArrayList<SachToHop> listS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "";
            if(index == 1){
                    querry = "select  ds.ISBN,tl.TenLoai,TenSach,Tacgia,NXB, SoLuong,Thongtinsach\n" +
"             from DauSach ds  join TheLoai tl on tl.MaLoai = ds.MaLoai\n" +
"			 where ISBN = '"+ConditionString+"'";
            } 
            if (index == 2){
                 querry = "select  ds.ISBN,tl.TenLoai,TenSach,Tacgia,NXB, SoLuong,Thongtinsach\n" +
"             from DauSach ds  join TheLoai tl on tl.MaLoai = ds.MaLoai\n" +
"			 where TenSach = N'"+ConditionString+"'";
            }
            if (index == 3){
                querry = "select  ds.ISBN,tl.TenLoai,TenSach,Tacgia,NXB, SoLuong,Thongtinsach\n" +
"             from DauSach ds  join TheLoai tl on tl.MaLoai = ds.MaLoai\n" +
"			 where Tacgia = N'"+ConditionString+"'";
            }
            if (index == 4){
                querry = "select  ds.ISBN,tl.TenLoai,TenSach,Tacgia,NXB, SoLuong,Thongtinsach\n" +
"                        from DauSach ds  join TheLoai tl on tl.MaLoai = ds.MaLoai\n" +
"			 where TenLoai = N'"+ConditionString+"'"; 
            }
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                SachToHop pn = new SachToHop(resultSet.getString("ISBN"),resultSet.getString("TenLoai"),resultSet.getString("TenSach"),resultSet.getString("Tacgia"),resultSet.getString("NXB"),resultSet.getInt("SoLuong"),resultSet.getString("Thongtinsach"));
                listS.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listS; 
    }
    
}
