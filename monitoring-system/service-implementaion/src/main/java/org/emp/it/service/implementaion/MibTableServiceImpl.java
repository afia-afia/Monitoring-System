/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.service.implementaion;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.emp.it.information.collector.MibTableService;
import org.snmp4j.CommunityTarget;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author nabil
 */
public class MibTableServiceImpl implements MibTableService{
                String tableOid ="";
                
                
                
              
                
                
                
                @Override
                  
                public Map<String, String> getMibTable(String ip) {
                    
                String address = "udp:" + ip + "/161";
                String community = "public";        

                CommunityTarget target = new CommunityTarget();
                target.setAddress(GenericAddress.parse(address));
                target.setCommunity(new OctetString(community));
                target.setRetries(2);
                target.setTimeout(1500);
                target.setVersion(SnmpConstants.version2c);

                Map<String, String> result = new TreeMap<>();
                TransportMapping transport = null;
                    try {
                        transport = new DefaultUdpTransportMapping();
                    } catch (IOException ex) {
                        Logger.getLogger(MibTableServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                Snmp snmp = new Snmp(transport);
                    try {
                        transport.listen();
                    } catch (IOException ex) {
                        Logger.getLogger(MibTableServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }

                TreeUtils treeUtils = new TreeUtils(snmp, new DefaultPDUFactory());
                List<TreeEvent> events = treeUtils.getSubtree(target, new OID(tableOid));
                if (events == null || events.size() == 0) {
                    System.out.println("Error: Unable to read table...");
                    return result;
                }

                for (TreeEvent event : events) {
                    if (event == null) {
                        continue;
                    }
                    if (event.isError()) {
                        System.out.println("Error: table OID [" + tableOid + "] " + event.getErrorMessage());
                        continue;
                    }

                    VariableBinding[] varBindings = event.getVariableBindings();
                    if (varBindings == null || varBindings.length == 0) {
                        continue;
                    }
                    for (VariableBinding varBinding : varBindings) {
                        if (varBinding == null) {
                            continue;
                        }

                        result.put("." + varBinding.getOid().toString(), varBinding.getVariable().toString());
                    }

                }
                    try {
                        snmp.close();
                         } 
                    catch (IOException ex) {
                        Logger.getLogger(MibTableServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                         }

                return result;
            }
            
            
              
    
               
                
                }
  

    


