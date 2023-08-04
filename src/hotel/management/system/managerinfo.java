/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class managerinfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    managerinfo()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(40,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(170,10,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(290,10,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Job");
        l4.setBounds(400,10,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Salary");
        l5.setBounds(540,10,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Phone");
        l6.setBounds(670,10,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Email");
        l7.setBounds(790,10,100,20);
        add(l7);
        
        JLabel l8=new JLabel("Aadhar No.");
        l8.setBounds(910,10,100,20);
        add(l8);
        
        table=new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        try{
            conn con=new conn();
            ResultSet rs=con.stat.executeQuery("Select * from employee where job='Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    public static void main(String[] args)
    {
        new managerinfo();
    }

//    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         setVisible(false);
         new reception();
    }
}
