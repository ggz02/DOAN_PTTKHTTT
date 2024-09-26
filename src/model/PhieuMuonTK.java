/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class PhieuMuonTK extends PhieuMuon {
    private int SoNgayTre;
    
    public PhieuMuonTK(){}
    
    public PhieuMuonTK(String MaM,String MaHV,String MaTT,String NgayM,String NgayHH,int SL,String GhiChu,int SoNgayTre){
        super(MaM, MaHV, MaTT, NgayM, NgayHH, SL, GhiChu);
        this.SoNgayTre= SoNgayTre;
    }
    
    public int getSoNgayTre(){
        return SoNgayTre;
    }
    
    public void setSoNgayTre(int SoNgayTre){
        this.SoNgayTre =SoNgayTre;
    }
}
