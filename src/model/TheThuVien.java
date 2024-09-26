/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class TheThuVien {
    private String MaThe;
    private String MaDG;
    private String NgayTao;
    private String HanThe;
    
    public TheThuVien() {}
    
    public TheThuVien(String MaThe,String MaDG,String NgayTao,String HanThe) {
        this.MaThe = MaThe;
        this.MaDG = MaDG;
        this.NgayTao = NgayTao;
        this.HanThe =HanThe;
    }
    
    public void setMaThe(String MaThe) {
        this.MaThe = MaThe;
    }
    
    public String getMaThe() {
        return this.MaThe;
    }
    
    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }
    
    public String getMaDG() {
        return this.MaDG;
    }
    
    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }
    
    public String getNgayTao() {
        return this.NgayTao;
    }
    
    public void setHanThe(String HanThe) {
        this.HanThe = HanThe;
    }
    
    public String getHanThe() {
        return this.HanThe;
    }
    
    
}
