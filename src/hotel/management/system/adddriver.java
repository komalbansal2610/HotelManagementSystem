
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class adddriver extends JFrame implements ActionListener{
    
    JButton add,cancel; 
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox agecombo,availablecombo;
    
    adddriver()
    {
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel heading=new JLabel("ADD DRIVER");
      heading.setFont(new Font("Tahoma",Font.BOLD,18));
      heading.setBounds(150,10,200,30);
      add(heading);
      
      JLabel lblroomno=new JLabel("Name");
      lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
      lblroomno.setBounds(60,70,150,30);
      add(lblroomno);
      
      tfname=new JTextField();
      tfname.setBounds(200,70,150,30);
      add(tfname);
      
      JLabel lblage=new JLabel("Age");
      lblage.setFont(new Font("Tahoma",Font.PLAIN,18));
      lblage.setBounds(60,110,150,30);
      add(lblage);
      
      tfage=new JTextField();
      tfage.setBounds(200,110,150,30);
      add(tfage);
       
      JLabel lblclean=new JLabel("Gender");
      lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
      lblclean.setBounds(60,150,150,30);
      add(lblclean);
      
      String ageopt[]={"Male","Female"};
      agecombo=new JComboBox(ageopt);
      agecombo.setBounds(200,150,150,30);
      agecombo.setBackground(Color.WHITE);
      add(agecombo);
      
      JLabel lblprice=new JLabel("Car Comppany");
      lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
      lblprice.setBounds(60,190,150,30);
      add(lblprice);
      
      tfcompany=new JTextField();
      tfcompany.setBounds(200,190,150,30);
      add(tfcompany);
      
      JLabel lbltype=new JLabel("Car Model");
      lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
      lbltype.setBounds(60,230,150,30);
      add(lbltype);
      
      tfmodel=new JTextField();
      tfmodel.setBounds(200,230,150,30);
      add(tfmodel);
      
      JLabel lblavailable=new JLabel("Available");
      lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
      lblavailable.setBounds(60,270,150,30);
      add(lblavailable);
      
      String availableopt[]={"Available","Busy"};
      availablecombo=new JComboBox(availableopt);
      availablecombo.setBounds(200,270,150,30);
      availablecombo.setBackground(Color.WHITE);
      add(availablecombo);
      
      JLabel lbllocation=new JLabel("Location");
      lbllocation.setFont(new Font("Tahoma",Font.PLAIN,18));
      lbllocation.setBounds(60,310,150,30);
      add(lbllocation);
      
      tflocation=new JTextField();
      tflocation.setBounds(200,310,150,30);
      add(tflocation);
      
      add=new JButton("Add Driver");
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
      
      ImageIcon i1=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\eleven.jpg");
      Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(400,30,500,300);
      add(image);
        
      setBounds(300,200,980,470);
      setVisible(true);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
      setResizable(false);
    }
    
    public static void main(String args[])
    {
        new adddriver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e.getSource()==add)
       {
           String name=tfname.getText();
           String age=tfage.getText();
           String gender=(String)agecombo.getSelectedItem();
           String company=tfcompany.getText();
           String brand=tfmodel.getText();
           String available=(String)availablecombo.getSelectedItem();
           String location=tflocation.getText();
           
           try{
               conn conn=new conn();
               String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
               conn.stat.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
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
