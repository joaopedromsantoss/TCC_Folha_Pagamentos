
package dao;

import database.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class GenericDAO {
    
    protected Connection conn;
    protected PreparedStatement stmte;
    
    //estabelece a conexao e retorna a conexao com o banco
    public GenericDAO(){
        this.conn = new ConnectionBD().getConnection();
    }
    
    //recebe a string sql
    protected void prepareStmte(String sql){
        try{
            this.stmte = this.conn.prepareStatement(sql);            
        }
        catch(SQLException e){
            System.out.println("Erro ao preparar estado " + e.getMessage());
        }
    }
    
    //encerra o statement e a conexao.
    protected void closeAll(){
        try{
            this.conn.close();
        }
        catch(SQLException e){
            System.out.println("Erro ao fechar conexao");
        }
    }    
}
