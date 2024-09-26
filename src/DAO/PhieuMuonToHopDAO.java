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
import sun.security.jca.GetInstance;
/**
 *
 * @author minht
 */
public class PhieuMuonToHopDAO implements DaoInterface<PhieuMuonToHop>{

    public static PhieuMuonToHopDAO getInstance(){
        return new PhieuMuonToHopDAO();
    }
    
    @Override
    public void insert(PhieuMuonToHop t) {
       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(PhieuMuonToHop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(PhieuMuonToHop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PhieuMuonToHop> selectAll() {
        ArrayList<PhieuMuonToHop> listPM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
            "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG ";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                PhieuMuonToHop pm = new PhieuMuonToHop(resultSet.getString("MaM"),resultSet.getString("hoTenDG"),resultSet.getString("Ngaymuon"),resultSet.getString("Ngayhethan"),resultSet.getInt("SoLuongM"),resultSet.getString("Ghichu"));
                listPM.add(pm);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPM;
    }

    @Override
    public ArrayList<PhieuMuonToHop> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<PhieuMuonToHop> selectByCondition(String Condition, int index){
        ArrayList<PhieuMuonToHop> listPM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
           conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry =""; 
            if(index == 1) {
             querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
                    "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG " +
            "           where Ngaymuon = '"+ Condition +"'";
            } 
            if (index == 2){
                querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
                    "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG " +
            "		where Month(Ngaymuon) = '"+ Condition +"' and Year(Ngaymuon) = year(getdate())";
            }
            if (index == 3){
                querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
                    "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG " +
            "		where Ngayhethan = '"+ Condition +"'";
            }
            if (index == 4) {
                    querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
                    "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG " +
            "		where Month(Ngayhethan) = '"+ Condition +"' and Year(Ngayhethan) = year(getdate())";
            }
            if (index == 5) {
                querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
                    "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG " +
            "		where Year(Ngaymuon) = year(getdate())";    
            }
            if (index == 6) {
                    querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
                    "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG " +
            "		where Year(Ngayhethan) = year(getdate())";  
            }
            if (index == 7) {
                querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
                    "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG " +
            "		where Year(Ngaymuon) = year(getdate()) -1";    
            }
            if (index == 8) {
                    querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
                    "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG " +
            "		where Year(Ngayhethan) = year(getdate()) -1";  
            }
            if(index == 9) {
                    querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
                    "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG " +
            "		where MaM = '"+Condition+"'";  
            }
//            if(index == 10) {
//                    querry = "select MaM,HoTenDG, Ngaymuon,Ngayhethan,SoLuongM, Ghichu\n" +
//                    "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG " +
//            "		where MaM = '"+Condition+"'";  
//            }
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                
                PhieuMuonToHop pm = new PhieuMuonToHop(resultSet.getString("MaM"),resultSet.getString("HoTenDG"),resultSet.getString("Ngaymuon"),resultSet.getString("Ngayhethan"),resultSet.getInt("SoLuongM"),resultSet.getString("Ghichu"));
                listPM.add(pm);
            }
            
            ConnectionSQL.closeConnection(conn);
            
            
        } catch (SQLException ex) {
             Logger.getLogger(PhieuMuonToHop.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonToHop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonToHop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPM;
    }
    
     public ArrayList<PhieuMuonToHop> selectNameDGNotInPT() {
        ArrayList<PhieuMuonToHop> listPM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "";
            
                querry = "SELECT DISTINCT HoTenDG\n" +
                        "FROM (\n" +
                        "    SELECT HoTenDG\n" +
                        "    FROM DocGia\n" +
                        "    WHERE MaDG IN (\n" +
                        "        SELECT MaDG\n" +
                        "        FROM PhieuMuon\n" +
                        "        WHERE MaM NOT IN (\n" +
                        "            SELECT MaM\n" +
                        "            FROM PhieuTra\n" +
                        "        )\n" +
                        "    )\n" +
                        "    UNION ALL\n" +
                        "    SELECT HoTenDG\n" +
                        "    FROM DocGia dg\n" +
                        "    JOIN PhieuMuon pm ON dg.MaDG = pm.MaDG\n" +
                        "    JOIN CTPhieuMuon ctpm ON ctpm.MaM = pm.MaM\n" +
                        "    WHERE ctpm.MaSach IN (\n" +
                        "        SELECT MaSach\n" +
                        "        FROM CTPhieuMuon ctpm\n" +
                        "        WHERE MaSach NOT IN (\n" +
                        "            SELECT MaSach\n" +
                        "            FROM CTPhieuTra\n" +
                        "        )\n" +
                        "    )\n" +
                        ") AS subquery";
            
            
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                PhieuMuonToHop pm = new PhieuMuonToHop();
                pm.setHoTen(resultSet.getString("HoTenDG"));
                listPM.add(pm);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPM;
    }
     
     
      public ArrayList<PhieuMuonToHop> selectMaMNotInPT(String Condition, int index,String Condition2) {
        ArrayList<PhieuMuonToHop> listPM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "";
            if (index == 1){    
            querry = "select MaM\n" +
                "from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG\n" +
                "where HoTenDG = N'"+Condition+"' and MaM not in (select MaM from PhieuTra)";
            } else if (index == 2) {
                querry ="select pm.MaM\n" +
"                from PhieuMuon pm join DocGia dg on pm.MaDG = dg.MaDG join CTPhieuMuon ctpm on ctpm.MaM = pm.MaM\n" +
"                where HoTenDG = N'"+Condition+"' and MaSach ='"+Condition2+"' ";
            }
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                PhieuMuonToHop pm = new PhieuMuonToHop();
                pm.setMaM(resultSet.getString("MaM"));
                listPM.add(pm);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPM;
    }
      
      
      
}
