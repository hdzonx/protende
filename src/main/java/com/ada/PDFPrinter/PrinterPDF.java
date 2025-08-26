/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.PDFPrinter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Hudson
 */
public class PrinterPDF {

    private static String typePrestressing = " ";
    private static double forceInDescompression = 0.0;
    private static double forceInFissuration = 0.0;
    private static double finalPrestressingForce = 0.0;
    private static double finalPrestressingForceWithLoss = 0.0;
    private static double effectivePrestressingForceWithLoss = 0.0;
    private static double lossOfPrestressing = 0.0;

    public PrinterPDF(double effectivePrestressingForceWithLoss, double finalPrestressingForceWithLoss) {
        this.effectivePrestressingForceWithLoss = effectivePrestressingForceWithLoss;
        this.finalPrestressingForceWithLoss = finalPrestressingForceWithLoss;
        printResults();
    }

    private static void printResults() {

        try {
            // Criando o documento PDF
            PDDocument document = new PDDocument();

            // Criando uma página
            PDPage page = new PDPage();
            document.addPage(page);

            // Criando o fluxo de conteúdo para a página
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Posição inicial
            float yPosition = 750;

            // Adicionando o título com a fonte Helvetica (bold)
            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD), 18);
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Resultado das forças de protensão");
            contentStream.endText();

            // Atualizando a posição vertical após o título
            yPosition -= 30;

            // Adicionando o primeiro parágrafo com a fonte Helvetica normal
            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Tipo de protensão: " + typePrestressing);
            contentStream.endText();

            // Atualizando a posição para o próximo parágrafo
            yPosition -= 30;

            // Adicionando outro parágrafo
            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Estado limite de Descompressão = " + forceInDescompression + " kN");
            contentStream.endText();

            // Atualizando a posição para o próximo parágrafo
            yPosition -= 30;

            // Adicionando outro parágrafo
            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Estado limite de Fissuração = " + forceInFissuration + " kN");
            contentStream.endText();
            // Atualizando a posição para o próximo parágrafo
            yPosition -= 30;

            // Adicionando outro parágrafo
            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Força final de protensão sem perdas = " + finalPrestressingForce + " kN");
            contentStream.endText();

            // Atualizando a posição para o próximo parágrafo
            yPosition -= 30;

            // Adicionando outro parágrafo
            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Força final de protensão com perdas de " + lossOfPrestressing + " % = " + finalPrestressingForceWithLoss + " kN");
            contentStream.endText();

            // Atualizando a posição para o próximo parágrafo
            yPosition -= 30;

            // Adicionando outro parágrafo
            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Força final efetiva considerando a cordoalha usada e as perdas de protensão = " + effectivePrestressingForceWithLoss + " kN");
            contentStream.endText();

            // Atualizando a posição para o próximo parágrafo
            yPosition -= 30;

            // Adicionando uma imagem (certifique-se de ter a imagem no caminho correto)
            //String imagePath = "caminho/para/imagem.jpg";
            // PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, document);
            // contentStream.drawImage(pdImage, 50, yPosition, 200, 100); // x, y, largura, altura
            // Fechando o fluxo de conteúdo
            contentStream.close();
            // Caminho do arquivo PDF gerado
            String pdfPath = "documento.pdf";
            // Salvando o documento
            document.save("documento.pdf");

            // Fechando o documento
            document.close();

            // Abrindo o PDF automaticamente após a criação
            openPdfAutomatically(pdfPath);

            System.out.println("PDF criado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void openPdfAutomatically(String pdfPath) {
        try {
            // Detectando o sistema operacional e abrindo o PDF no visualizador padrão
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                // Windows
                Runtime.getRuntime().exec("cmd /c start " + pdfPath);
            } else if (os.contains("mac")) {
                // macOS
                Runtime.getRuntime().exec("open " + pdfPath);
            } else if (os.contains("nix") || os.contains("nux")) {
                // Linux
                Runtime.getRuntime().exec("xdg-open " + pdfPath);
            } else {
                System.out.println("Sistema operacional não suportado para abertura automática.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        printResults();
    }
}
