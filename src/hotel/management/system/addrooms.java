
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class addrooms extends JFrame implements ActionListener{
    
    JButton add,cancel; 
    JTextField tfrooms,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    
    addrooms()
    {
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel heading=new JLabel("ADD ROOMS");
      heading.setFont(new Font("Tahoma",Font.BOLD,18));
      heading.setBounds(150,20,200,30);
      add(heading);
      
      JLabel lblroomno=new JLabel("Room Number");
      lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
      lblroomno.setBounds(60,80,150,30);
      add(lblroomno);
      
      tfrooms=new JTextField();
      tfrooms.setBounds(200,80,150,30);
      add(tfrooms);
      
      JLabel lblavailable=new JLabel("Available");
      lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
      lblavailable.setBounds(60,130,150,30);
      add(lblavailable);
      
      String availableopt[]={"Available","Occupied"};
      availablecombo=new JComboBox(availableopt);
      availablecombo.setBounds(200,130,150,30);
      availablecombo.setBackground(Color.WHITE);
      add(availablecombo);
       
      JLabel lblclean=new JLabel("Cleaning Status");
      lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
      lblclean.setBounds(60,180,150,30);
      add(lblclean);
      
      String cleanopt[]={"Cleaned","Dirty"};
      cleancombo=new JComboBox(cleanopt);
      cleancombo.setBounds(200,180,150,30);
      cleancombo.setBackground(Color.WHITE);
      add(cleancombo);
      
      JLabel lblprice=new JLabel("Price");
      lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
      lblprice.setBounds(60,230,150,30);
      add(lblprice);
      
      tfprice=new JTextField();
      tfprice.setBounds(200,230,150,30);
      add(tfprice);
      
      JLabel lbltype=new JLabel("Bed Type");
      lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
      lbltype.setBounds(60,280,150,30);
      add(lbltype);
      
      String tyoeopt[]={"Single Bed","Double Bed"};
      typecombo=new JComboBox(tyoeopt);
      typecombo.setBounds(200,280,150,30);
      typecombo.setBackground(Color.WHITE);
      add(typecombo);
      
      add=new JButton("Add Room");
      add.setForeground(Color.WHITE);
      add.setBackground(Color.BLACK);
      add.setBounds(60,350,130,30);
      add.addActionListener(this);
      add(add);
      
      cancel=new JButton("Cancel");
      cancel.setForeground(Color.WHITE);
      cancel.setBackground(Color.BLACK);
      cancel.setBounds(220,350,130,30);
      cancel.addActionListener(this);
      add(cancel);
      
      ImageIcon i1=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\twelve.jpg");
//      Image i2=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
//      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i1);
      image.setBounds(400,30,500,300);
      add(image);
        
      setBounds(330,200,940,470);
      setVisible(true);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
      setResizable(false);
    }
    
    public static void main(String args[])
    {
        new addrooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e.getSource()==add)
       {
           String roomnumber=tfrooms.getText();
           String availability=(String)availablecombo.getSelectedItem();
           String status=(String)cleancombo.getSelectedItem();
           String price=tfprice.getText();
           String type=(String)typecombo.getSelectedItem();
           
           try{
               conn conn=new conn();
               String query="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
               conn.stat.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"New Room Added Successfully");
               setVisible(false);
           }
           catch(Exception ae)
           {
               ae.printStackTrace();
           }
       }
       else
       {
       setVisible(false);
       }
    }
}
