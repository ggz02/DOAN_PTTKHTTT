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
public class PhieuTraDAO implements DaoInterface<PhieuTra> {

    public static PhieuTraDAO getInstance(){
        return new PhieuTraDAO();
    }
    
    @Override
    public void insert(PhieuTra t) {
         Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into PhieuTra(MaT,MaM,Ngaytra,SoLuongM,SoLuongT)" 
                    + "values(?,?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaT());
            prst.setString(2, t.getMaM());
            prst.setString(3,t.getNgayTra());
            prst.setString(4, String.valueOf(t.getSoLuongM()));
            prst.setString(5, String.valueOf(t.getSoLuongT()));
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
       
    }

    @Override
    public void update(PhieuTra t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update PhieuTra" +
                    " set"
                    + " MaT = ?,"
                    + "MaM = ?,"
                    + "Ngaytra = ?,"
                    + "SoLuongM = ?,"
                    + "SoLuongT = ?"
                    + " where MaT = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaT());
            prst.setString(2, t.getMaM());
            prst.setString(3,t.getNgayTra());
            prst.setString(4,String.valueOf(t.getSoLuongM()));
            prst.setString(5, String.valueOf(t.getSoLuongT()));
            prst.setString(6,t.getMaT());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công " + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(PhieuTra t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from PhieuTra" +
                    " where "
                    + " MaT = ? and "
                    + "MaM = ? and "
                    + "Ngaytra = ? and "
                    + "SoLuongM = ? and "
                    + "SoLuongT = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaT());
            prst.setString(2, t.getMaM());
            prst.setString(3,t.getNgayTra());
            prst.setString(4,String.valueOf(t.getSoLuongM()));
            prst.setString(5, String.valueOf(t.getSoLuongT()));
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công " + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    public ArrayList<PhieuTra> selectAll() {
        ArrayList<PhieuTra> listPT = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from PhieuTra";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                PhieuTra pt = new PhieuTra(resultSet.getString("MaT"), resultSet.getString("MaM"),resultSet.getString("Ngaytra") ,resultSet.getInt("SoLuongM"), resultSet.getInt("SoLuongT"));
                listPT.add(pt);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPT;
    }
    
    
    public ArrayList<PhieuTra> selectMaT() {
         ArrayList<PhieuTra> listMT = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
             querry = "select top 1 MaT\n" +
                    "from PhieuTra\n" +
                    "order by MaT desc";

            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String MaT = resultSet.getString("MaT");
                PhieuTra pt = new PhieuTra();
                pt.setMaT(MaT);
                listMT.add(pt);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listMT;
    } 



    @Override
    public ArrayList<PhieuTra> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        public ArrayList<PhieuTra> selectByCondition(String Condition,int index, String Condition2) {
        ArrayList<PhieuTra> listPT = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
            if(index == 1) {
             querry = "select * from PhieuTra \n" +
            "       where Ngaytra = '"+ Condition +"'";
            }
            if(index == 2) {
              querry = "select * from PhieuTra \n" +
            "where Month(Ngaytra) = '"+ Condition +"' and Year(Ngaytra) = year(getdate())";
            }

            if (index == 3) {
                querry = "select * from PhieuTra \n" +
            "		where Year(Ngaytra) = year(getdate())";    
            }

            if (index == 4) {
                querry = "select * from PhieuTra \n" +
            "		where Year(Ngaytra) = year(getdate()) -1";    
            }

            if(index == 5) {
                    querry = "select * from PhieuTra \n" +
            "		where MaT = '"+Condition+"'";  
            }
            if (index == 6) {
                querry = "select * from PhieuTra \n" +
                        "where MaM = '"+Condition+"'"; 
            }
            if (index == 7) {
                  querry = "select * from PhieuTra \n" +
                  "where MaM = '"+Condition+"' and MaT = '"+Condition2+"'"; 
            }

            
 

            
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String MaT = resultSet.getString("MaT");
                String MaM = resultSet.getString("MaM");
                String Ngaytra = resultSet.getString("Ngaytra");
                int SoLuongM = resultSet.getInt("SoLuongM");
                int SoLuongT = resultSet.getInt("SoLuongT");
                
                PhieuTra pt = new PhieuTra(MaT,MaM,Ngaytra,SoLuongM,SoLuongT);
                listPT.add(pt);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listPT;
    }
    
}
