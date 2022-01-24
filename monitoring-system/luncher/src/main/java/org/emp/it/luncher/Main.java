/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.luncher;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.emp.it.gui.MyFrame;
import org.emp.it.information.collector.TimerInformationCollector;
import org.emp.it.information.collector.TimerService;
import org.emp.it.service.implementaion.TimerServiceImplementaion;
import org.snmp4j.CommunityTarget;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TreeEvent;
import org.snmp4j.util.TreeUtils;

/**
 *
 * @author nabil
 */
public class Main {
    public static void main(String[]args) throws Exception{
        TimerService timerService = new TimerServiceImplementaion();
        TimerInformationCollector collector =  new TimerInformationCollector(timerService);
        String s =        collector.getTimeFromHosts(); 
       
       
        
        
        
        
    }
   

    
}
