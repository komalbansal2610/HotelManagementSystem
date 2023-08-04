
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class updateroom extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfstatus,tfpaid,tfpending;
    JButton check,update,back;
    
    
    updateroom()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
          
        JLabel lblid=new JLabel("Customer id");
        lblid.setBounds(30,80,100,20);
        add(lblid);
        
        ccustomer =new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        try{
            conn c=new conn();
            ResultSet rs=c.stat.executeQuery("Select * from customer");
            while(rs.next())
            {
                ccustomer.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(30,130,100,20);
        add(lblroom);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);
        
        JLabel lblname=new JLabel("Availability");
        lblname.setBounds(30,180,100,20);
        add(lblname);
        
        tfavailable=new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);
        
        JLabel lblcheckin=new JLabel("Cleaning Status");
        lblcheckin.setBounds(30,230,100,20);
        add(lblcheckin);
        
        tfstatus=new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);
        
        check=new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        update=new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\seventh.jpg");
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,450);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(false);   
    }
    
    public static void main(String args[])
    {
        new updateroom();
    }

//    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           if(e.getSource()==check)
           {
               String id=ccustomer.getSelectedItem();
               String query="Select * from customer where number='"+id+"'";
               try{
                   conn c=new conn();
                   ResultSet rs=c.stat.executeQuery(query);
                   while(rs.next())
                   {
                       tfroom.setText(rs.getString("room"));
                       
                   }
                   
                   ResultSet rs2=c.stat.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                   while(rs2.next())
                   {
                       tfavailable.setText(rs2.getString("availability"));
                       tfstatus.setText(rs2.getString("status"));
                   }
               }
               catch(Exception ae)
               {
                   ae.printStackTrace();
               }
           }
           else if(e.getSource()==update)
           {
              String number=ccustomer.getSelectedItem();
              String room=tfroom.getText();
              String available=tfavailable.getText();
              String status=tfstatus.getText();
              try{
                 conn c=new conn();
                 c.stat.executeUpdate("update room set availability='"+available+"',status='"+status+"' where roomnumber='"+room+"'");
            
                 
                 JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                 
                 setVisible(false);
                 new reception();
              }catch(Exception ef)
              {
                  ef.printStackTrace();
              }
           }else
           {
               setVisible(false);
               new reception();
           }
         
    }
}

