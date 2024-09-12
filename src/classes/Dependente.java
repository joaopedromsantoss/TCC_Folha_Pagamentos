/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author 1_DEV
 */
public class Dependente {
    
    private String nome;
    
    private String dataNasc;
    
    private String cpf;
    
    private int id_colaborador;

    public Dependente(String nome, String dataNasc, String cpf, int id_colaborador) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.id_colaborador = id_colaborador;
    }

    public int getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(int id_colaborador) {
        this.id_colaborador = id_colaborador;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    

    @Override
    public String toString() {
        return "Dependente{" + "nome=" + nome + ", dataNasc=" + dataNasc + ", cpf=" + cpf + '}';
    }

    
    
    
    
}
