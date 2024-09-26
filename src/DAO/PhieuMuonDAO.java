/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.ConnectionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class PhieuMuonDAO implements DaoInterface<PhieuMuon>{

    public static PhieuMuonDAO getInstance() {
        return new PhieuMuonDAO();
    }
    
    @Override
    public void insert(PhieuMuon t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into PhieuMuon(MaM,MaDG,MaTT,Ngaymuon,Ngayhethan,SoLuongM,Ghichu)" 
                    + "values(?,?,?,?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaM());
            prst.setString(2, t.getMaDG());
            prst.setString(3,t.getMaTT());
            prst.setString(4, t.getNgayMuon());
            prst.setString(5,t.getNgayHetHan());  
            prst.setString(6,Integer.toString(t.getSoLuongMuon()));
            prst.setString(7,t.getGhiChu());


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    }

    @Override
    public void update(PhieuMuon t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update PhieuMuon" +
                    " set"
                    + " MaM = ?,"
                    + "MaHV = ?,"
                    + "MaTT = ?,"
                    + "Ngaymuon = ?,"
                    + "Ngayhethan = ?,"         
                    + "SoLuongM = ?,"            
                    + "Ghichu = ? "
                    + " where MaM = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaM());
            prst.setString(2, t.getMaDG());
            prst.setString(3,t.getMaTT());
            prst.setString(4, t.getNgayMuon());
            prst.setString(5,t.getNgayHetHan());  
            prst.setString(6,Integer.toString(t.getSoLuongMuon()));
            prst.setString(7,t.getGhiChu());
            prst.setString(8, t.getMaM());



            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    }

    @Override
    public void delete(PhieuMuon t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from PhieuMuon" +
                    " where "
                    + " MaM = ? and "
                    + "MaHV = ? and "
                    + "MaTT = ? and "
                    + "Ngaymuon = ? and "
                    + "Ngayhethan = ? and "         
                    + "SoLuongM = ? and "            
                    + "Ghichu = ? ";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaM());
            prst.setString(2, t.getMaDG());
            prst.setString(3,t.getMaTT());
            prst.setString(4, t.getNgayMuon());
            prst.setString(5,t.getNgayHetHan());  
            prst.setString(6,Integer.toString(t.getSoLuongMuon()));
            prst.setString(7,t.getGhiChu());


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }
    
    
    public ArrayList<PhieuMuon> selectMaM() {
         ArrayList<PhieuMuon> listMM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
             querry = "select top 1 MaM\n" +
                    "from PhieuMuon\n" +
                    "order by MaM desc";

            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String MaM = resultSet.getString("MaM");
                PhieuMuon pm = new PhieuMuon();
                pm.setMaM(MaM);
                listMM.add(pm);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listMM;
    } 

    @Override
    public ArrayList<PhieuMuon> selectAll() {
        ArrayList<PhieuMuon> listPM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from PhieuMuon";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                PhieuMuon pm = new PhieuMuon(resultSet.getString("MaM"),resultSet.getString("MaDG"),resultSet.getString("MaTT"),resultSet.getString("Ngaymuon"),resultSet.getString("Ngayhethan"),resultSet.getInt("SoLuongM"),resultSet.getString("Ghichu"));
                listPM.add(pm);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPM;
    }


    @Override
    public ArrayList<PhieuMuon> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<PhieuMuon> selectSoLuongMNotInPT(String Condition) {
        ArrayList<PhieuMuon> listPM = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select SoLuongM\n" +
                "from PhieuMuon\n" +
                "where MaM = '"+Condition+"'";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setSoLuongMuon(resultSet.getInt("SoLuongM"));
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
