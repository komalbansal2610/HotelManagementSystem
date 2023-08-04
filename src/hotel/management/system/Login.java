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
//import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    
     Login()
     {
         getContentPane().setBackground(Color.BLACK);
         setLayout(null);
         
         JLabel user=new JLabel("Username");
         user.setBounds(40,20,100,30);
         user.setForeground(Color.WHITE);
         add(user);
         
         username=new JTextField();
         username.setBounds(160,20,150,30);
         add(username);
             
         JLabel pass=new JLabel("Password");
         pass.setBounds(40,70,100,30);
         pass.setForeground(Color.WHITE);
         add(pass);
         
         password=new JPasswordField();
         password.setBounds(160,70,150,30);
         add(password);
         
         login=new JButton("Login");
         login.setBounds(40,150,120,30);
         login.setBackground(Color.BLACK);
         login.setForeground(Color.WHITE);
         login.addActionListener(this);
         add(login);
         
         
         cancel=new JButton("Cancel");
         cancel.setBounds(180,150,120,30);
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
         cancel.addActionListener(this);
         add(cancel);
         
         ImageIcon i1=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\second.jpg");
         Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(350,10,200,200);
         add(image);
         
         
         setBounds(500,200,600,300);
         setVisible(true);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
         setResizable(false);
     }
     
     public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==login)
        {
            String user=username.getText();
            String pass=password.getText();
            
            try
            {
                conn c=new conn();
                String query="select * from login where username= '"+user+"'and password='"+pass+"'";
                ResultSet rs=c.stat.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Dashboard();
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid username and password");
                    setVisible(false);
                }   
                 
                
                
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==cancel)
        {
            setVisible(false);
        }
    }
    
         
}
