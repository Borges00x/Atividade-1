
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null; 
             
           try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leiloes ", "Alessandro", "12345");
            return conn;
           } catch(ClassNotFoundException | SQLException ex) 
           {
               JOptionPane.showMessageDialog(null, "Ocorreu um erro : "+ ex.getMessage());
               System.out.println("Ocorreu um erro : "+ ex.getMessage());
               return null;
           }
    }
    
}
