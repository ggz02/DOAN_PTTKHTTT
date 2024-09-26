/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class Sach {
    private String MaSach;
    private String ISBN;
    private int Gia;
    private int NamXB;
    private String GhiChu;
    
    
    public Sach() {
    }
    
    public Sach(String MaSach, String ISBN, int Gia,int NamXB,String GhiChu) {
        this.MaSach = MaSach;
        this.ISBN = ISBN;
        this.Gia = Gia;
        this.NamXB = NamXB;
        this.GhiChu = GhiChu;
    }
    
    public String getMaSach() {
        return this.MaSach;
    }
    
    public void setMaSach(String Ma) {
        this.MaSach =Ma;
    }
    
     public String getISBN() {
        return this.ISBN;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN =ISBN;
    }
    
     public int getGia() {
        return this.Gia;
    }
    
    public void setGia(int Gia) {
        this.Gia =Gia;
    }
    
     public int getNamXB() {
        return this.NamXB;
    }
    
    public void setNamXB(int NamXB) {
        this.NamXB =NamXB;
    }
    
     public String getGhiChu() {
        return this.GhiChu;
    }
    
    public void setGhiChu(String GhiChu) {
        this.GhiChu =GhiChu;
    }
    
    
    
}
