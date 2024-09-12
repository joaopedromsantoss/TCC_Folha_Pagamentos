/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Cargo;
import classes.Setor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 1_DEV
 */
public class CargoDAO extends GenericDAO {
    
    private Connection conn;

    public CargoDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean inserir(Cargo cargo)  throws SQLException {
        String sql = "INSERT INTO cargo (cargo, salario_bruto, horas_normais) VALUES (?,?,?)";
        try ( PreparedStatement stmste = conn.prepareStatement(sql)) {
            stmste.setString(1, cargo.getCargo());
            stmste.setString(2, cargo.getSalBruto());
            stmste.setString(3, cargo.getHoraNormal());
            stmste.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo inserir, classe CargoDAO " + ex);
            return false;
        }
    }
    
    
    public List<Cargo> listarCargos(){
        
         String sql = "SELECT * FROM cargo";
        try (PreparedStatement stmste = conn.prepareStatement(sql)){
            
            ResultSet rs = stmste.executeQuery();
            
            List<Cargo> listaCargos = new ArrayList<>();
            
            while(rs.next()){
                Cargo cargo = new Cargo(sql);
                cargo.setCargo(rs.getString("cargo"));
                cargo.setIdCargo(rs.getInt("id_cargo"));
                System.out.println(cargo.getCargo());
                listaCargos.add(cargo);
            }
            
            rs.close();
            return listaCargos;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no metodo listarCargos, classe cargoDAO "+ex);
            return null;
        }
    }

    public Cargo getItemById(int id) {
        String sql = "SELECT * FROM cargo WHERE id_cargo = ?";
        Cargo car= null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Cargo cargo = new Cargo();
            if (rs.next()) {
                
                cargo.setIdCargo(rs.getInt("id_cargo"));
                cargo.setSalBruto(rs.getString("salario_bruto"));
                cargo.setHoraNormal(rs.getString("horas_normais"));
            }   
            return cargo;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }
}
