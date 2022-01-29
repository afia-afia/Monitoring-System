/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.service.implementaion;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.UdpAddress;
/**
 *
 * @author nabil
 */
public class AddressConverter {

    /**
     *
     */
    public AddressConverter(){};
    
    
    public static Address getUdpAddressFromString(String ip) throws UnknownHostException{
        
        InetAddress  ipAddress = InetAddress.getByName(ip); 
        Address udpAddress = new UdpAddress​(ipAddress, 161);
        return  udpAddress;
        
    }
    
    
    
}
