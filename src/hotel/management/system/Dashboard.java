/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard()
    {
       
       setBounds(0,0,1550,1535);
       setLayout(null);
      
       ImageIcon i1=new ImageIcon("C:\\\\Users\\\\gulshan\\\\Documents\\\\NetBeansProjects\\\\Hotel Management System\\\\src\\\\icons\\\\third.jpg");
       Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,1550,1000);
       add(image);
       
       JLabel text=new JLabel("THE BANSAL GROUP WELCOMES YOU");
       text.setBounds(400,80,1000,50);
       text.setFont(new Font("Tahoma",Font.PLAIN,46));
       text.setForeground(Color.WHITE);
       image.add(text);
         
       
       JMenuBar nb=new JMenuBar();
       nb.setBounds(0,0,1550,50);
       image.add(nb);
       
       JMenu hotel=new JMenu("Reception");
       hotel.setForeground(Color.BLACK);
       nb.add(hotel);
       
       JMenuItem reception=new JMenuItem("Reception");
       reception.setMnemonic(KeyEvent.VK_R);
       reception.addActionListener(this);
       hotel.add(reception);
       
       JMenu admin=new JMenu("Admin");
       admin.setForeground(Color.BLACK);
       nb.add(admin);
       
       JMenuItem addemployee=new JMenuItem("Add Employee");
       addemployee.addActionListener(this);
       admin.add(addemployee);
       
            
       JMenuItem addrooms=new JMenuItem("Add Rooms");
       addrooms.addActionListener(this);
       admin.add(addrooms);
       
            
       JMenuItem adddrivers=new JMenuItem("Add Drivers");
       adddrivers.addActionListener(this);
       admin.add(adddrivers);
       
      setVisible(true);
//      setLocation(getCenterPoint(getSize()));
       setLocationRelativeTo(null);
      setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
      setResizable(false);
    }
//    static Point getCenterPoint(Dimension frame)
//	{
//		Point p1=new Point();
//		Dimension desktop=Toolkit.getDefaultToolkit().getScreenSize();
//		p1.x=(desktop.width-frame.width)/2;
//		p1.y=(desktop.height-frame.height)/2;
//		return p1;
//	}
    
    public static void main(String args[])
    {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      if(e.getActionCommand().equals("Add Employee"))
      {
       new addemployee();
      }
      else if(e.getActionCommand().equals("Add Rooms"))
      {
          new addrooms();
      }
      else if(e.getActionCommand().equals("Add Drivers"))
      {
          new adddriver();
      }
      else if(e.getActionCommand().equals("Reception"))
      {
          new reception();
      }
    }
}
