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
import sun.security.jca.GetInstance;
/**
 *
 * @author minht
 */
public class PhieuNhapToHopDAO implements DaoInterface<PhieuNhapToHop>{

    public static PhieuNhapToHopDAO getInstance(){
        return new PhieuNhapToHopDAO();
    }
    
    public ArrayList<PhieuNhapToHop> selectPhieuNhapToHop() {
        ArrayList<PhieuNhapToHop> listPN = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum(Gianhap) as N'TongThanhTien'\n " +
            "from PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n " +
            "join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n " +
            "group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap ";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                PhieuNhapToHop pn = new PhieuNhapToHop(resultSet.getString("SoPN"),resultSet.getString("TenNCC"),resultSet.getString("Ngaytao"),resultSet.getString("Ngaynhap"),resultSet.getLong("TongThanhTien"));
                listPN.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPN;
    }
    
    @Override
    public void insert(PhieuNhapToHop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(PhieuNhapToHop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(PhieuNhapToHop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PhieuNhapToHop> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<PhieuNhapToHop> selectByCondition(String Condition) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
    

    
    public ArrayList<PhieuNhapToHop> selectByCondition(String Condition,int index) {
        ArrayList<PhieuNhapToHop> listPN = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
            if(index == 1) {
             querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum(Gianhap) as N'TongThanhTien'\n" +
            "           FROM PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n" +
            "            join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n" +
            "            group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap\n" +
            "			having Ngaytao = '"+ Condition +"'";
            }
            if(index == 2) {
                        querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum(Gianhap) as N'TongThanhTien'\n" +
            "           FROM PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n" +
            "            join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n" +
            "            group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap\n" +
            "			having Month(Ngaytao) = '"+ Condition +"' and Year(Ngaytao) = year(getdate())";
            }
            if(index == 3) {
                querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum( Gianhap) as N'TongThanhTien'\n" +
            "           FROM PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n" +
            "            join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n" +
            "            group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap\n" +
            "			having Ngaynhap = '"+ Condition +"'";
            }
            if (index == 4) {
                    querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum( Gianhap) as N'TongThanhTien'\n" +
            "           FROM PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n" +
            "            join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n" +
            "            group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap\n" +
            "		having Month(Ngaynhap) = '"+ Condition +"' and Year(Ngaynhap) = year(getdate())";
            }
            if (index == 5) {
                querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum(Gianhap) as N'TongThanhTien'\n" +
            "           FROM PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n" +
            "            join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n" +
            "            group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap\n" +
            "		having Year(Ngaytao) = year(getdate())";    
            }
            if (index == 6) {
                    querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum(Gianhap) as N'TongThanhTien'\n" +
            "           FROM PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n" +
            "            join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n" +
            "            group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap\n" +
            "		having Year(Ngaynhap) = year(getdate())";  
            }
            if (index == 7) {
                querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum(Gianhap) as N'TongThanhTien'\n" +
            "           FROM PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n" +
            "            join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n" +
            "            group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap\n" +
            "		having Year(Ngaytao) = year(getdate()) -1";    
            }
            if (index == 8) {
                    querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum(Gianhap) as N'TongThanhTien'\n" +
            "           FROM PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n" +
            "            join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n" +
            "            group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap\n" +
            "		having Year(Ngaynhap) = year(getdate()) -1";  
            }
            if(index == 9) {
                    querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum(Gianhap) as N'TongThanhTien'\n" +
            "           FROM PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n" +
            "            join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n" +
            "            group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap\n" +
            "		having pn.SoPn = '"+Condition+"'";  
            }
//            if(index == 10) {
//                    querry = "select pn.SoPN,TenNCC,Ngaytao,Ngaynhap,sum(Gianhap) as N'TongThanhTien'\n" +
//            "           FROM PhieuNhap pn join CTPhieuNhap ctpn on pn.SoPN = ctpn.SoPN\n" +
//            "            join Nhacungcap ncc on pn.MaNCC = ncc.MaNCC\n" +
//            "            group by pn.SoPN,TenNCC,Ngaytao,Ngaynhap\n" +
//            "		having pn.SoPN = '"+Condition+"'";  
//            }
            
 

            
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String soPN = resultSet.getString("SoPN");
                String TenNCC = resultSet.getString("TenNCC");
                String NgayTao = resultSet.getString("Ngaytao");
                String NgayNhap = resultSet.getString("Ngaynhap");
                long TongThanhTien = resultSet.getLong("TongThanhTien");
                
                PhieuNhapToHop pn = new PhieuNhapToHop(resultSet.getString("SoPN"),resultSet.getString("TenNCC"),resultSet.getString("Ngaytao"),resultSet.getString("Ngaynhap"),resultSet.getLong("TongThanhTien"));
                listPN.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhapToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPN;
    }
    

    
}
