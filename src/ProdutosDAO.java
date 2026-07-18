/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    public void venderProduto(int id){
    conn = new conectaDAO().connectDB();
    String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
    
       try {
           prep = conn.prepareStatement(sql);
           prep.setInt(1, id);
           prep.executeUpdate();
       } catch (SQLException e) {
           System.out.println("Erro ao vender produto: " + e.getMessage());
       }
    }
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos(){
       conn = new conectaDAO().connectDB();
       String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";
       ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
       try {
           prep = conn.prepareStatement(sql);
           resultset = prep.executeQuery();
        
           while(resultset.next()){
               ProdutosDTO produto = new ProdutosDTO();
               produto.setId(resultset.getInt("id"));
               produto.setNome(resultset.getString("nome"));
               produto.setValor(resultset.getInt("valor"));
               produto.setStatus(resultset.getString("status"));
               listagem.add(produto);
           }
       } catch (SQLException e) {
        System.out.println("Erro ao listar vendidos: " + e.getMessage());
       }
    return listagem;
}
    
    
    
        
}

