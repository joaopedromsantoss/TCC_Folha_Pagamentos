/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import classes.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 1_DEV
 */
public class EmpresaDAO extends GenericDAO{
    private Connection conn;
    
    
     public EmpresaDAO(Connection conn) {
        this.conn = conn;
    }

//    public EmpresaDAO(com.sun.jdi.connect.spi.Connection conn) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
     
//     
     
    protected PreparedStatement stmte;
    
    public boolean inserir(Empresa empresa) {
         String sql = "INSERT INTO empresa (nome, email, empresa, cnpj, senha) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmste = conn.prepareStatement(sql) ){
            stmste.setString(1, empresa.getName());
            stmste.setString(2, empresa.getEmail());
            stmste.setString(3, empresa.getCnpj());
            stmste.setString(4, empresa.getNameEmpresa());
            stmste.setString(5, empresa.getPassWord());
            stmste.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo inserir, classe EmpresaDAO " + ex);
            return false;
        }
    }
    
     public void closeAll(){
        try{
            this.conn.close();
        }
        catch(SQLException e){
            System.out.println("Erro ao fechar conexao");
        }
    }   
     
    public boolean verificarLogin(String cnpjL, String senha) throws SQLException {
    String sql = "SELECT * FROM empresa WHERE cnpj = ? AND senha = ?";
    int count = 0;

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, cnpjL);
        stmt.setString(2, senha);
        
        // Execute a consulta e obtenha o número de linhas correspondentes
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            String cnpjBD = rs.getString("cnpj");
            String senhaBD = rs.getString("senha");
            
            System.out.println(cnpjBD);
            System.out.println(senhaBD);
            return true;
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    // Retorna true se o número de linhas for maior que 0
    return count > 0;
    }
     
//     
     
     
     
//     public Empresa getUsuario() {
//
//        try {
//            String sql = "SELECT * FROM usuarios WHERE id = ?";
//            this.prepareStmte(sql);
//            this.stmte.setInt(1, id);
//            ResultSet rs = this.stmte.executeQuery();
//            
//            Empresa emp = new Empresa(sql, sql, sql, sql, sql);
//            
//            if (rs.next()) {
//                emp.setCnpj(rs.getString("cnpj"));
//                emp.setPassWord(rs.getString("senha"));
//            }
//            
//            rs.close();
//            this.closeAll();
//            return emp;
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo getUsuario, classe UsuarioDAO" + ex);
//            return null;
//        }
//    }
}
