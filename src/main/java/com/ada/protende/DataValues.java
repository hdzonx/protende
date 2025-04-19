/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.protende;

/**
 *
 * @author olgierd
 */
public class DataValues {

    public DataValues(double fck) {
                if (fck==0.0) {
            throw new RuntimeException("O fck não pode ser zero");
        }     
    }
    
    
    
}
