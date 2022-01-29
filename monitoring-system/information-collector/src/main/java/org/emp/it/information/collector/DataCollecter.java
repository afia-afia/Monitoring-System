/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.information.collector;

/**
 *
 * @author nabil
 */
public class DataCollecter {
    
    DataCollecterService dataCollecter ; 

    public DataCollecter(DataCollecterService s) {
        this.dataCollecter = s ; 
    }
    
  public String collectCorrespendantData(String datasOid , String ip ){
      
       return 
  dataCollecter.getCorespondantDataFromper(datasOid ,ip ) ; 
        
    }
    
}
