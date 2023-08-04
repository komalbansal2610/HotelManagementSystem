/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author gulshan
 */
public class HotelManagementSystem extends JFrame implements ActionListener{
    
  

    
    HotelManagementSystem()
    {
        setSize(1366,565);
        setLayout(null);

        
        ImageIcon icon=new ImageIcon("C:\\Users\\gulshan\\Documents\\NetBeansProjects\\Hotel Management System\\src\\icons\\first.jpg");
        JLabel image=new JLabel(icon);
        image.setBounds(0,0,1366,565);//locationx,locationy,length,breadth1366,565
        add(image);
        
        JLabel head=new JLabel("HOTEL MANAGEMENT SYSTEM");
        head.setBounds(20,430,1000,90);
        head.setForeground(Color.WHITE);
        head.setFont(new Font("serif",Font.PLAIN,50));
        image.add(head);
        
        JButton next=new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("serif",Font.PLAIN,50));
        next.addActionListener(this);
        image.add(next);
        
        setBounds(0,0,1366,565);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        
        while(true)
        {
            head.setVisible(false);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            head.setVisible(true);
             try{
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
    }
     
    
    public static void main(String[] args) {
        // TODO code application logic here1905
        new HotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
      setVisible(false);
      new Login();
    }
    
}
