/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class TheLoai {
    private String MaLoai;
    private String TenLoai;
    
    public TheLoai(){}
    
    public TheLoai(String MaLoai,String TenLoai) {
        this.MaLoai = MaLoai;
        this.TenLoai = TenLoai;
    }
    
    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }
    
    public String getMaLoai() {
        return this.MaLoai;
    }
    
   public void setTenLoai(String TenLoai) {
        this.TenLoai =TenLoai;
    }
    
    public String getTenLoai() {
        return this.TenLoai;
    }
}
