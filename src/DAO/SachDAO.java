/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.ConnectionSQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DauSach;
import model.Sach;

/**
 *
 * @author minht
 */
public class SachDAO implements DaoInterface<Sach> {

    public static SachDAO getInstance() {
        return new SachDAO();
    }
    
    
    @Override
    public void insert(Sach t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into Sach(MaSach,ISBN,Gia,NamXB,GhiChu)" 
                    + "values(?,?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaSach());
            prst.setString(2, t.getISBN());
            prst.setString(3,String.valueOf(t.getGia()));
            prst.setString(4, String.valueOf(t.getNamXB()));
            prst.setString(5,t.getGhiChu());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
       
    }

    @Override
    public void update(Sach t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update Sach" +
                    " set"
                    + " MaSach = ?,"
                    + "ISBN = ?,"
                    + "Gia = ?,"
                    + "NamXB = ?,"
                    + "GhiChu = ?"
                    + " where MaSach = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaSach());
            prst.setString(2, t.getISBN());
            prst.setString(3,String.valueOf(t.getGia()));
            prst.setString(4, String.valueOf(t.getNamXB()));
            prst.setString(5,t.getGhiChu());
            prst.setString(6, t.getMaSach());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công " + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        
    }

    @Override
    public void delete(Sach t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from Sach" +
                    " where "
                    + " MaSach = ? and "
                    + "ISBN = ? and "
                    + "Gia = ? and "
                    + "NamXB = ? and "
                    + "GhiChu = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaSach());
            prst.setString(2, t.getISBN());
            prst.setString(3,String.valueOf(t.getGia()));
            prst.setString(4, String.valueOf(t.getNamXB()));
            prst.setString(5,t.getGhiChu());
            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công " + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> listSach = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from Sach";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                Sach sach = new Sach(resultSet.getString("MaSach"), resultSet.getString("ISBN"), resultSet.getInt("Gia"), resultSet.getInt("NamXB"),resultSet.getString("GhiChu"));
                listSach.add(sach);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listSach;
    }



 

    
    public ArrayList<Sach> selectByConditionNamXB(String Condition) {
        ArrayList<Sach> listS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
             querry = "select NamXB \n" +
                    "from Sach s join Dausach ds on s.ISBN = ds.ISBN\n" +
                    "where TenSach = N'"+Condition+"'";
         ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                int NamXB = resultSet.getInt("NamXB");
                
                Sach pn = new Sach();
                pn.setNamXB(NamXB);
                listS.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listS;
    
    }
    
    
    public ArrayList<Sach> selectByConditionMaSach(String Condition,String Condition2) {
        ArrayList<Sach> listS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
             querry = "select MaSach\n" +
                    "from Sach s join Dausach ds on s.ISBN = ds.ISBN\n" +
                    "where s.ISBN = '"+Condition +"' and NamXB = '"+Condition2+"'";
         ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                String MaSach = resultSet.getString("MaSach");
                
                Sach s = new Sach();
                s.setMaSach(MaSach);
                listS.add(s);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listS;
    
    }
    
    public ArrayList<Sach> selectByConditionGia(String Condition1, String Condtitionl2,int index) {
        ArrayList<Sach> listS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            st = conn.createStatement();
            String querry ="";
            if (index == 1) {
                 querry = "select Gia \n" +
                    "from Sach\n" +
                    "where NamXB = '"+Condition1+"' and ISBN = '"+Condtitionl2+"'";
            } 
            if (index == 2) {
                querry = "select Gia \n" +
                    "from Sach\n" +
                    "where MaSach = '"+Condition1+"'";
            }
            
         ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                int Gia = resultSet.getInt("Gia");
                
                Sach pn = new Sach();
                pn.setGia(Gia);
                listS.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listS;
    
    }

    @Override
    public ArrayList<Sach> selectByCondition(String Condition) {
         ArrayList<Sach> listS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * \n" +
                    "from Sach  \n" +
"			 where ISBN = '"+Condition+"'";
            
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                Sach pn = new Sach(resultSet.getString("MaSach"),resultSet.getString("ISBN"),resultSet.getInt("Gia"),resultSet.getInt("NamXB"),resultSet.getString("Ghichu"));
                listS.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listS; 
    }
    
    public ArrayList<Sach> selectByCondition(String Condition,String Condition2,int index) {
         ArrayList<Sach> listS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "";
            if (index == 1) {
                    querry = "select * \n" +
                    "from Sach  \n" +
"			 where MaSach = '"+Condition+"'";
            }
            if (index == 2) {
                    querry = "select * \n" +
                    "from Sach  \n" +
"			 where NamXB = '"+Condition+"' and ISBN = '"+Condition2+"' ";
            }
            
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                Sach pn = new Sach(resultSet.getString("MaSach"),resultSet.getString("ISBN"),resultSet.getInt("Gia"),resultSet.getInt("NamXB"),resultSet.getString("Ghichu"));
                listS.add(pn);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listS; 
    }
    
    public ArrayList<Sach> selectNewMaSach(){
        ArrayList<Sach> listS = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select top 1 * from Sach order by MaSach desc";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                Sach s = new Sach(resultSet.getString("MaSach"),resultSet.getString("ISBN"),resultSet.getInt("Gia"),resultSet.getInt("NamXB"),resultSet.getString("Ghichu"));
                listS.add(s);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachToHopDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listS;
    }
    
    }
    
    
    
    
    

