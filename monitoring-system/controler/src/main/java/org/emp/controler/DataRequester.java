/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.controler;

import org.emp.it.information.collector.DataCollecter;

/**
 *
 * @author nabil
 */
public class DataRequester {
    DataCollecter dataCollecter ; 
    public DataRequester(DataCollecter c){
        this.dataCollecter = c;
    }
    public String requestDatafrompeer(String oid , String ip){
        return dataCollecter.collectCorrespendantData(oid, ip);
    }
}
