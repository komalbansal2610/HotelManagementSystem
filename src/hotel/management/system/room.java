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

public class room extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    room()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\eight.jpg");
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(120,10,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(330,10,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(410,10,100,20);
        add(l5);
        
        table=new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try{
            conn con=new conn();
            ResultSet rs=con.stat.executeQuery("Select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
        
        setBounds(300,200,1050,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    public static void main(String[] args)
    {
        new room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         setVisible(false);
         new reception();
    }
}
