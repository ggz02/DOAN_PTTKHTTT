/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class PhieuNhap {
    private String SoPN;
    private String MaNCC;
    private String MaTT;
    private String NgayTao;
    private String NgayNhap;
    
    public PhieuNhap(){}
    
    public PhieuNhap(String SoPN,String MaNCC,String MaTT,String NgayTao,String NgayNhap){
        this.SoPN = SoPN;
        this.MaNCC = MaNCC;
        this.MaTT = MaTT;
        this.NgayTao = NgayTao;
        this.NgayNhap = NgayNhap;
    }
    
    public void setSoPN(String SoPN) {
        this.SoPN = SoPN;
    }
    
    public String getSoPN() {
        return this.SoPN;
    }
    
    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }
    
    public String getMaNCC() {
        return this.MaNCC;
    }
    
    public void setMaTT(String MaTT) {
        this.MaTT = MaTT;
    }
    
    public String getMaTT() {
        return this.MaTT;
    }
    
    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }
    
    public String getNgayTao() {
        return this.NgayTao;
    }
    
    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }
    
    public String getNgayNhap() {
        return this.NgayNhap;
    }
}
