/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Colaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 1_DEV
 */
public class ColaboradorDAO extends GenericDAO {

    private Connection conn;

    public ColaboradorDAO(Connection conn) {
        this.conn = conn;
    }

    public int inserir(Colaborador colaborador)  throws SQLException {
        int idColab = 0;
        String sql = "INSERT INTO colaborador (nome, cpf, id_cargo, id_setor) VALUES (?, ?, ?, ?)";
        try ( PreparedStatement stmste = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmste.setString(1, colaborador.getNome());
            stmste.setString(2, colaborador.getCpf());
            stmste.setInt(3, colaborador.getId_cargo());
            stmste.setInt(4, colaborador.getId_setor());
            stmste.executeUpdate();
            
             try (ResultSet generatedKeys = stmste.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retorna o ID gerado
                }
            }
            return idColab;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo inserir, classe ColaboradorDAO " + ex);
            return idColab;
        }
    }

}
