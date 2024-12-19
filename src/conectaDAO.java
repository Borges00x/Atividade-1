
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null; 
             
           try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leiloes ", "Alessandro", "12345");
            return conn;
           } catch(ClassNotFoundException | SQLException ex) 
           {
               JOptionPane.showMessageDialog(null, "Não foi possível se conectar ao Banco de Dados! Por favor tente mais tarde!");
               return null;
           }
    }
    
}
