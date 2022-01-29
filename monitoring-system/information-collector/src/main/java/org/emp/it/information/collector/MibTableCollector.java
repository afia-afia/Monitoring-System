/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.information.collector;

import java.util.Map;

/**
 *
 * @author nabil
 */
public class MibTableCollector {
    
    MibTableService mibTableService ; 
    
    
    
    public MibTableCollector(MibTableService s){
        
        this.mibTableService = s ; 
        
    }
    
    public Map<String , String > collectMibtable(String ip){
        
       return this.mibTableService.getMibTable(ip);
       
    }
}
