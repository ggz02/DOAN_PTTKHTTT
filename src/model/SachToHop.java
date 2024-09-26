/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class SachToHop {
    private String ISBN;
    private String TenLoai;
    private String TenSach;
    private String TacGia;
    private String NXB;
    private int Soluong;
    private String ThongTinSach;
    
    public SachToHop(){}
    
    public SachToHop(String ISBN, String TenLoaiString,String TenSachString,String TacGiaString,String NXB,int SLuong,String ThongTin){
        this.ISBN = ISBN;
        TenLoai= TenLoaiString;
        TenSach = TenSachString;
        TacGia = TacGiaString;
        this.NXB = NXB;
        this.Soluong = SLuong;
        this.ThongTinSach = ThongTin;
    }
    
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    
    public String getISBN(){
            return this.ISBN;
    }
    
    public void setNXB(String NXB){
        this.NXB = NXB;
    }
    
    public String getNXB(){
            return this.NXB;
    }
    
    public void setTenLoai(String TenLoai){
        this.TenLoai = TenLoai;
    }
    
    public String getTenLoai(){
            return this.TenLoai;
    }
    
    public void setTenSach(String TenSach){
        this.TenSach = TenSach;
    }
    
    public String getTenSach(){
            return this.TenSach;
    }
    
    public void setTacGia(String TacGia){
        this.TacGia = TacGia;
    }
    
    public String getTacGia(){
            return this.TacGia;
    }
    
    public void setSoluong(int Soluong){
        this.Soluong = Soluong;
    }
    
    public int getSoluong(){
            return this.Soluong;
    }
    
     public void setThongTinSach(String ThongTinSach){
        this.ThongTinSach = ThongTinSach;
    }
    
    public String getThongTinSach(){
            return this.ThongTinSach;
    }
}
