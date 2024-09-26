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
public class ThuThuDAO implements DaoInterface<ThuThu> {
    public static ThuThuDAO getInstance() {
        return new ThuThuDAO();
    }

    @Override
    public void insert(ThuThu t) {
       Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into ThuThu(MaTT,HoTenTT,NgaySinhTT,GioiTinhTT,DthoaiTT,DiachiTT)" 
                    + "values(?,?,?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaTT());
            prst.setString(2, t.getHoTenTT());
            prst.setString(3,t.getNgaySinhTT());
            prst.setString(4, t.getGioiTinhTT());
            prst.setString(5,t.getDienThoaiTT());  
            prst.setString(6,t.getDiaChiTT());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }

    @Override
    public void update(ThuThu t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String Querry = "update ThuThu" +
                    " set"
                    + " MaTT = ?,"
                    + "HoTenTT = ?,"
                    + "NgaySinhTT = ?,"
                    + "GioiTinhTT = ?,"
                    + "DthoaiTT = ?,"         
                    + "DiachiTT = ?"            
                    + " where MaTT = ?";
            prst = conn.prepareCall(Querry);
            prst.setString(1,t.getMaTT());
            prst.setString(2, t.getHoTenTT());
            prst.setString(3,t.getNgaySinhTT());
            prst.setString(4, t.getGioiTinhTT());
            prst.setString(5,t.getDienThoaiTT());  
            prst.setString(6,t.getDiaChiTT());
            prst.setString(7,t.getMaTT());

            
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa dữ liệu thành công " + rs);
            }
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(ThuThu t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String Querry = "delete from ThuThu" +
                    " where "
                    + " MaTT = ? and "
                    + "HoTenTT = ? and "
                    + "NgaySinhTT = ? and "
                    + "GioiTinhTT = ? and "
                    + "DthoaiTT = ? and "
                    + "DiachiTT = ?";
                       prst = conn.prepareCall(Querry);
            prst.setString(1,t.getMaTT());
            prst.setString(2, t.getHoTenTT());
            prst.setString(3,t.getNgaySinhTT());
            prst.setString(4, t.getGioiTinhTT());
            prst.setString(5,t.getDienThoaiTT());  
            prst.setString(6,t.getDiaChiTT());
            
            int rs = prst.executeUpdate();
            if(rs > 0) {
                System.out.println("Xóa thành công");
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
             Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                conn.close();
                System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
    }

    @Override
    public ArrayList<ThuThu> selectAll() {
        ArrayList<ThuThu> listHV = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from ThuThu";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                ThuThu tt = new ThuThu(resultSet.getString("MaTT"),resultSet.getString("HoTenTT"),resultSet.getString("NgaySinhTT"),resultSet.getString("GioiTinhTT"),resultSet.getString("DthoaiTT"),resultSet.getString("DiachiTT"));
                listHV.add(tt);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listHV;
    }
    
 public ArrayList<ThuThu> selectNewMaTT(){
        ArrayList<ThuThu> listTT = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select top 1 * from ThuThu order by MaTT desc";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                ThuThu tt = new ThuThu(resultSet.getString("MaTT"),resultSet.getString("HoTenTT"),resultSet.getString("NgaySinhTT"),resultSet.getString("GioiTinhTT"),resultSet.getString("DthoaiTT"),resultSet.getString("DiachiTT"));
                listTT.add(tt);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(ThuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listTT;
    }


    @Override
    public ArrayList<ThuThu> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
