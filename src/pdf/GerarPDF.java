/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;

import java.sql.Connection;
import dao.GenericDAO;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

/**
 *
 * @author 1_DEV
 */
public class GerarPDF extends GenericDAO {

    private Connection conn;

    // Construtor que recebe a conexão
    public GerarPDF(Connection conn) {
        this.conn = conn;
    }

    // Método para gerar o PDF ao clicar no botão
    public void gerarFolhaPagamentoPDF() {
        PDDocument document = new PDDocument();
        String sql = "SELECT nome, cpf FROM colaborador";

        try ( PreparedStatement stmste = conn.prepareStatement(sql);  
                ResultSet resultSet = stmste.executeQuery()) {

            PDFont font = PDType0Font.load(document, new File("src/fonts/arial.ttf"));
            PDPage page = new PDPage();
            document.addPage(page);

            try ( PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(font, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 700);

                
                contentStream.showText("Folha de Pagamento");
                contentStream.newLineAtOffset(0, -20);

                while (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String cpf = resultSet.getString("cpf");

                    contentStream.showText("Nome: " + nome);
                    contentStream.newLineAtOffset(0, -20);
                    contentStream.showText("Cargo: " + cpf);
                    contentStream.newLineAtOffset(0, -20);
                }

                contentStream.endText();
            }

            document.save("src/relatorios/folha_pagamento1.pdf");
            System.out.println("PDF gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
