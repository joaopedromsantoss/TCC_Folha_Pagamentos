/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author 1_DEV
 */
public class Vencimento {
    
    private String salarioBruto;
    
    private int numeroDiasTrabalhados;
    
    private int dependentes;
    
    private int dependentesIdade;
    
    private String cargaHorariaNormal;
    
    private int cargaHE;
    
    

    public Vencimento(String salarioBruto, int numeroDiasTrabalhados, int dependentes, int dependentesIdade, String cargaHorariaNormal) {
        this.salarioBruto = salarioBruto;
        this.numeroDiasTrabalhados = numeroDiasTrabalhados;
        this.dependentes = dependentes;
        this.dependentesIdade = dependentesIdade;
        this.cargaHorariaNormal = cargaHorariaNormal;
    }


    public int getDependentesIdade() {
        return dependentesIdade;
    }

    public void setDependentesIdade(int dependentesIdade) {
        this.dependentesIdade = dependentesIdade;
    }

    public String getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(String salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }
    
    
    public int getNumeroDiasTrabalhados() {
        return numeroDiasTrabalhados;
    }

    public void setNumeroDiasTrabalhados(int numeroDiasTrabalhados) {
        this.numeroDiasTrabalhados = numeroDiasTrabalhados;
    }

    public String getCargaHorariaNormal() {
        return cargaHorariaNormal;
    }

    public void setCargaHorariaNormal(String cargaHorariaNormal) {
        this.cargaHorariaNormal = cargaHorariaNormal;
    }

    public int getCargaHE() {
        return cargaHE;
    }

    public void setCargaHE(int cargaHE) {
        this.cargaHE = cargaHE;
    }

    @Override
    public String toString() {
        return "Vencimento{" + "salarioBruto=" + salarioBruto + ", numeroDiasTrabalhados=" + numeroDiasTrabalhados + ", dependentes=" + dependentes + ", dependentesIdade=" + dependentesIdade + ", cargaHorariaNormal=" + cargaHorariaNormal + ", cargaHE=" + cargaHE + '}';
    }

    
    public String salarioFamilia(){
        
        double salarioB = Double.parseDouble(salarioBruto);
        
        if (dependentesIdade <= 14 && salarioB <= 1819.26) {
          String salarioF = salarioBruto + (62 * dependentes);
          
          return salarioF;
        } else {
            System.out.println("Você não precisa do salário família");
            return  "";
        } 
    }
    
    public double horaExtraDiasNormais(){
        
        double salarioB = Double.parseDouble(salarioBruto);
        
        int cargaH = Integer.parseInt(cargaHorariaNormal);
        
        double salarioHora = salarioB / cargaH;
        
        double valorHE = salarioHora * 1.5;
        
        double salarioHE = valorHE * cargaHE;
        
       return salarioHE;
    }
    
    public double horaExtraDomingos(){
      
      double salarioB = Double.parseDouble(salarioBruto);
        
        int cargaH = Integer.parseInt(cargaHorariaNormal);
        
        double salarioHora = salarioB / cargaH;
        
        double valorHE = salarioHora * 2;
        
        double salarioHE = valorHE * cargaHE;
        
       return salarioHE;
        
       
    }
    
}
