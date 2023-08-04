
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class reception extends JFrame implements ActionListener{
     
    JButton newcustomer,rooms,department,allemployee,managerinfo,customers,searchroom,update,roomstatus,pickup,checkout,logout;
    reception()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newcustomer=new JButton("New Customer Form");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
        rooms=new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
//        rooms.setBounds(50,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        department=new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        allemployee=new JButton("All Employees");
        allemployee.setBounds(10,150,200,30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        allemployee.addActionListener(this);
        add(allemployee);
        
        customers=new JButton("Customer Info");
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);
        
        managerinfo=new JButton("Manager Info");
        managerinfo.setBounds(10,230,200,30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo);
        
        checkout=new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        update=new JButton("Pending Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        roomstatus=new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        pickup=new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
        searchroom=new JButton("Search Room");
        searchroom.setBounds(10,430,200,30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout=new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\fourth.jpg");
//      Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
//      ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
//        image.setBounds(250,30,800,800);
        add(image);
      
        setBounds(250,30,800,550);
//        setBounds(250,30,1500,1000);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    public static void main(String[] args) {
        new reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           if(e.getSource()==newcustomer)
           {
             setVisible(false);
             new addcustomer();
           }
           else if(e.getSource()==rooms)
           {
               setVisible(false);
               new room();
           }
           else if(e.getSource()==department)
           {
               setVisible(false);
               new department();
           }
           else if(e.getSource()==allemployee)
           {
               setVisible(false);
               new employeeinfo();
           }
           else if(e.getSource()==managerinfo)
           {
               setVisible(false);
               new managerinfo();
           }
           else if(e.getSource()==customers)
           {
               setVisible(false);
               new customers();
           }
           else if(e.getSource()==searchroom)
           {
               setVisible(false);
               new searchroom();
           }
           else if(e.getSource()==update)
           {
               setVisible(false);
               new updatecheck();
           }
           else if(e.getSource()==roomstatus)
           {
               setVisible(false);
               new updateroom();
           }
           else if(e.getSource()==pickup)
           {
               setVisible(false);
               new pickup();
           }
           else if(e.getSource()==checkout)
           {
               setVisible(false);
               new checkout();
           }
           else if(e.getSource()==logout)
           {
               setVisible(false);
               System.exit(0);
           }
           
           
    }
}
