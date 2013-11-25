/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




package model;
import connectivity.Customer;
import org.apache.pdfbox.pdmodel.*;
import java.io.*;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


/**
 *
 * @author mark
 */
public class Pdf {   
    
        
    public void print(int id, String firstName, String lastName) {
        PDDocument doc = null;
        PDPage page = null;

        try {
            doc = new PDDocument();
            page = new PDPage();

            doc.addPage(page);
            PDFont font = PDType1Font.HELVETICA_BOLD;

            PDPageContentStream content = new PDPageContentStream(doc, page);
            content.beginText();
            content.setFont(font, 12);
            content.moveTextPositionByAmount(100, 700);
            content.drawString(id + firstName + lastName);

            content.endText();
            content.close();
            // Pas dit aan naar een pad die voor jou werkt. 
            doc.save("D:\\Users\\mark\\Desktop\\PDF\\PDFPDFWithText.pdf");
            doc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
