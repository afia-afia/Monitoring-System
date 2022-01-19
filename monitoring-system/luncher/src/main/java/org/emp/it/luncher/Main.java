/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.luncher;

import org.emp.it.gui.MyFrame;
import org.emp.it.information.collector.TimerInformationCollector;
import org.emp.it.information.collector.TimerService;
import org.emp.it.service.implementaion.TimerServiceImplementaion;

/**
 *
 * @author nabil
 */
public class Main {
    public static void main(String[]args){
        TimerService timerService = new TimerServiceImplementaion();
        TimerInformationCollector collector =  new TimerInformationCollector(timerService);
        new MyFrame(collector);
        
        
    }
    
}
