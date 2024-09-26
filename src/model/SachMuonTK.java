/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class SachMuonTK {
    private String MaM;
    private String ISBN;
    private String MaSach;
    private int NamXB;
    private String NgayHetHan;
    
    public SachMuonTK(){}
    
    public SachMuonTK(String MaM,String ISBN,String MaSach,int NamXB,String NgayHH){
        this.MaM= MaM;
        this.ISBN = ISBN;
        this.MaSach = MaSach;
        this.NamXB = NamXB;
        this.NgayHetHan = NgayHH;
    }
    
    public void setMaM(String MaM){
        this.MaM = MaM;
    }
    
    public String getMaM(){
        return this.MaM;
    }
    
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    
    public String getISBN(){
        return this.ISBN;
    }
    
     public void setMaSach(String MaSach){
        this.MaSach = MaSach;
    }
    
    public String getMaSach(){
        return this.MaSach;
    }
    
     public void setNamXB(int NamXB){
        this.NamXB = NamXB;
    }
    
    public int getNamXB(){
        return this.NamXB;
    }
    
     public void setNgayHetHan(String NgayHetHan){
        this.NgayHetHan = NgayHetHan;
    }
    
    public String getNgayHetHan(){
        return this.NgayHetHan;
    }
}
