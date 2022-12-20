package Controller;
import Model.InvoiceHeader;
import Model.InvoiceHeaderJTableModel;
import Model.InvoiceLine;
import Model.InvoiceLineJTableModel;
import View.CreateNewInvoice;
import View.MyFrame;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class AllButtonsActionListeners {

    private final MyFrame Frame;
    private final DateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public AllButtonsActionListeners(MyFrame frame) {
        this.Frame = frame;
    }

    public void displayNewInvoiceDialog() {
        Frame.setNewInvoiceDialog(new CreateNewInvoice(Frame));
        Frame.getNewInvoiceDialog().setVisible(true);
    }

    public void insertButtonInDialog() {
        String customerNameDialogString = Frame.getNewInvoiceDialog().getCustomerNameJTextField().getText();
        String dateDialogString = Frame.getNewInvoiceDialog().getInvoiceDateJTextField().getText();

        Frame.getNewInvoiceDialog().setVisible(false);
        Frame.getNewInvoiceDialog().dispose();
        Frame.setNewInvoiceDialog(null);

        try {
            Date dateDialog = DateFormat.parse(dateDialogString);
            int invoiceNumber = getNextInvoiceNumberDialog();
            InvoiceHeader invoiceHeader = new InvoiceHeader(invoiceNumber, customerNameDialogString, dateDialog);
            Frame.getInvoicesHeaderList().add(invoiceHeader);
            Frame.getInvoiceHeaderJTableModel().fireTableDataChanged();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(Frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        displayInvoices();
    }

    public int getNextInvoiceNumberDialog() {
        int max = 0;
        for (InvoiceHeader header : Frame.getInvoicesHeaderList()) {
            if (header.getInvoiceNumber() > max) {
                max = header.getInvoiceNumber();
            }
        }
        return max + 1;
    }

    public void displayInvoices() {
        System.out.println("Error User");
        for (InvoiceHeader header : Frame.getInvoicesHeaderList()) {
            System.out.println(header);
        }
        System.out.println("Error User");
    }

    public void cancelButtonInDialog() {
        Frame.getNewInvoiceDialog().setVisible(false);
        Frame.getNewInvoiceDialog().dispose();
        Frame.setNewInvoiceDialog(null);
    }

    public void deleteInvoiceButton() {
        int invoiceIndex = Frame.getInvoiceTableJTableLeftSide().getSelectedRow();
        InvoiceHeader header = Frame.getInvoiceHeaderJTableModel().getInvoicesHeaderList().get(invoiceIndex);
        Frame.getInvoiceHeaderJTableModel().getInvoicesHeaderList().remove(invoiceIndex);
        Frame.getInvoiceHeaderJTableModel().fireTableDataChanged();
        Frame.setInvoiceLineJTableModel(new InvoiceLineJTableModel(new ArrayList<InvoiceLine>()));
        Frame.getInvoiceItemJTableRightSide().setModel(Frame.getInvoiceLineJTableModel());
        Frame.getInvoiceLineJTableModel().fireTableDataChanged();
        Frame.getCustomerNameJTextField().setText("");
        Frame.getInvoiceDateJTextField().setText("");
        Frame.getInvoiceNumberJLabel().setText("");
        Frame.getInvoiceTotalJLabel().setText("");
    }


    public void okButtonNewLineInDialog() {

        int itemNumber = InvoiceHeaderJTableModel.ItemNumberInt;



        Frame.getInvoiceLineJTableModel().fireTableDataChanged();
        Frame.getInvoiceHeaderJTableModel().fireTableDataChanged();
        displayInvoices();
    }



    public void cancelButton() {
        int lineIndex = Frame.getInvoiceItemJTableRightSide().getSelectedRow();
        InvoiceLine line = Frame.getInvoiceLineJTableModel().getInvoicesLinesList().get(lineIndex);
        Frame.getInvoiceLineJTableModel().getInvoicesLinesList().remove(lineIndex);
        Frame.getInvoiceLineJTableModel().fireTableDataChanged();
        Frame.getInvoiceHeaderJTableModel().fireTableDataChanged();
        Frame.getInvoiceTotalJLabel().setText("" + line.getInvoiceHeader().getInvoiceTotal());
    }
}
