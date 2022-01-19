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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graalvm.compiler.nodes.memory.address.AddressNode;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class TimerServiceImplementaion implements  TimerService{
        public enum type {Get}
    public Date getTimer(String ipAddres, String oid) {
        PDU pdu = creatPdu(oid, type.Get);
        IpAddress ipAddress = new IpAddress(ipAddres);
        CommunityTarget target = creatTarget(oid, ipAddress);//TODO sflsdfk
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
        } catch (IOException ex) {
            Logger.getLogger(TimerServiceImplementaion.class.getName()).log(Level.SEVERE, null, ex);
            }
                if (response.getResponse() == null) {
    // request timed out
    
            }
                else {
                     System.out.println("Received response from: "+
                       response.getPeerAddress());
    // dump response PDU
                             System.out.println(response.getResponse().toString());
}
       
        
        return null;
    }
  
    
     public PDU creatPdu(String oid , type type ){
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
