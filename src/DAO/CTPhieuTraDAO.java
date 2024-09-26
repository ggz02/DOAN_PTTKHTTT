/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import com.sun.javafx.font.FontConstants;
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
public class CTPhieuTraDAO implements DaoInterface<CTPhieuTra> {

    public static CTPhieuTraDAO getInstance(){
        return new CTPhieuTraDAO();
    }
    
    @Override
    public void insert(CTPhieuTra t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into CTPhieuTra(MaT,MaM,MaSach,MaVP,Phat)" 
                    + "values(?,?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaT());
            prst.setString(2, t.getMaM());
            prst.setString(3,t.getMaSach());
            prst.setString(4, t.getMaVP());
            prst.setString(5,Float.toString(t.getPhat()));  
 


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            }

    @Override
    public void update(CTPhieuTra t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update CTPhieuTra" +
                    " set"
                    + " MaT = ?,"
                    + "MaM = ?,"
                    + "MaSach = ?,"
                    + "MaVP = ?,"
                    + "Phat = ? "         
                    + " where MaT = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaT());
            prst.setString(2, t.getMaM());
            prst.setString(3,t.getMaSach());
            prst.setString(4, t.getMaVP());
            prst.setString(5,Float.toString(t.getPhat()));  
            prst.setString(6,t.getMaT());




            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(CTPhieuTra t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from CTPhieuTra" +
                    " where "
                    + " MaT = ? and "
                    + "MaM = ? and "
                    + "MaSach = ? and "
                    + "MaVP = ? and "
                    + "Phat = ? " ;
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaT());
            prst.setString(2, t.getMaM());
            prst.setString(3,t.getMaSach());
            prst.setString(4, t.getMaVP());
            prst.setString(5,Float.toString(t.getPhat()));  


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
      }

    @Override
    public ArrayList<CTPhieuTra> selectAll() {
        ArrayList<CTPhieuTra> listCTPT = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from CTPhieuTra";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                CTPhieuTra ctpt = new CTPhieuTra(resultSet.getString("MaT"),resultSet.getString("MaM"),resultSet.getString("MaSach"),resultSet.getString("MaVP"),resultSet.getFloat("Phat"));
                listCTPT.add(ctpt);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listCTPT;
    }


    @Override
    public ArrayList<CTPhieuTra> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public ArrayList<CTPhieuTra> selectMaSachNotInPT(String Condition,String Condition2,int index) {
        ArrayList<CTPhieuTra> listMaSach = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "";
             if (index == 1) {       
                    querry = "select s.MaSach\n" +
                        "from DocGia dg join PhieuMuon pm on dg.MaDG = pm.MaDG join CTPhieuMuon ctpm on pm.MaM = ctpm.MaM\n" +
                        "join Sach s on s.MaSach = ctpm.MaSach join Dausach ds on ds.ISBN = s.ISBN\n" +
                        "where dg.HoTenDG = N'"+Condition+"' and TenSach =N'"+Condition2+"' and pm.MaM not in (\n" +
                        "	select MaM\n" +
                        "	from PhieuTra\n" +
                        ")";
             }
             else if (index == 2) {
                 querry = "select s.MaSach\n" +
                        "from DocGia dg join PhieuMuon pm on dg.MaDG = pm.MaDG join CTPhieuMuon ctpm on pm.MaM = ctpm.MaM\n" +
                        "join Sach s on s.MaSach = ctpm.MaSach join Dausach ds on ds.ISBN = s.ISBN\n" +
                        "where dg.HoTenDG = N'"+Condition+"' and TenSach =N'"+Condition2+"'";
             }
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                CTPhieuTra pt = new CTPhieuTra();
                pt.setMaSach(resultSet.getString("MaSach"));
                listMaSach.add(pt);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(CTPhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listMaSach;
    }
}
