/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
    JButton checkout,back;
    
    checkout()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel lblid=new JLabel("Customer id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        ccustomer =new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);
        
//        try{
//            conn c=new conn();
//            ResultSet rs=c.stat.executeQuery("Select * from customer");
//            while(rs.next())
//            {
//                ccustomer.add(rs.getString("number"));
//                lblroomnumber.setText(rs.getString("room"));
//                lblcheckintime.setText(rs.getString("checkintime"));
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        
        ImageIcon i1=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\tick.png");
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);
        
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        lblroomnumber=new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);
        
        JLabel lblcheckin=new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        lblcheckintime=new JLabel();
        lblcheckintime.setBounds(150,180,100,30);
        add(lblcheckintime);
        
        JLabel lblcheckout=new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        lblcheckouttime=new JLabel();
        lblcheckouttime.setBounds(150,230,100,30);
        add(lblcheckouttime);
        
        Date date=new Date();
        lblcheckouttime=new JLabel("" + date);
        lblcheckouttime.setBounds(150,230,150,30);
        add(lblcheckouttime);
        
        checkout=new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,100,30);
        back.addActionListener(this);
        add(back);
        
        try{
            conn c=new conn();
            ResultSet rs=c.stat.executeQuery("Select * from customer");
            while(rs.next())
            {
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i4=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\sixth.png");
        Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(350,50,400,250);
        add(image2);
        
        setBounds(300,200,800,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    public static void main(String[] args) {
        new checkout();
    }

//    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Nosupported yet."); //To change body of generated methods, choose Tools | Templates.

               if(e.getSource()==checkout)
               {
                  String query= "delete * from customer where number='"+ccustomer.getSelectedItem()+"'";
                  String query2="update room set availability'Available' where roomnumber='"+lblroomnumber.getText()+"'";
                  
                  try{
                     conn c=new conn();
                     c.stat.executeUpdate(query);
                     c.stat.executeUpdate(query2);
                     
                     JOptionPane.showMessageDialog(null, "Checkout done");
                     
                     setVisible(false);
                     new reception();
                     
                  }catch(Exception ae)
                  {
                     ae.printStackTrace();
                  }
               }
               else
               {
                   setVisible(false);
                   new reception();
               }
    }
}
