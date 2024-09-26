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
public class TheThuVienDAO implements DaoInterface<TheThuVien>{

    public static TheThuVienDAO getInstance() {
        return new TheThuVienDAO();
    }
    
    @Override
    public void insert(TheThuVien t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into TheThuVien(Mathe,MaDG,Ngaytao,HanThe)" 
                    + "values(?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaThe());
            prst.setString(2, t.getMaDG());
            prst.setString(3,t.getNgayTao());
            prst.setString(4,t.getHanThe());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    @Override
    public void update(TheThuVien t) {
       Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update TheThuVien" +
                    " set"
                    + " Mathe = ?,"
                    + "MaDG = ?,"
                    + "Ngaytao = ?,"
                    + "HanThe = ?"
                    + " where Mathe = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaThe());
            prst.setString(2, t.getMaDG());
            prst.setString(3,t.getNgayTao());
            prst.setString(4,t.getHanThe());
            prst.setString(5, t.getMaThe());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công " + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
 
    }

    @Override
    public void delete(TheThuVien t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from TheThuVien" +
                    " where "
                    + " Mathe = ? and "
                    + "MaDG = ? and "
                    + "Ngaytao = ? and "
                    + "HanThe = ? ";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaThe());
            prst.setString(2, t.getMaDG());
            prst.setString(3,t.getNgayTao());
            prst.setString(4,t.getHanThe());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công " + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public ArrayList<TheThuVien> selectAll() {
        ArrayList<TheThuVien> listThe = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from TheThuVien";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                TheThuVien ttv = new TheThuVien(resultSet.getString("Mathe"), resultSet.getString("MaDG"),resultSet.getString("Ngaytao"), resultSet.getString("HanThe"));
                listThe.add(ttv);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listThe;
    }
    
    public ArrayList<TheThuVien> selectNewMaTT(){
        ArrayList<TheThuVien> listThe = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select top 1 * from TheThuVien order by Mathe desc";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                TheThuVien ttv = new TheThuVien(resultSet.getString("Mathe"), resultSet.getString("MaDG"),resultSet.getString("Ngaytao"), resultSet.getString("HanThe"));
                listThe.add(ttv);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheThuVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listThe;
    }



    @Override
    public ArrayList<TheThuVien> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
