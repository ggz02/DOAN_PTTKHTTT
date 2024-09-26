/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class PhieuNhapToHop {
    private String SoPN;
    private String TenNCC;
    private String NgayTao;
    private String NgayNhap;
    private long TongThanhTien;
    
    
    public PhieuNhapToHop(){}
    
    public PhieuNhapToHop(String SoPN,String TenNCC,String NgayTao,String NgayNhap,long TongThanhTien){
        this.SoPN = SoPN;
        this.TenNCC = TenNCC;
        this.NgayTao = NgayTao;
        this.NgayNhap = NgayNhap;
        this.TongThanhTien = TongThanhTien;
    }
    
    public void setSoPN(String SoPN) {
        this.SoPN = SoPN;
    }
    
    public String getSoPN(){
        return this.SoPN;
    }
    
    
    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }
    
    public String getTenNCC(){
        return this.TenNCC;
    }
    
    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }
    
    public String getNgayTao(){
        return this.NgayTao;
    }
    
    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }
    
    public String getNgayNhap(){
        return this.NgayNhap;
    }
    
    public void setTongThanhTien(long TongThanhTien) {
        this.TongThanhTien = TongThanhTien;
    }
    
    public long getTongThanhTien(){
        return this.TongThanhTien;
    }

    
}
