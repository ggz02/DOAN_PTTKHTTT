/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class SachTK extends DauSach{
    private String MaSach;
    private int NamXB;
    
    public SachTK(){}
    
    public SachTK(String ISBN,String MaSach, String TenSach,String TacGia, String NXB,int NamXB, String ThongTin){
       super(ISBN, TenSach, TacGia, NXB, ThongTin);
       this.MaSach = MaSach;
       this.NamXB = NamXB;
    }
    
    public void setMaSach(String MaSach){
        this.MaSach = MaSach;
    }
    
    public String getMaSach (){
        return this.MaSach;
    }
    
    
    public void setNamXB(int NamXB){
        this.NamXB = NamXB;
    }
    
    public int getNamXB (){
        return this.NamXB;
    }
}
