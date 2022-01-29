/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.service.implementaion;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.emp.it.information.collector.DataCollecterService;
import static org.emp.it.service.implementaion.SnmpPaquetManipulation.creatTarget;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author nabil
 */
public class DataCollecterImpl implements DataCollecterService {
    PDU pdu ; 
    CommunityTarget target ; 
    
      public Map<String, String> mapInfo(String ip){
            Map<String, String>  resultInfo=new TreeMap<>();
              org.w3c.dom.Document doc=this.openxml();
              NodeList nList; 
              nList = doc.getElementsByTagName("oids");
             for(int i=0;i<nList.getLength();i++){
                Node nNode=nList.item(i);
                if(nNode.getNodeType()== Node.ELEMENT_NODE)
                {
                  Element eElement =(Element) nNode;
                   if("enable".equals(eElement.getAttribute("idno"))){

                    resultInfo.put(eElement.getElementsByTagName("info").item(0).getTextContent(), getCorespondantDataFromper(eElement.getElementsByTagName("oid").item(0).getTextContent(),ip));
                    } 

                }    
              }
         return resultInfo ;    
     }
                
    
    
    
    
    @Override
    
    public String getCorespondantDataFromper(String OID , String ipAddress ) {
    
        
        
        PDU pdu = SnmpPaquetManipulation.creatPdu(OID);
          
        Address udpAddress;
        try
        {
            udpAddress = AddressConverter.getUdpAddressFromString(ipAddress);
            CommunityTarget target = SnmpPaquetManipulation.creatTarget("public", (IpAddress) udpAddress);
            
        } 
        catch (UnknownHostException ex) 
        {
            Logger.getLogger(DataCollecterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
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
           } 
        catch (IOException ex)
        {
            Logger.getLogger(TimerServiceImplementaion.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResponseEvent response = null;
        try {
            
            response = snmp.send(pdu, target);
            
        } 
        catch (IOException ex) 
        {
            System.err.println("catch");
            Logger.getLogger(TimerServiceImplementaion.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (response.getResponse() == null) {
            
            return "null";

          }
        else {
            System.out.println("Received response from: "+response.getPeerAddress());
    // dump response PDU
            System.out.println(response.getResponse().toString());
             return response.getResponse().toString();
            }
       
           
           
    }
  
     public static   org.w3c.dom.Document openxml (){
                     try {
                        File xmlDoc =new File("../newXMLDocument.xml");
                        DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuild = dbFact.newDocumentBuilder();
                         org.w3c.dom.Document doc = dBuild.parse(xmlDoc);
                            return  doc;
                      }         
                    catch(Exception e){

                          System.out.println(e.getMessage());
                    }     

                    return null;   
                   }

                
                
               
                
                
        
 }
   
        
        
    
  
    

