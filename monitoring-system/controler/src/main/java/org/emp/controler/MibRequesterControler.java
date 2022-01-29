/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.controler;

import java.util.Map;
import org.emp.it.information.collector.MibRequesterInterface;
import org.emp.it.information.collector.MibTableCollector;

/**
 *
 * @author nabil
 */
public class MibRequesterControler implements MibRequesterInterface {
    
    private MibTableCollector MibTableCollector ; 
    
    public MibRequesterControler(MibTableCollector c){
        this.MibTableCollector = c;
    }

    /**
     *
     * @param ipAdress
     * @return
     */
    @Override
    
    public Map<String ,String > getMibTable(String ipAdress) {
         
         Map<String,String> mibtable  = this.MibTableCollector.collectMibtable(ipAdress);
      
         
         
         return mibtable ; 
              
    }
    
    
    
}
