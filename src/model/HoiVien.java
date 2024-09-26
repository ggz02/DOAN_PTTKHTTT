/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class HoiVien {
    private String MaHV;
    private String HoTenHV;
    private String NgaySinhHV;
    private String GioiTinhHV;
    private String DienThoaiHV;
    private String DiaChiHV;
    private String DoiTuong;
    
    public HoiVien() {}
    
    public HoiVien(String Ma,String Hoten,String NgaySinh, String GioiTinh,String DT,String DiaChi,String DoiTuong) {
        this.MaHV = Ma;
        this.HoTenHV = Hoten;
        this.NgaySinhHV = NgaySinh;
        this.GioiTinhHV = GioiTinh;
        this.DienThoaiHV = DT;
        this.DiaChiHV = DiaChi;
        this.DoiTuong = DoiTuong;
    } 
    
     public String getMaHV() {
        return this.MaHV;
    }
    
    public void setMaHV(String Ma) {
        this.MaHV =Ma;
    }
    
     public String getHoTenHV() {
        return this.HoTenHV;
    }
    
    public void setHoTenHV(String Hoten) {
        this.HoTenHV =Hoten;
    }
    
     public String getNgaySinhHV() {
        return this.NgaySinhHV;
    }
    
    public void setNgaySinhHV(String NgaySinhHV) {
        this.NgaySinhHV =NgaySinhHV;
    }
    
     public String getGioiTinhHV() {
        return this.GioiTinhHV;
    }
    
    public void setGioiTinhHV(String GioiTinhHV) {
        this.GioiTinhHV =GioiTinhHV;
    }
    
     public String getDienThoaiHV() {
        return this.DienThoaiHV;
    }
    
    public void setDienThoaiHV(String DienThoaiHV) {
        this.DienThoaiHV =DienThoaiHV;
    }
    
     public String getDiaChiHV() {
        return this.DiaChiHV;
    }
    
    public void setDiaChiHV(String DiaChiHV) {
        this.DiaChiHV =DiaChiHV;
    }
    
     public String getDoiTuong() {
        return this.DoiTuong;
    }
    
    public void setDoiTuong(String DoiTuong) {
        this.DoiTuong =DoiTuong;
    }
}
