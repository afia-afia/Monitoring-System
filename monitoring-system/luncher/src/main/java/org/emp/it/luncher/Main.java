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
       
        Map<String ,String> result = Main.doWalk("1.");
        for(String str : result.keySet())
        {
            System.out.println( str+"    "  + result.get(str));
            
        }
            
        System.out.println("this resulst from main" + result);
      //  new MyFrame(collector);
        
        
        
        
    }
    public static Map<String, String> doWalk(String tableOid) throws IOException {
                String  ip = "192.168.2.3";
                String address = "udp:" + ip + "/161";
                String community = "public";        

                CommunityTarget target = new CommunityTarget();
                target.setAddress(GenericAddress.parse(address));
                target.setCommunity(new OctetString(community));
                target.setRetries(2);
                target.setTimeout(1500);
                target.setVersion(SnmpConstants.version2c);

                Map<String, String> result = new TreeMap<>();
                TransportMapping transport = new DefaultUdpTransportMapping();
                Snmp snmp = new Snmp(transport);
                transport.listen();

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
                snmp.close();

                return result;
            }

    
}
