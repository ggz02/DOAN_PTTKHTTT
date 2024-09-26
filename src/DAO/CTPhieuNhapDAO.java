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
public class CTPhieuNhapDAO implements DaoInterface<CTPhieuNhap> {

    public static CTPhieuNhapDAO getInstance(){
        return new CTPhieuNhapDAO();
    }
    
    @Override
    public void insert(CTPhieuNhap t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into CTPhieuNhap(SoPN,ISBN,NamXB,Soluong,Gianhap)" 
                    + "values(?,?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getSoPN());
            prst.setString(2, t.getISBN());
            prst.setString(3,Integer.toString(t.getNamXB()));
            prst.setString(4,Integer.toString(t.getSoLuong()));
            prst.setString(5, Integer.toString(t.getGiaNhap()));



            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
     }

    @Override
    public void update(CTPhieuNhap t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update CTPhieuNhap" +
                    " set"
                    + " SoPN = ?,"
                    + "ISBN = ?,"
                    + "Soluong = ?,"
                    + "GiaNhap = ? "
                    + " where SoPN = ? and ISBN = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getSoPN());
            prst.setString(2, t.getISBN());
            prst.setString(3,Integer.toString(t.getSoLuong()));
            prst.setString(4, Integer.toString(t.getGiaNhap()));
            prst.setString(5,t.getSoPN());
            prst.setString(6, t.getISBN());



            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(CTPhieuNhap t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from CTPhieuNhap" +
                    " where "
                    + " SoPN = ? and "
                    + "ISBN = ? and "
                    + "Soluong = ? and "
                    + "GiaNhap = ? ";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getSoPN());
            prst.setString(2, t.getISBN());
            prst.setString(3,Integer.toString(t.getSoLuong()));
            prst.setString(4, Integer.toString(t.getGiaNhap()));


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    @Override
    public ArrayList<CTPhieuNhap> selectAll() {
        ArrayList<CTPhieuNhap> listCTPN = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from CTPhieuNhap";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                CTPhieuNhap ctpn = new CTPhieuNhap(resultSet.getString("SoPN"),resultSet.getString("ISBN"),resultSet.getInt("NamXB"),resultSet.getInt("Soluong"),resultSet.getInt("Gianhap"));
                listCTPN.add(ctpn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listCTPN;
    }


    @Override
    public ArrayList<CTPhieuNhap> selectByCondition(String Condition) {
         ArrayList<CTPhieuNhap> listPN = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
             querry = "select SoPN,ISBN,NamXB,Soluong,Gianhap\n" +
            "           FROM CTPhieuNhap\n" +
            "           Where SoPN = '"+ Condition +"'";

            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String soPN = resultSet.getString("SoPN");
                String ISBN = resultSet.getString("ISBN");
                int NamXB = resultSet.getInt("NamXB");
                int SoLuong = resultSet.getInt("Soluong");
                int Gianhap = resultSet.getInt("Gianhap");
                
                CTPhieuNhap pn = new CTPhieuNhap(soPN,ISBN,NamXB,SoLuong,Gianhap);
                listPN.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPN;
    }
    
    
    
}
