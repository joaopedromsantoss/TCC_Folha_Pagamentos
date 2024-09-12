/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 1_DEV
 */
public class ConnectionBD {
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:src/data/folha_pagamento.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao conectar com banco de dados","Erro",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    } 
}
