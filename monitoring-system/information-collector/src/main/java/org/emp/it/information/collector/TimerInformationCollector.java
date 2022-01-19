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
   private  String HoststAdress = "";
   private final String OIDTIME="1.3.6.1.4.1.171.12.10"; 
  
    public TimerInformationCollector(TimerService s) {
        this.timerServiceImplementation =s;
    }
    public Date getTimeFromHosts(List hosts){
        
        this.timerServiceImplementation.getTimer(HoststAdress, OIDTIME);
        return null;
       
        
    }
    public void setHostAdress(String ip){
        this.HoststAdress = ip ;
    }
    
}
