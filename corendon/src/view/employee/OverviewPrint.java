package view.employee;

import connectivity.QueryManager;
import java.io.IOException;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import main.*;
import java.util.Calendar;
import model.Customer;
import model.Luggage;
import model.User;

/**
 *
 * @author Team AwesomeSauce
 */
public class OverviewPrint {

    private final QueryManager query = new QueryManager();
    private final User user = new User();
    private final Customer customer = new Customer();
    private final Luggage luggage = new Luggage();

    private final String DRAW_LINE = "_____________________________________________________________";

    /**
     * Creates a pdf document that is used as receipt for the customers luggage.
     *
     * @param file folder where the file is saved to.
     */
    public void create(String file) {

        query.getLuggageData(Session.itemsToPrint.get(0).toString(), "luggage_id");
        query.getCustomerData(Session.storedCustomerId, "customer_id");
        query.getUserData(Session.storedUsername);

        System.out.println(Session.itemsToPrint);

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
            contentStream.drawString(DRAW_LINE);
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
            contentStream.drawString(DRAW_LINE);
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(100, 485);
            contentStream.drawString("Datum afgehandeld: " + "      "
                    + Calendar.getInstance().get(Calendar.DATE)
                    + "-" + Calendar.getInstance().get(Calendar.MONTH) + "-"
                    + Calendar.getInstance().get(Calendar.YEAR) + " "
                    + Calendar.getInstance().get(Calendar.HOUR)
                    + ":" + Calendar.getInstance().get(Calendar.MINUTE));
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
