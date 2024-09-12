/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Dependente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author 1_DEV
 */
public class DependenteDAO extends GenericDAO{
    
    private Connection conn;

    public DependenteDAO(Connection conn) {
        this.conn = conn;
    }

    public int inserir(Dependente dependente)  throws SQLException {
        String sql = "INSERT INTO dependente (nome, cpf, data_nasc, id_colab) VALUES (?,?,?,?)";
        try ( PreparedStatement stmste = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmste.setString(1, dependente.getNome());
            stmste.setString(2, dependente.getCpf());
            stmste.setString(3, dependente.getDataNasc());
            stmste.setInt(4, dependente.getId_colaborador());
            stmste.executeUpdate();
   
            try (ResultSet generatedKeys = stmste.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Retorna o ID gerado
            } else {
                throw new SQLException("Falha ao inserir colaborador, nenhum ID gerado.");
                }
            
            }
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no método inserir, classe ColaboradorDAO: " + ex);
                return -1; // Retorna -1 se houver falha
            }
    }
}
