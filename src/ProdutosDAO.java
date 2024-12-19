
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        conn = new conectaDAO().connectDB();
        
        
        try 
        {
            
            prep = conn.prepareStatement("Insert into produtos (nome, valor, status) values (?, ?, ?) ");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());

            prep.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Salvos com sucesso!");
            
        } catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro! tente novamente mais tarde.");
            }
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(String id){
        
        try {
            conn = new conectaDAO().connectDB();
            
            prep = conn.prepareStatement("select * from produtos Where id LIKE ?");
            
            prep.setString(1, "%" +id+ "%");
            
            resultset = prep.executeQuery();
            
            while(resultset.next()) 
            {
                ProdutosDTO produto = new ProdutosDTO();
                
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));
                
                listagem.add(produto);
            }
                return listagem;
                
        } catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "Erro:"+ex);
                
                return null;
            }
 
    }
    
       public void venderProduto(int id) 
    {
        try {
            
        conn = new conectaDAO().connectDB();
            
        prep = conn.prepareStatement("update produtos set status = ? where id = ?");
            
        prep.setString(1, "Vendido");
        prep.setInt(2, id);
        
        prep.executeUpdate();
        
        } catch (SQLException erro) 
            {
                JOptionPane.showMessageDialog(null, "Erro ao vender o produto! por favor tente mais tarde! ");
            }
    }
       
           public ArrayList<ProdutosDTO> listarProdutosVendidos() 
    {
        try {
        conn = new conectaDAO().connectDB();
        
        prep = conn.prepareStatement("select * from produtos where status LIKE ? ");
        
        prep.setString(1, "vendido");
        
        resultset = prep.executeQuery();
        
        while(resultset.next()) 
            {
                ProdutosDTO produto = new ProdutosDTO();
                
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));
                
                listagem.add(produto);
            }
        
                    return listagem;
        
        } catch (SQLException erro) 
            {
                JOptionPane.showMessageDialog(null, "Erro ao exibir os dados! por favor tente mais tarde!");
                
                return null;
            }
    }
    
        
}

