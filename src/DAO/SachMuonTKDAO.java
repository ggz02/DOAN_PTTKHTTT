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
import model.*;
/**
 *
 * @author minht
 */
public class SachMuonTKDAO implements DaoInterface<SachMuonTK>{

    public static SachMuonTKDAO getInstance(){
        return new SachMuonTKDAO();
    }
    
    @Override
    public void insert(SachMuonTK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(SachMuonTK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(SachMuonTK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<SachMuonTK> selectAll() {
        ArrayList<SachMuonTK> listSM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "SELECT pm.MaM,s.ISBN,s.MaSach,s.NamXB,Ngayhethan\n" +
                        "from Sach s join CTPhieuMuon ctpm on s.MaSach = ctpm.MaSach join PhieuMuon pm on pm.MaM = ctpm.MaM\n" +
                        "where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0\n" +
                        "order by ISBN";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                SachMuonTK sm = new SachMuonTK(resultSet.getString("MaM"),resultSet.getString("ISBN"),resultSet.getString("MaSach"),resultSet.getInt("NamXB"),resultSet.getString("Ngayhethan"));
                listSM.add(sm);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listSM;
    }

    @Override
    public ArrayList<SachMuonTK> selectByCondition(String Condition) {
         throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<SachMuonTK> selectByCondition(String Condition,int index) {
       ArrayList<SachMuonTK> listSM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "";
            if(index == 1){
                    querry = "SELECT pm.MaM,s.ISBN,s.MaSach,s.NamXB,Ngayhethan\n" +
                    "from Sach s join CTPhieuMuon ctpm on s.MaSach = ctpm.MaSach join PhieuMuon pm on pm.MaM = ctpm.MaM\n" +
                    "where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0 and MONTH(Ngayhethan) = MONTH(GETDATE())\n" +
                    "order by ISBN";
            }
            if(index == 2){
                 querry = "SELECT pm.MaM,s.ISBN,s.MaSach,s.NamXB,Ngayhethan\n" +
                    "from Sach s join CTPhieuMuon ctpm on s.MaSach = ctpm.MaSach join PhieuMuon pm on pm.MaM = ctpm.MaM\n" +
                    "where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0 and Year(Ngayhethan) = Year(GETDATE())\n" +
                    "order by ISBN"  ;
            
            }
            if(index == 3){
                 querry = "SELECT pm.MaM,s.ISBN,s.MaSach,s.NamXB,Ngayhethan\n" +
                "from Sach s join CTPhieuMuon ctpm on s.MaSach = ctpm.MaSach join PhieuMuon pm on pm.MaM = ctpm.MaM\n" +
                "where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0 and Year(Ngayhethan) = year(GETDATE()) -1\n" +
                "order by ISBN"; 
            }
            if(index == 4){
                querry = "SELECT pm.MaM,s.ISBN,s.MaSach,s.NamXB,Ngayhethan\n" +
                        "from Sach s join CTPhieuMuon ctpm on s.MaSach = ctpm.MaSach join PhieuMuon pm on pm.MaM = ctpm.MaM\n" +
                        "where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0 and ('"+Condition +"' between Ngaymuon and Ngayhethan)\n" +
                        "order by ISBN";
            }
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                SachMuonTK sm = new SachMuonTK(resultSet.getString("MaM"),resultSet.getString("ISBN"),resultSet.getString("MaSach"),resultSet.getInt("NamXB"),resultSet.getString("Ngayhethan"));
                listSM.add(sm);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listSM;  
    }
    
}
