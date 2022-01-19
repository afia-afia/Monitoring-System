/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.emp.it.gui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.emp.it.information.collector.TimerInformationCollector;

/**
 *
 * @author nabil
 */
public class MyPanel extends JPanel{
     private TimerInformationCollector collector  ; 
    private  JTextField state ;
   
    private JButton prev = new JButton("get time");
    private JLabel ip = new JLabel("enter an ip address");
    
    public MyPanel(TimerInformationCollector c){
        this.collector = c ; 
       
       
        this.setLayout(new GridBagLayout());
        state = new JTextField(30);
     
         this.addItem(this, ip, 0, 0, 1, 1, GridBagConstraints.CENTER);
        
        this.addItem(this, state, 1, 0, 3, 1, GridBagConstraints.CENTER);
        
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createHorizontalStrut(20));
       
        buttonBox.add(Box.createHorizontalStrut(20));
    
        buttonBox.add(Box.createHorizontalStrut(20));
      
        buttonBox.add(Box.createHorizontalStrut(20));
        buttonBox.add(prev);
        
        this.addItem(this, buttonBox, 0, 1, 2, 1, GridBagConstraints.NORTH);
        
    }
    private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align){
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = align;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
                        }
    
}
