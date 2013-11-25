package view.employee;

import connectivity.Customer;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.*;
import main.*;
import connectivity.Luggage;
import connectivity.User;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

/**
 *
 * @author Team AwesomeSauce
 */
public class OverviewPrint {

    private Luggage luggage = new Luggage();
    private Customer customer = new Customer();
    private User user = new User();

    public void create(String file) {

        luggage.getLuggageData(Session.storedLuggageId, "luggage_id");
        customer.getCustomerData(Session.storedCustomerId, "customer_id");
        user.getUserData(Session.storedUsername);

        PDDocument document = null;
        try {
            document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            PDFont font = PDType1Font.HELVETICA;
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 730);
            contentStream.drawString("U bent geholpen door " + user.getFirstName() + " "
                    + user.getLastName());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 728);
            contentStream.drawString("_____________________________________________________________");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 700);
            contentStream.drawString("Eigenaar: " + "            "
                    + customer.getFirstName() + " " + customer.getLastName());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 685);
            contentStream.drawString("Adres: " + "                 "
                    + customer.getAddress() + " " + customer.getCountry());
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 670);
            contentStream.drawString("Postcode: " + "           "
                    + customer.getPostalCode());
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 655);
            contentStream.drawString("Verloren op: " + "        "
                    + luggage.getDateLost().substring(0, luggage.getDateLost().length() - 10)
                    + " Locatie: " + luggage.getLocation());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 625);
            contentStream.drawString("Beschrijving: " + "       " + luggage.getDescription());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 535);
            contentStream.drawString("Handtekening voor ontvangst:         " + "____________________");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 500);
            contentStream.drawString("_____________________________________________________________");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 485);
            contentStream.drawString("Datum afgehandeld: " + "      "
                    + luggage.getDateHandled().substring(0, luggage.getDateHandled().length() - 10));
            contentStream.endText();
            
            PDXObjectImage image = new PDXObjectImage (document, "/home/egbert/Dropbox/HVA/Project/IS101-Team1/corendon-airlines.jpg") {
                
                @Override
                public BufferedImage getRGBImage() throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                
                @Override
                public void write2OutputStream(OutputStream out) throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
                    
            contentStream.drawImage(image, 100, 400);
            
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
