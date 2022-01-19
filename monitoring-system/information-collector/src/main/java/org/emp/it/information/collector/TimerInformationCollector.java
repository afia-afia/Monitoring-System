/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.information.collector;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nabil
 */
public class TimerInformationCollector {
   private TimerService timerServiceImplementation ;
   private  String HoststAdress = "192.168.2.3";
   private final String OIDTIME="1.3.6.1.2.1.1.5.0"; 
  
    public TimerInformationCollector(TimerService s) {
        this.timerServiceImplementation =s;
    }
    public String getTimeFromHosts(){
        
        return this.timerServiceImplementation.getTimer(this.HoststAdress, OIDTIME);
        
       
        
    }
    public void setHostAdress(String ip){
        this.HoststAdress = ip ;
    }
    
}
