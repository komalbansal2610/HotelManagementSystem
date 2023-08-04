/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;

public class addcustomer extends JFrame implements ActionListener {
    
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    
    addcustomer()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(30,80,100,20);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);
        
        String options[]={"Aadhar Card","Passport","Driving License","Voter-id Card","Ration Card"};
        comboid=new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lbnumber=new JLabel("Number");
        lbnumber.setBounds(35,120,100,20);
        lbnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbnumber);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(35,160,100,20);
        lbname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbname);
        
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel lbgender=new JLabel("Gender");
        lbgender.setBounds(35,200,100,20);
        lbgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbgender);
        
        rmale=new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);
        
        rfemale=new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);
        
        JLabel lbcountry=new JLabel("Country");
        lbcountry.setBounds(35,240,100,20);
        lbcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbcountry);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);
        
        croom=new Choice();
        
        try{
           conn conn= new conn();
           String query="Select * from room where availability='available'";
           ResultSet rs=conn.stat.executeQuery(query);
           while(rs.next())
           {
               croom.add(rs.getString("roomnumber"));
           }
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        croom.setBounds(200,280,150,25);
        add(croom);
        
        JLabel lbltime=new JLabel("Checkin time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);
        
        Date date=new Date();
        checkintime=new JLabel(""+date);
        checkintime.setBounds(200,320,170,25);      
        checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkintime);
        
        JLabel lbdeposit=new JLabel("Deposit");
        lbdeposit.setBounds(35,360,100,20);
        lbdeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbdeposit);
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,25);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(240,410,120,25);
        back.addActionListener(this);
        add(back);
        
       ImageIcon i1=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\fifth.png");
       Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(400,50,300,400);
       add(image);
      
        setBounds(350,200,800,550);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    public static void main(String agr[])
    {
        new addcustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         if(e.getSource()==add)
         {
            String id=(String)comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String gender=null;
            
            if(rmale.isSelected())
            {
              gender="Male";  
            }else
            {
               gender="Female"; 
            }
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time=checkintime.getText();
            String deposit=tfdeposit.getText();
            try{
               String query="Insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
               String query2="Update room set availability='Occupied' where roomnumber='"+room+"'";
               
               conn con=new conn();
               con.stat.executeUpdate(query);
               con.stat.executeUpdate(query2);
               
               JOptionPane.showMessageDialog(null,"New customer added successfully");
               
               setVisible(false);
               new reception();
            }
            catch(Exception ae)
            {
               ae.printStackTrace();
            }
         }
            
         else if(e.getSource()==back)
         {
             setVisible(false);
               new reception(); 
         }
    }
}
