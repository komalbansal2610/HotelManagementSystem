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

public class department extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    department()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("Department");
        l1.setBounds(100,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Budget");
        l2.setBounds(420,10,100,20);
        add(l2);
        
        table=new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        
        try{
            conn con=new conn();
            ResultSet rs=con.stat.executeQuery("Select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);
        
        setBounds(400,200,700,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    public static void main(String[] args)
    {
        new department();
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         setVisible(false);
         new reception();
    }
}

