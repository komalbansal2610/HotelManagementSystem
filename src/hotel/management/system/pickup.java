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

public class pickup extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    Choice typeofcar; 
    JCheckBox available;
    
    pickup()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,20);
        add(text);
        
        JLabel lblbed=new JLabel("Type of Car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        typeofcar=new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try{
            conn c=new conn();
            ResultSet rs=c.stat.executeQuery("Select * from driver");
            while(rs.next())
            {
                typeofcar.add(rs.getString("brand"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(70,160,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(200,160,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(330,160,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Company");
        l4.setBounds(460,160,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Brand");
        l5.setBounds(630,160,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Availability");
        l6.setBounds(740,160,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Location");
        l7.setBounds(890,160,100,20);
        add(l7);
        
        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            conn con=new conn();
            ResultSet rs=con.stat.executeQuery("Select * from driver");
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
        new pickup();
    }

//    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==submit)
        {
           try{
               String query="Select * from driver where brand='"+typeofcar.getSelectedItem() +"'";
               
               conn c=new conn();
               ResultSet rs;
               rs=c.stat.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
           }
            catch(Exception ae)
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
