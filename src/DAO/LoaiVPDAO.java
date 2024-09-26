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
public class LoaiVPDAO implements DaoInterface<LoaiVP>{

    public static LoaiVPDAO getInstance(){
        return new LoaiVPDAO();
    }
    
    @Override
    public void insert(LoaiVP t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into LoaiVP(MaVP,TenLoaiVP,CachXuLy)" 
                    + "values(?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaVP());
            prst.setString(2, t.getTenLoaiVP());
            prst.setString(3,t.getCachXuLy());


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
       
    }

    @Override
    public void update(LoaiVP t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update LoaiVP" +
                    " set"
                    + " MaVP = ?,"
                    + "TenLoaiVP = ?,"
                    + "CachXuLy = ?"
                    + " where MaVP = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaVP());
            prst.setString(2, t.getTenLoaiVP());
            prst.setString(3,t.getCachXuLy());
            prst.setString(4,t.getMaVP());




            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(LoaiVP t) {
Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from LoaiVP" +
                    " where "
                    + " MaVP = ? and "
                    + "TenLoaiVP = ? and "
                    + "CachXuLy = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaVP());
            prst.setString(2, t.getTenLoaiVP());
            prst.setString(3,t.getCachXuLy());



            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
     }

    @Override
    public ArrayList<LoaiVP> selectAll() {
        ArrayList<LoaiVP> listVP = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from LoaiVP";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                LoaiVP vp = new LoaiVP(resultSet.getString("MaVP"),resultSet.getString("TenLoaiVP"),resultSet.getString("CachXuLy"));
                listVP.add(vp);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listVP;
    }


    @Override
    public ArrayList<LoaiVP> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public ArrayList<LoaiVP> selectTenViPham() {
        ArrayList<LoaiVP> listVP = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select TenLoaiVP\n" +
                        "from LoaiVP";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                LoaiVP vp = new LoaiVP();
                vp.setTenLoaiVP(resultSet.getString("TenLoaiVP"));
                listVP.add(vp);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiVPDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listVP;
    }
    
}
