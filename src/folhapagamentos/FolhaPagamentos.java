/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package folhapagamentos;


/**
 *
 * @author 1_DEV
 */
public class FolhaPagamentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        database.ConnectionBD connection = new database.ConnectionBD();
        connection.getConnection();
    }
    
}
