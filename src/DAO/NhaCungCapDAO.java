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
public class NhaCungCapDAO implements DaoInterface<NhaCungCap>{

    public static NhaCungCapDAO getInstance(){
        return new NhaCungCapDAO();
    }
    
    @Override
    public void insert(NhaCungCap t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into NhaCungCap(MaNCC,TenNCC,Diachi,Dienthoai,Website)" 
                    + "values(?,?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaNCC());
            prst.setString(2, t.getTenNCC());
            prst.setString(3,t.getDiaChi());
            prst.setString(4, t.getDienThoai());
            prst.setString(5,t.getWebsite());  


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    @Override
    public void update(NhaCungCap t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update NhaCungCap" +
                    " set"
                    + " MaNCC = ?,"
                    + "TenNCC = ?,"
                    + "Diachi = ?,"
                    + "Dienthoai = ?,"
                    + "Website = ?"         
                    + " where MaNCC = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaNCC());
            prst.setString(2, t.getTenNCC());
            prst.setString(3,t.getDiaChi());
            prst.setString(4, t.getDienThoai());
            prst.setString(5,t.getWebsite());  
            prst.setString(6,t.getMaNCC());




            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    }

    @Override
    public void delete(NhaCungCap t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from NhaCungCap" +
                    " where "
                    + " MaNCC = ? and "
                    + "TenNCC = ? and "
                    + "Diachi = ? and "
                    + "Dienthoai = ? and "
                    + "Website = ?" ;
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaNCC());
            prst.setString(2, t.getTenNCC());
            prst.setString(3,t.getDiaChi());
            prst.setString(4, t.getDienThoai());
            prst.setString(5,t.getWebsite());  


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            }

    @Override
    public ArrayList<NhaCungCap> selectAll() {
        ArrayList<NhaCungCap> listNCC = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from NhaCungCap";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                NhaCungCap ncc = new NhaCungCap(resultSet.getString("MaNCC"),resultSet.getString("TenNCC"),resultSet.getString("Diachi"),resultSet.getString("Dienthoai"),resultSet.getString("Website"));
                listNCC.add(ncc);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listNCC;
    }
    
    
    public ArrayList<NhaCungCap> selectNewMaNCC(){
        ArrayList<NhaCungCap> listMaNCC = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select top 1 * from NhaCungCap order by MaNCC desc";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                NhaCungCap ncc = new NhaCungCap(resultSet.getString("MaNCC"),resultSet.getString("TenNCC"),resultSet.getString("Diachi"),resultSet.getString("Dienthoai"),resultSet.getString("Website"));
                listMaNCC.add(ncc);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listMaNCC;
    }


    @Override
    public ArrayList<NhaCungCap> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
