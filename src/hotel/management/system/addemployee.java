
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class addemployee extends JFrame implements ActionListener {
    
    JTextField tfname,tfage,rbsalary,rbphone,rbemail,rbaadhar;
    JRadioButton rbmale,rbfemale;
    JComboBox cbjob;
    JButton submit;
    
    addemployee()
    {
        setLayout(null);
        
        JLabel lablname=new JLabel("NAME");
        lablname.setBounds(60,30,120,30);
        lablname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lablname);
        
        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
         JLabel lablage=new JLabel("AGE");
        lablage.setBounds(60,80,120,30);
        lablage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lablage);
        
        tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
          
        JLabel lablgender=new JLabel("GENDER");
        lablgender.setBounds(60,130,120,30);
        lablgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lablgender);
        
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel labljob=new JLabel("JOB");
        labljob.setBounds(60,180,120,30);
        labljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(labljob);
        
        String str[]={"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staff","Room Service","Chefs","Waiters/Waitress","Manager","Accountants"};
        cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        JLabel lablsalary=new JLabel("SALARY");
        lablsalary.setBounds(60,230,120,30);
        lablsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lablsalary);
        
        rbsalary=new JTextField();
        rbsalary.setBounds(200,230,150,30);
        rbsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(rbsalary);
        
        JLabel lablphone=new JLabel("PHONE");
        lablphone.setBounds(60,280,120,30);
        lablphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lablphone);
        
        rbphone=new JTextField();
        rbphone.setBounds(200,280,150,30);
        rbphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(rbphone);
        
        JLabel lablemail=new JLabel("EMAIL");
        lablemail.setBounds(60,320,120,30);
        lablemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lablemail);
        
        rbemail=new JTextField();
        rbemail.setBounds(200,320,150,30);
        rbemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(rbemail);
        
        JLabel lablaadhar=new JLabel("AADHARCARD NUMBER");
        lablaadhar.setBounds(60,380,120,30);
        lablaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lablaadhar);
        
        rbaadhar=new JTextField();
        rbaadhar.setBounds(200,380,150,30);
        rbaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(rbaadhar);
        
        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\tenth.jpg");
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
         
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    public static void main(String args[])
    {
        new addemployee();
    }

    public void actionPerformed(ActionEvent e) {

//To change body of generated methods, choose Tools | Templates.
       String name=tfname.getText();
       String age=tfage.getText();
       String salary=rbsalary.getText();
       String phone=rbphone.getText();
       String email=rbemail.getText();
       String aadhar=rbaadhar.getText();
       
       String gender=null;
       if(rbmale.isSelected())
       {
           gender="Male";
       }
       else if(rbfemale.isSelected())
       {
           gender="Female";
       }
       String job;
        job = (String)cbjob.getSelectedItem();
       
//       if(name.equals(""))
//       {
//           JOptionPane.showMessageDialog(null,"name should not be empty");
//       }
       try{
           conn connn=new conn();
           String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
           connn.stat.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Employee added Successfully");
           setVisible(false);
       }
       catch(Exception ee)
       {
           ee.printStackTrace();
       }
    }
}
