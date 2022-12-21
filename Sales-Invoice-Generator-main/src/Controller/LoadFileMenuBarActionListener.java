
package Controller;

import Model.InvoiceHeader;
import Model.InvoiceHeaderJTableModel;
import Model.InvoiceLine;
import View.MyFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class LoadFileMenuBarActionListener {

    private MyFrame frame;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public LoadFileMenuBarActionListener(MyFrame frame) {this.frame = frame;}

    public void loadFileMenuBar() {

        JOptionPane.showMessageDialog(frame, "Please, select header file!", "Choose Header File", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser openFileChooser = new JFileChooser();
        int result = openFileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFileChooser.getSelectedFile();

            try {
                BufferedReader headerBufferedReader = new BufferedReader(new FileReader(headerFile));

                String headerLinesFromCSV = null;
                while ((headerLinesFromCSV = headerBufferedReader.readLine()) != null) {
                    String[] splitHeaderLinesParts = headerLinesFromCSV.split(",");

                    String invoiceNumberString = splitHeaderLinesParts[0];
                    String invoiceDateString = splitHeaderLinesParts[1];
                    String invoiceCustomerNameString = splitHeaderLinesParts[2];

                    int invoiceNumberInt = Integer.parseInt(invoiceNumberString);

                    Date invoiceDate = dateFormat.parse(invoiceDateString);

                    InvoiceHeader invoice = new InvoiceHeader(invoiceNumberInt, invoiceCustomerNameString, invoiceDate);

                    frame.getInvoicesHeaderList().add(invoice);
                }

                JOptionPane.showMessageDialog(frame, "Please, select line file!", "Choose Line File", JOptionPane.INFORMATION_MESSAGE);
                result = openFileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {

                    File lineFile = openFileChooser.getSelectedFile();
                    BufferedReader lineBufferedReader1 = new BufferedReader(new FileReader(lineFile));
                    String lineLinesFromCSV = null;

                    while ((lineLinesFromCSV = lineBufferedReader1.readLine()) != null) {
                        String[] splitLineLinesParts = lineLinesFromCSV.split(",");

                        String ItemNumberString = splitLineLinesParts[0];
                        String itemNameString = splitLineLinesParts[1];
                        String itemPriceString = splitLineLinesParts[2];
                        String itemCountString = splitLineLinesParts[3];

                        int itemNumberInt = Integer.parseInt(ItemNumberString);
                        int itemCountInt = Integer.parseInt(itemCountString);

                        double itemPriceDouble = Double.parseDouble(itemPriceString);

                        InvoiceHeader header = findInvoiceHeaderByNumber(itemNumberInt);
                        InvoiceLine invoiceLine = new InvoiceLine(itemNumberInt, itemNameString, itemPriceDouble, itemCountInt, header);

                        header.getInvoiceLines().add(invoiceLine);
                    }
                    frame.setInvoiceHeaderJTableModel(new InvoiceHeaderJTableModel(frame.getInvoicesHeaderList()));
                    frame.getInvoiceTableJTableLeftSide().setModel(frame.getInvoiceHeaderJTableModel());
                    frame.getInvoiceTableJTableLeftSide().validate();
                }
            } catch (Exception el) {
                el.printStackTrace();
            }
        }
    }

    private InvoiceHeader findInvoiceHeaderByNumber(int invoiceNumber) {
        InvoiceHeader header = null;
        for (InvoiceHeader inv : frame.getInvoicesHeaderList()) {
            if (invoiceNumber == inv.getInvoiceNumber()) {
                header = inv;
                break;
            }
        }
        return header;
    }
}
