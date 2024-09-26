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
public class PhieuMuonTKDAO implements DaoInterface<PhieuMuonTK> {

    
    public static PhieuMuonTKDAO getInstance(){
        return new PhieuMuonTKDAO();
    }
    
    @Override
    public void insert(PhieuMuonTK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(PhieuMuonTK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(PhieuMuonTK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PhieuMuonTK> selectAll() {
        ArrayList<PhieuMuonTK> listPM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select *,DATEDIFF(DAY,Ngayhethan,GETDATE()) as N'SoNgayTre'\n" +
                        "from PhieuMuon\n" +
                        "	where DATEDIFF(DAY,Ngayhethan,GETDATE()) > 0 and MaM not in (\n" +
                        "		select MaM\n" +
                        "		from PhieuTra\n" +
                        "	)";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                PhieuMuonTK pm = new PhieuMuonTK(resultSet.getString("MaM"),resultSet.getString("MaDG"),resultSet.getString("MaTT"),resultSet.getString("Ngaymuon"),resultSet.getString("Ngayhethan"),resultSet.getInt("SoLuongM"),resultSet.getString("Ghichu"),resultSet.getInt("SoNgayTre"));
                listPM.add(pm);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPM;
    }

    @Override
    public ArrayList<PhieuMuonTK> selectByCondition(String Condition) {
       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
    
    public ArrayList<PhieuMuonTK> selectByCondition(String Condition,int index) {
        ArrayList<PhieuMuonTK> listPM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
                try {
            conn = ConnectionSQL.getConnection();
            String querry = "";
            if(index == 1){
                    querry = "select *,DATEDIFF(DAY,Ngayhethan,GETDATE()) as N'SoNgayTre'\n" +
                            "from PhieuMuon\n" +
                            "	where DATEDIFF(DAY,Ngayhethan,GETDATE()) > 0 and MONTH(Ngayhethan) = MONTH(GETDATE()) and MaM not in (\n" +
                            "		select MaM\n" +
                            "		from PhieuTra\n" +
                            "	)";
            }
            if(index == 2){
                 querry = "select *,DATEDIFF(DAY,Ngayhethan,GETDATE()) as N'SoNgayTre'\n" +
                        "from PhieuMuon\n" +
                        "	where DATEDIFF(DAY,Ngayhethan,GETDATE()) > 0 and Year(Ngayhethan) = year(GETDATE()) and MaM not in (\n" +
                        "		select MaM\n" +
                        "		from PhieuTra\n" +
                        "	)"  ;
            
            }
            if(index == 3){
                 querry = "select *,DATEDIFF(DAY,Ngayhethan,GETDATE()) as N'SoNgayTre'\n" +
                        "from PhieuMuon\n" +
                        "	where DATEDIFF(DAY,Ngayhethan,GETDATE()) > 0 and Year(Ngayhethan) = year(GETDATE()) - 1 and MaM not in (\n" +
                        "		select MaM\n" +
                        "		from PhieuTra\n" +
                        "	)"; 
            }
            if(index == 4){
                querry = "select *,DATEDIFF(DAY,Ngayhethan,GETDATE()) as N'SoNgayTre'\n" +
                        "from PhieuMuon\n" +
                        "	where DATEDIFF(DAY,Ngayhethan,GETDATE()) > 0 and  '"+Condition+"' = Ngayhethan and MaM not in (\n" +
                        "		select MaM\n" +
                        "		from PhieuTra\n" +
                        "	)";
            }
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                PhieuMuonTK pm = new PhieuMuonTK(resultSet.getString("MaM"),resultSet.getString("MaDG"),resultSet.getString("MaTT"),resultSet.getString("Ngaymuon"),resultSet.getString("Ngayhethan"),resultSet.getInt("SoLuongM"),resultSet.getString("Ghichu"),resultSet.getInt("SoNgayTre"));
                listPM.add(pm);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonTKDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
                return listPM;
    }
    
    
}
