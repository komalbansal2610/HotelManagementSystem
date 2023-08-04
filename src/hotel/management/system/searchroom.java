/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class searchroom extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    searchroom()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,20);
        add(text);
        
        JLabel lblbed=new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        bedType=new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available=new JCheckBox("Only display available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);
        add(l5);
        
        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            conn con=new conn();
            ResultSet rs=con.stat.executeQuery("Select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(600,520,120,30);
        add(back);
        
        setBounds(500,520,1000,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    public static void main(String[] args)
    {
        new searchroom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==submit)
        {
           try{
               String query1="Select * from room where bed_type='"+bedType.getSelectedItem() +"'";
               String query2="Select * from room where availability='Available' AND bed_type='"+bedType.getSelectedItem()+"'";
               
               conn c=new conn();
               ResultSet rs;
               if(available.isSelected())
               {
                 rs=c.stat.executeQuery(query2);
               }else
               {
                 rs=c.stat.executeQuery(query1);
               }
               table.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception ae)
           {
               ae.printStackTrace();
           }
        }else
        {
            setVisible(false);
            new reception();
        }
           
    }
}