/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class CTPhieuMuon {
   private String MaM;
   private String MaSach;
   
   public CTPhieuMuon(){}
   
   public CTPhieuMuon(String MaM,String MaSach){
       this.MaM = MaM;
       this.MaSach = MaSach;
   }
   
    public void setMaM(String MaM) {
        this.MaM = MaM;
    }
    
    public String getMaM() {
        return this.MaM;
    }
    
    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }
    
    public String getMaSach() {
        return this.MaSach;
    }
    
    
}
