/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author 1_DEV
 */
public class Colaborador {
    
    private String nome;
    
    private String cpf;
    
    private int id_cargo;
    
    private int id_setor;

    
    
    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_setor() {
        return id_setor;
    }

    public void setId_setor(int id_setor) {
        this.id_setor = id_setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Colaborador(String nome, String cpf, int id_cargo, int id_setor) {
        this.nome = nome;
        this.cpf = cpf;
        this.id_cargo = id_cargo;
        this.id_setor = id_setor;
    }

    
    
    
    
}
