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
public class DocGiaDAO implements DaoInterface<DocGia>{
    
    public static DocGiaDAO getInstance() {
        return new DocGiaDAO();
    }
    
    @Override
    public void insert(DocGia t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "insert into DocGia(MaDG,HoTenDG,NgaySinhDG,GioiTinhDG,DthoaiDG,DiachiDG,DoiTuong)" 
                    + "values(?,?,?,?,?,?,?)";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaDG());
            prst.setString(2, t.getHoTenDG());
            prst.setString(3,t.getNgaySinhDG());
            prst.setString(4, t.getGioiTinhDG());
            prst.setString(5,t.getDienThoaiDG());  
            prst.setString(6,t.getDiaChiDG());
            prst.setString(7,t.getDoiTuong());


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Thêm thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
       
    }

    @Override
    public void update(DocGia t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "update DocGia" +
                    " set"
                    + " MaDG = ?,"
                    + "HoTenDG = ?,"
                    + "NgaySinhDG = ?,"
                    + "GioiTinhDG = ?,"
                    + "DthoaiDG = ?,"         
                    + "DiachiDG = ?,"            
                    + "DoiTuong = ?"
                    + " where MaDG = ?";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaDG());
            prst.setString(2, t.getHoTenDG());
            prst.setString(3,t.getNgaySinhDG());
            prst.setString(4, t.getGioiTinhDG());
            prst.setString(5,t.getDienThoaiDG());  
            prst.setString(6,t.getDiaChiDG());
            prst.setString(7,t.getDoiTuong());      
            prst.setString(8,t.getMaDG());



            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Sửa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(DocGia t) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "delete from DocGia" +
                    " where "
                    + " MaDG = ? and "
                    + "HoTenDG = ? and "
                    + "NgaySinhDG = ? and "
                    + "GioiTinhDG = ? and "
                    + "DthoaiDG = ? and "
                    + "DiachiDG = ? and "
                    + "DoiTuong = ? ";
            prst = conn.prepareCall(querry);
            prst.setString(1,t.getMaDG());
            prst.setString(2, t.getHoTenDG());
            prst.setString(3,t.getNgaySinhDG());
            prst.setString(4, t.getGioiTinhDG());
            prst.setString(5,t.getDienThoaiDG());  
            prst.setString(6,t.getDiaChiDG());
            prst.setString(7,t.getDoiTuong());


            
            int rs = prst.executeUpdate();
            if (rs > 0) {
                System.out.println("Xóa thành công" + rs);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(prst != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
       
    }

    @Override
    public ArrayList<DocGia> selectAll() {
        ArrayList<DocGia> listDG = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from DocGia";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                DocGia DG = new DocGia(resultSet.getString("MaDG"),resultSet.getString("HoTenDG"),resultSet.getString("NgaySinhDG"),resultSet.getString("GioiTinhDG"),resultSet.getString("DthoaiDG"),resultSet.getString("DiachiDG"),resultSet.getString("DoiTuong"));
                listDG.add(DG);
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
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listDG;
    }
    
    public ArrayList<DocGia> selectAllForTK() {
        ArrayList<DocGia> listDG = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select *\n" +
                    "from DocGia\n" +
                    "where MaDG in (\n" +
                    "	select pm.MaDG\n" +
                    "	from CTPhieuMuon ctpm join PhieuMuon pm on ctpm.MaM = pm.MaM\n" +
                    "	where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0\n" +
                    ")";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                DocGia DG = new DocGia(resultSet.getString("MaDG"),resultSet.getString("HoTenDG"),resultSet.getString("NgaySinhDG"),resultSet.getString("GioiTinhDG"),resultSet.getString("DthoaiDG"),resultSet.getString("DiachiDG"),resultSet.getString("DoiTuong"));
                listDG.add(DG);
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
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listDG;
    }
    
    public ArrayList<DocGia> selectByCondition(String Condition, int index) {
        ArrayList<DocGia> listDG = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "";
            if(index == 1){
                    querry = "select distinct dg.MaDG,dg.HoTenDG,dg.NgaySinhDG,dg.GioiTinhDG,dg.DthoaiDG,dg.DiachiDG,dg.DoiTuong\n" +
                        "from DocGia dg join PhieuMuon pm on dg.MaDG = pm.MaDG join CTPhieuMuon ctpm on ctpm.MaM = pm.MaM \n" +
                        "	where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0 and MONTH(Ngaymuon)= MONTH(GETDATE())";
            }
            if (index == 2){
                    querry = "select distinct dg.MaDG,dg.HoTenDG,dg.NgaySinhDG,dg.GioiTinhDG,dg.DthoaiDG,dg.DiachiDG,dg.DoiTuong\n" +
                        "from DocGia dg join PhieuMuon pm on dg.MaDG = pm.MaDG join CTPhieuMuon ctpm on ctpm.MaM = pm.MaM \n" +
                        "	where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0 and Year(Ngaymuon)= Year(GETDATE())";
            }
            if(index == 3){
                       querry = "select distinct dg.MaDG,dg.HoTenDG,dg.NgaySinhDG,dg.GioiTinhDG,dg.DthoaiDG,dg.DiachiDG,dg.DoiTuong\n" +
                        "from DocGia dg join PhieuMuon pm on dg.MaDG = pm.MaDG join CTPhieuMuon ctpm on ctpm.MaM = pm.MaM \n" +
                        "	where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0 and Year(Ngaymuon)= Year(GETDATE()) -1 ";
            }
            if(index == 4){
                                      querry = "select distinct dg.MaDG,dg.HoTenDG,dg.NgaySinhDG,dg.GioiTinhDG,dg.DthoaiDG,dg.DiachiDG,dg.DoiTuong\n" +
                            "from DocGia dg join PhieuMuon pm on dg.MaDG = pm.MaDG join CTPhieuMuon ctpm on ctpm.MaM = pm.MaM \n" +
                            "	where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0 and ('"+Condition+"' between NgayMuon and Ngayhethan)";
            }
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                DocGia DG = new DocGia(resultSet.getString("MaDG"),resultSet.getString("HoTenDG"),resultSet.getString("NgaySinhDG"),resultSet.getString("GioiTinhDG"),resultSet.getString("DthoaiDG"),resultSet.getString("DiachiDG"),resultSet.getString("DoiTuong"));
                listDG.add(DG);
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
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listDG;
    }
    
    
    public ArrayList<DocGia> selectNewDG() {
        ArrayList<DocGia> listNewDG = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select * from DocGia where MaDG not in ("
                    + "select MaDG from TheThuVien)";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                DocGia DG = new DocGia(resultSet.getString("MaDG"),resultSet.getString("HoTenDG"),resultSet.getString("NgaySinhDG"),resultSet.getString("GioiTinhDG"),resultSet.getString("DthoaiDG"),resultSet.getString("DiachiDG"),resultSet.getString("DoiTuong"));
                listNewDG.add(DG);
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
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listNewDG;
    }

    
    public ArrayList<DocGia> selectedById(String msDG) {
        ArrayList<DocGia> docGias = new ArrayList<DocGia>();
        try {
        Connection conn = ConnectionSQL.getConnection();
        
        Statement st = conn.createStatement();
        
        String sql = "Select * from DocGia where MaDG = '"+ msDG+"'";
        ResultSet resultSet = st.executeQuery(sql);
            
            while (resultSet.next()) {                
                DocGia DG = new DocGia(resultSet.getString("MaDG"),resultSet.getString("HoTenDG"),resultSet.getString("NgaySinhDG"),resultSet.getString("GioiTinhDG"),resultSet.getString("DthoaiDG"),resultSet.getString("DiachiDG"),resultSet.getString("DoiTuong"));
                docGias.add(DG);
            }
            
            ConnectionSQL.closeConnection(conn);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docGias;
    
    }
    
    public ArrayList<DocGia> selectNewMaDG(){
        ArrayList<DocGia> listDG = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "select top 1 * from DocGia order by MaDG desc";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                DocGia DG = new DocGia(resultSet.getString("MaDG"),resultSet.getString("HoTenDG"),resultSet.getString("NgaySinhDG"),resultSet.getString("GioiTinhDG"),resultSet.getString("DthoaiDG"),resultSet.getString("DiachiDG"),resultSet.getString("DoiTuong"));
                listDG.add(DG);
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
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listDG;
    }



    @Override
    public ArrayList<DocGia> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
