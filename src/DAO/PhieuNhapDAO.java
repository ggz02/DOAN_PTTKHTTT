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
public class PhieuNhapDAO implements DaoInterface<PhieuNhap>{

    public static PhieuNhapDAO getInstance(){
        return new PhieuNhapDAO();
    }
    
    @Override
    public void insert(PhieuNhap t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into PhieuNhap(SoPN,MaNCC,MaTT,Ngaytao,Ngaynhap)" 
                    + "values(?,?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getSoPN());
            prst.setString(2, t.getMaNCC());
            prst.setString(3,t.getMaTT());
            prst.setString(4, t.getNgayTao());
            prst.setString(5, t.getNgayNhap());

            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            }

    @Override
    public void update(PhieuNhap t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update PhieuNhap" +
                    " set"
                    + " SoPN = ?,"
                    + "MaNCC = ?,"
                    + "MaTT = ?"
                    + "Ngaytao = ? "
                    + "Ngaynhap = ? "
                    + " where SoPN = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getSoPN());
            prst.setString(2, t.getMaNCC());
            prst.setString(3,t.getMaTT());
            prst.setString(6,t.getSoPN());
            prst.setString(4, t.getNgayTao());
            prst.setString(5, t.getNgayNhap());



            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
    }

    @Override
    public void delete(PhieuNhap t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from PhieuNhap" +
                    " where "
                    + " SoPN = ? and "
                    + "MaNCC = ? and "
                    + "MaTT = ? "
                    + "Ngaytao = ? "
                    + "Ngaynhap = ? ";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getSoPN());
            prst.setString(2, t.getMaNCC());
            prst.setString(3,t.getMaTT());
            prst.setString(4, t.getNgayTao());
            prst.setString(5, t.getNgayNhap());

            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      }

    @Override
    public ArrayList<PhieuNhap> selectAll() {
        ArrayList<PhieuNhap> listPN = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from PhieuNhap";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
            PhieuNhap pn = new PhieuNhap(resultSet.getString("SoPN"),resultSet.getString("MaNCC"),resultSet.getString("MaTT"),resultSet.getString("Ngaytao"),resultSet.getString("Ngaynhap"));                listPN.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPN;
    }
    
    public ArrayList<PhieuNhap> selectPhieuNhap() {
        ArrayList<PhieuNhap> listPN = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum(Soluong * Gianhap) as N'Tổng thành tiền'\n " +
            "from PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n " +
            "join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n " +
            "group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap ";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                PhieuNhap pn = new PhieuNhap(resultSet.getString("SoPN"),resultSet.getString("MaNCC"),resultSet.getString("MaTT"),resultSet.getString("Ngaytao"),resultSet.getString("Ngaynhap"));
                listPN.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPN;
    }


    @Override
    public ArrayList<PhieuNhap> selectByCondition(String Condition) {
         ArrayList<PhieuNhap> listPN = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
             querry = "select SoPN,MaNCC,MaTT,Ngaytao,Ngaynhap\n" +
            "           FROM PhieuNhap\n" +
            "           Where SoPN = '"+ Condition +"'";

            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String soPN = resultSet.getString("SoPN");
                String MaNCC = resultSet.getString("MaNCC");
                String MaTTNCC = resultSet.getString("MaTT");
                String NgayTao = resultSet.getString("Ngaytao");
                String NgayNhap = resultSet.getString("Ngaynhap");
                
                PhieuNhap pn = new PhieuNhap(resultSet.getString("SoPN"),resultSet.getString("MaNCC"),resultSet.getString("MaTT"),resultSet.getString("Ngaytao"),resultSet.getString("Ngaynhap"));
                listPN.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPN;
    }
    
    public ArrayList<PhieuNhap> selectSoPN() {
         ArrayList<PhieuNhap> listPN = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
             querry = "select top 1 SoPN\n" +
                    "from PhieuNhap\n" +
                    "order by SoPN desc";

            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String soPN = resultSet.getString("SoPN");
                PhieuNhap pn = new PhieuNhap();
                pn.setSoPN(soPN);
                listPN.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPN;
    }
    
}
