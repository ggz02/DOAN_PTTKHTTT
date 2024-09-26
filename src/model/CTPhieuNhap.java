/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class CTPhieuNhap {
    private String SoPN;
    private String ISBN;
    private int NamXB;
    private int SoLuong;
    private int GiaNhap;
    
    public CTPhieuNhap(){}
    
    public CTPhieuNhap(String SoPN,String ISBN,int NamXB,int SL,int GiaNhap){
        this.SoPN = SoPN;
        this.ISBN = ISBN;
        this.NamXB = NamXB;
        this.SoLuong =SL;
        this.GiaNhap = GiaNhap;
    }
    
     public void setSoPN(String SoPN) {
        this.SoPN = SoPN;
    }
    
    public String getSoPN() {
        return this.SoPN;
    }
    
     public void setISBN(String ISBN) {
        this.ISBN =ISBN;
    }
    
    public String getISBN() {
        return this.ISBN;
    }
    
     public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    public int getSoLuong() {
        return this.SoLuong;
    }
    
     public void setGiaNhap(int GiaNhap) {
        this.GiaNhap = GiaNhap;
    }
    
    public int getGiaNhap() {
        return this.GiaNhap;
    }
    
     public void setNamXB(int NamXB) {
        this.NamXB = NamXB;
    }
    
    public int getNamXB() {
        return this.NamXB;
    }
    
}
