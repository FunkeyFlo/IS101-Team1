package view.employee;

import connectivity.Customer;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import main.*;
import connectivity.Luggage;

/**
 * 
 * @author Team AwesomeSauce
 */
public class OverviewPrint {

    Luggage luggage = new Luggage();
    Customer customer = new Customer();
    public void create(String file) {
        
        luggage.getLuggageData(Session.storedLuggageId, "luggage_id");
        customer.getCustomerData(Session.storedCustomerId, "customer_id");
        
        PDDocument document = null;
        try {
            document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            PDFont font = PDType1Font.HELVETICA_BOLD;
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 700);
            contentStream.drawString(luggage.getDateLost() + " " + luggage.getLocation() + "\n" 
            + customer.getFirstName() + " " + customer.getLastName());
            contentStream.endText();
            contentStream.close();
            document.save(file);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (COSVisitorException e) {
            e.printStackTrace();
        }

    }

}