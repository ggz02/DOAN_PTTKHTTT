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
public class DauSachDAO implements DaoInterface<DauSach>{

    public static DauSachDAO getInstance(){
        return new DauSachDAO();
    }
    
    @Override
    public void insert(DauSach t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into DauSach(ISBN,MaLoai,TenSach,Tacgia,NXB,SoLuong,Thongtinsach)" 
                    + "values(?,?,?,?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getISBN());
            prst.setString(2, t.getMaLoai());
            prst.setString(3,t.getTenSach());
            prst.setString(4, t.getTacGia());
            prst.setString(5,t.getNXB());  
            prst.setString(6,Integer.toString(t.getSoLuong()));
            prst.setString(7,t.getThongTinSach());


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void update(DauSach t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update DauSach" +
                    " set"
                    + " ISBN = ?,"
                    + "MaLoai = ?,"
                    + "TenSach = ?,"
                    + "Tacgia = ?,"
                    + "NXB = ?,"         
                    + "SoLuong = ?,"            
                    + "ThongTinSach = ?"
                    + " where ISBN = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getISBN());
            prst.setString(2, t.getMaLoai());
            prst.setString(3,t.getTenSach());
            prst.setString(4, t.getTacGia());
            prst.setString(5,t.getNXB());  
            prst.setString(6,Integer.toString(t.getSoLuong()));
            prst.setString(7,t.getThongTinSach());      
            prst.setString(8,t.getISBN());



            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(DauSach t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from DauSach" +
                    " where "
                    + " ISBN = ? and "
                    + "MaLoai = ? and "
                    + "TenSach = ? and "
                    + "Tacgia = ? and "
                    + "NXB = ? and "         
                    + "SoLuong = ? and "            
                    + "ThongTinSach = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getISBN());
            prst.setString(2, t.getMaLoai());
            prst.setString(3,t.getTenSach());
            prst.setString(4, t.getTacGia());
            prst.setString(5,t.getNXB());  
            prst.setString(6,Integer.toString(t.getSoLuong()));
            prst.setString(7,t.getThongTinSach());  


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
      }

    @Override
    public ArrayList<DauSach> selectAll() {
        ArrayList<DauSach> listDS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from DauSach";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                DauSach ds = new DauSach(resultSet.getString("ISBN"),resultSet.getString("MaLoai"),resultSet.getString("TenSach"),resultSet.getString("Tacgia"),resultSet.getString("NXB"),resultSet.getInt("SoLuong"),resultSet.getString("ThongtinSach"));
                listDS.add(ds);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listDS;
    }


    @Override
    public ArrayList<DauSach> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<DauSach> listTenSach(){
        ArrayList<DauSach> listDS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
             querry = "select TenSach\n" +
                    "from Dausach\n";
         ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String TenSach = resultSet.getString("TenSach");
                
                DauSach pn = new DauSach(TenSach);
                listDS.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listDS;
    
    
    }
    
    
    public ArrayList<DauSach> selectByConditionPN(String Condition) {
        ArrayList<DauSach> listDS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
             querry = "select TenSach\n" +
                    "from Dausach\n" +
                    "where ISBN = '"+Condition+"'";
         ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String TenSach = resultSet.getString("TenSach");
                
                DauSach pn = new DauSach(TenSach);
                listDS.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listDS;
    
    }
    
    public ArrayList<DauSach> selectByConditionSoPN(String Condition) {
        ArrayList<DauSach> listDS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
             querry = "select ISBN\n" +
                    "from Dausach\n" +
                    "where TenSach = N'"+Condition+"'";
         ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String ISBN = resultSet.getString("ISBN");
                
                DauSach pn = new DauSach();
                pn.setISBN(ISBN);
                listDS.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listDS;
    
    }
    
     public ArrayList<DauSach> selectTenSachNotInPT(String Condition,int index) {
        ArrayList<DauSach> listTenSach = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "";
            if (index == 1){       
                    querry = "select TenSach\n" +
                    "from DocGia dg join PhieuMuon pm on dg.MaDG = pm.MaDG join CTPhieuMuon ctpm on pm.MaM = ctpm.MaM\n" +
                    "join Sach s on s.MaSach = ctpm.MaSach join Dausach ds on ds.ISBN = s.ISBN\n" +
                    "where dg.HoTenDG = N'"+Condition+"' and pm.MaM not in (\n" +
                    "	select MaM\n" +
                    "	from PhieuTra\n" +
                    ")";
            }else if (index == 2) {
                querry ="select TenSach\n" +
"					from CTPhieuMuon ctpm join Sach s on ctpm.MaSach = s.MaSach join Dausach ds on ds.ISBN = s.ISBN\n" +
"					where s.MaSach not in (\n" +
"						select MaSach\n" +
"						from CTPhieuTra\n" +
"					)";
                
            }
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                DauSach ds = new DauSach();
                ds.setTenSach(resultSet.getString("TenSach"));
                listTenSach.add(ds);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listTenSach;
    }
    
}
