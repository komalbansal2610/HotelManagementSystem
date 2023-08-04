
package hotel.management.system;
import java.sql.*;

public class conn {
    Connection con;
     Statement stat;
    conn()
    {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","");
            stat=con.createStatement();
          
           
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
