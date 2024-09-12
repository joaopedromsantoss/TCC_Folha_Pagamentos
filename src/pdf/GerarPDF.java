/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;

import com.sun.jdi.connect.spi.Connection;
import dao.GenericDAO;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author 1_DEV
 */
public class GerarPDF extends GenericDAO {
    
     public static void main(String[] args) {
        
        PDDocument document = new PDDocument();
        
        Connection conn = null;

        try {
            // Conectando ao banco de dados
            conn = DriverManager.getConnection("jdbc:sqlite:src/data/folha_pagamento.db");
            String sql = "SELECT nome, cpf, id_cargo, id_setor FROM colaborador";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Criando uma nova página no documento PDF
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Definindo a fonte e o tamanho do texto
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);

            // Escrevendo o cabeçalho da folha de pagamento
            contentStream.showText("Folha de Pagamento");
            contentStream.newLineAtOffset(0, -20);

            // Escrevendo os dados do banco de dados no PDF
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                double salario = resultSet.getDouble("salario");

                contentStream.showText("Nome: " + nome);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Cargo: " + cargo);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Salário: " + salario);
                contentStream.newLineAtOffset(0, -40); // Espaço entre registros
            }

            contentStream.endText();
            contentStream.close();

            // Salvando o PDF no disco
            document.save("folha_pagamento.pdf");
            System.out.println("Folha de pagamento gerada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (document != null) {
                    document.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

