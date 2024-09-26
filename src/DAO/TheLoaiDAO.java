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
public class TheLoaiDAO implements DaoInterface<TheLoai>{

    public static TheLoaiDAO getInstance(){
        return new TheLoaiDAO();
    }
    
    @Override
    public void insert(TheLoai t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into TheLoai(MaLoai,TenLoai)" 
                    + "values(?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaLoai());
            prst.setString(2, t.getTenLoai());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void update(TheLoai t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update TheLoai" +
                    " set"
                    + " MaLoai = ?,"
                    + "TenLoai = ?"
                    + " where MaLoai = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaLoai());
            prst.setString(2, t.getTenLoai());
            prst.setString(3, t.getMaLoai());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công " + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(TheLoai t) {
Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from TheLoai" +
                    " where "
                    + " MaLoai = ? and "
                    + "TenLoai = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaLoai());
            prst.setString(2, t.getTenLoai());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công " + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    }

    @Override
    public ArrayList<TheLoai> selectAll() {
    ArrayList<TheLoai> listTL = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from TheLoai";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                TheLoai tl = new TheLoai(resultSet.getString("MaLoai"), resultSet.getString("TenLoai"));
                listTL.add(tl);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listTL;    }


    @Override
    public ArrayList<TheLoai> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<TheLoai> selectTenLoaiSach(String Condition, int index) {
    ArrayList<TheLoai> listTL = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "";
            if (index == 1){
                querry = "select MaLoai,TenLoai from TheLoai";
            } if(index == 2){
                querry = "select MaLoai,TenLoai from TheLoai where TenLoai = N'"+Condition+"'";
            }
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                TheLoai tl = new TheLoai();
                tl.setMaLoai(resultSet.getString("MaLoai"));
                tl.setTenLoai(resultSet.getString("TenLoai"));
                listTL.add(tl);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listTL;    }



    
}
