/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.emp.it.information.collector;

import java.util.Map;

/**
 *
 * @author nabil
 */
public interface MibRequesterInterface {
    public Map <String ,String > getMibTable(String ipAdress);
}
