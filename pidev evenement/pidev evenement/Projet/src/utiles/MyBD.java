package utiles;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author turki
 */
public class MyBD {
    
   private String url="jdbc:mysql://localhost:3306/paletteplace";
   private String login="root";
   private String pwd="";
   private Connection cnx;
   private static MyBD instance;

    private MyBD() {
       try {
           cnx=DriverManager.getConnection(url, login, pwd);
           System.out.println("Connexion etablie");
       } catch (SQLException ex) {
           Logger.getLogger(MyBD.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
    
    public static MyBD getInstance(){
        if(instance==null)
           instance=new MyBD();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
   
    
    
}