/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import database.ConnectionSQL;
import java.sql.Connection;
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
    public class SachTKDAO implements DaoInterface<SachTK>{

    public static SachTKDAO getInstance(){
        return new SachTKDAO();
    }
    
    @Override
    public void insert(SachTK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(SachTK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(SachTK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<SachTK> selectAll() {
         ArrayList<SachTK> listSach = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionSQL.getConnection();
            String querry = "SELECT ds.ISBN,s.MaSach,TenSach,Tacgia,NXB,NamXB,Thongtinsach\n" +
                "from Sach s join Dausach ds on s.ISBN = ds.ISBN \n" +
                "where MaSach not in (\n" +
                "	select MaSach\n" +
                "	from CTPhieuMuon ctpm join PhieuMuon pm on ctpm.MaM = pm.MaM\n" +
                "	where DatedIff (day, GETDATE(), pm.Ngayhethan) > 0\n" +
                ")\n" +
                "order by ISBN";
            st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(querry);
            while(resultSet.next()) {
                SachTK sach = new SachTK(resultSet.getString("ISBN"), resultSet.getString("MaSach"), resultSet.getString("TenSach"), resultSet.getString("Tacgia"),resultSet.getString("NXB"),resultSet.getInt("NamXB"),resultSet.getString("Thongtinsach"));
                listSach.add(sach);
            }
            
            ConnectionSQL.closeConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(SachTKDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachTKDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đóng kết nối");
                } catch (SQLException ex) {
                    Logger.getLogger(SachTKDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listSach;
    }

    @Override
    public ArrayList<SachTK> selectByCondition(String Condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
