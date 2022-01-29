/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.service.implementaion;

import java.util.Date;
import org.emp.it.information.collector.TimerService;


/**
 *
 * @author nabil
 * this class will interact directly with snmp 
 * 
 */
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graalvm.compiler.nodes.memory.address.AddressNode;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TreeEvent;
import org.snmp4j.util.TreeUtils;

public class TimerServiceImplementaion implements  TimerService{
    
        public enum type {Get}
        @Override
        public String getTimer(String ipAddres, String oid) {
        PDU pdu = creatPdu(oid);
        
        InetAddress ip = null;
            try {
                ip = InetAddress.getByName(ipAddres);
            } catch (UnknownHostException ex) {
                Logger.getLogger(TimerServiceImplementaion.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        Address ipAddress = new UdpAddress​(ip, 161);
        CommunityTarget target = creatTarget("public", (IpAddress) ipAddress);//TODO sflsdfk
        Snmp snmp = null;
        try
        {
            snmp = new Snmp(new DefaultUdpTransportMapping());
        } 
        catch ( IOException ex ) {
            Logger.getLogger(TimerServiceImplementaion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            snmp.listen();
        } catch (IOException ex) {
            Logger.getLogger(TimerServiceImplementaion.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResponseEvent response = null;
        try {
            
            response = snmp.send(pdu, target);
            
        } 
        catch (IOException ex) {
            System.err.println("catch");
            Logger.getLogger(TimerServiceImplementaion.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (response.getResponse() == null) {
            
            System.err.println("ifnull");

          }
        else {
            System.out.println("Received response from: "+response.getPeerAddress());
    // dump response PDU
            System.out.println(response.getResponse().toString());
            }
       
            System.err.println("faaaaaaaaaaaaaaaaaaaa");
            return "its good";
    }
  
    
     public PDU creatPdu(String oid ){
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(oid))); // sysDescr
        
        pdu.setType(PDU.GET);
        return pdu;
         
    
     }
     public CommunityTarget creatTarget(String community ,IpAddress ipAddress){
         
          CommunityTarget target = new CommunityTarget();
          target.setCommunity(new OctetString(community));
          target.setAddress(ipAddress);
          target.setVersion(SnmpConstants.version2c);
          return target ; 
          
         
     }
     
                


    
    
}
