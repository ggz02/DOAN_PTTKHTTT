/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author minht
 */
public interface DaoInterface<T> {
    
    public void insert(T t);
    
    public void update(T t);
    
    public void delete(T t);
    
    public ArrayList<T> selectAll();
   
    
    public ArrayList<T> selectByCondition(String Condition);
    
}
