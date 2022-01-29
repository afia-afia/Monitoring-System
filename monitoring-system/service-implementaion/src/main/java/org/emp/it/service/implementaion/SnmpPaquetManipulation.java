/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.service.implementaion;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;

/**
 *
 * @author nabil
 * this class all function necessary to manipulate SNMP paquet 
 * 
 */
 public  class SnmpPaquetManipulation {
     //
    public static PDU creatPdu(String oid ){
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(oid))); // sysDescr
        
        pdu.setType(PDU.GET);
        return pdu;
         
    
     }
    
     public static CommunityTarget creatTarget(String community ,IpAddress ipAddress){
         
          CommunityTarget target = new CommunityTarget();
          target.setCommunity(new OctetString(community));
          target.setAddress(ipAddress);
          target.setVersion(SnmpConstants.version2c);
          return target ; 
          
         
     }
    
}
