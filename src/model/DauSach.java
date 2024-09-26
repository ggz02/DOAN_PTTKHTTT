/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class DauSach {
    private String ISBN;
    private String MaLoai;
    private String TenSach;
    private String TacGia;
    private String NXB;
    private int SoLuong;
    private String ThongTinSach;
    
    public DauSach() {}
    
    public DauSach(String ISBN, String MaLoai, String TenSach,String TacGia, String NXB,int SL, String ThongTin){
        this.ISBN = ISBN;
        this.MaLoai = MaLoai;
        this.TenSach = TenSach;
        this.TacGia= TacGia;
        this.NXB = NXB;
        this.SoLuong = SL;
        this.ThongTinSach = ThongTin;
    }
    
    public DauSach(String ISBN, String TenSach,String TacGia, String NXB, String ThongTin){
        this.ISBN = ISBN;
        this.TenSach = TenSach;
        this.TacGia= TacGia;
        this.NXB = NXB;
        this.ThongTinSach = ThongTin;
    }
    
    public DauSach(String TenSach){
        this.TenSach = TenSach;
    }

    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public String getISBN() {
        return this.ISBN;
    }
    
    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }
    
    public String getMaLoai() {
        return this.MaLoai;
    }
    
    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }
    
    public String getTenSach() {
        return this.TenSach;
    }
    
    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }
    
    public String getTacGia() {
        return this.TacGia;
    }
    
    public void setNXB(String NXB) {
        this.NXB = NXB;
    }
    
    public String getNXB() {
        return this.NXB;
    }
    
    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    public int getSoLuong() {
        return this.SoLuong;
    }
    
    
     public void setThongTinSach(String ThongTinSach) {
        this.ThongTinSach = ThongTinSach;
    }
    
    public String getThongTinSach() {
        return this.ThongTinSach;
    }
}
