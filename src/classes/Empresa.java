    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author 1_DEV
 */
public class Empresa {
    
    
    private String name;
    
    private String email;
    
    private String nameEmpresa;
    
    private String cnpj;

    private String passWord;
    
    public Empresa(String name, String email, String nameEmpresa, String cnpj, String passWord) {
        this.name = name;
        this.email = email;
        this.nameEmpresa = nameEmpresa;
        this.cnpj = cnpj;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNameEmpresa() {
        return nameEmpresa;
    }

    public void setNameEmpresa(String nameEmpresa) {
        this.nameEmpresa = nameEmpresa;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Empresa{" + "name=" + name + ", email=" + email + ", cnpj=" + cnpj + ", nameEmpresa=" + nameEmpresa + ", passWord=" + passWord + '}';
    }
    
    
    
}
