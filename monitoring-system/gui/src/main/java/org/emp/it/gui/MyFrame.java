/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.gui;

import java.awt.Color;
import javax.swing.JFrame;
import org.emp.it.information.collector.TimerInformationCollector;

/**
 *
 * @author nabil
 */
public class MyFrame extends JFrame{
   private TimerInformationCollector collector ;
   
    public MyFrame(TimerInformationCollector c ){
        this.collector = c; 
        
        this.setTitle("Media Player");
        this.setSize(600, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.add(new MyPanel(collector));
        this.setVisible(true);
        
        
    }
}