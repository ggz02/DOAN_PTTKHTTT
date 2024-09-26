/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class CTPhieuTra {
    private String MaT;
    private String MaM;
    private String MaSach;
    private String MaVP;
    private float Phat;
    
    public CTPhieuTra(){}
    
    public CTPhieuTra(String MaT,String MaM,String MaSach,String MaVP,float Phat) {
        this.MaT= MaT;
        this.MaM =MaM;
        this.MaSach =MaSach;
        this.MaVP = MaVP;
        this.Phat =Phat;
    }
    
    public void setMaT(String MaT) {
        this.MaT = MaT;
    }
    
    public String getMaT() {
        return this.MaT;
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
    
     public void setMaVP(String MaVP) {
        this.MaVP = MaVP;
    }
    
    public String getMaVP() {
        return this.MaVP;
    }
    
     public void setPhat(float Phat) {
        this.Phat = Phat;
    }
    
    public float getPhat() {
        return this.Phat;
    }
    
    
}
