
package Controller;

import Model.InvoiceHeader;
import Model.InvoiceLine;
import Model.InvoiceLineJTableModel;
import View.MyFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ImplementsListener implements ActionListener ,  ListSelectionListener{

    private final MyFrame Frame;
    private final DateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");

    AllButtonsActionListeners buttonsActionListeners;
    LoadFileActionListener loadFileMenuBarActionListener;
    SaveFileMenuBarActionListener saveFileMenuBarActionListener;

    public ImplementsListener(MyFrame frame) {
        this.Frame = frame;
        this.buttonsActionListeners = new AllButtonsActionListeners(frame);
        this.loadFileMenuBarActionListener = new LoadFileActionListener(frame);
        this.saveFileMenuBarActionListener = new SaveFileMenuBarActionListener(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "LoadFile" -> loadFileMenuBarActionListener.loadFileMenuBar();
            case "SaveFile" -> saveFileMenuBarActionListener.saveFileMenuBar();
            case "CreateNewInvoiceButton" -> buttonsActionListeners.displayNewInvoiceDialog();
            case "DeleteInvoiceButton" -> buttonsActionListeners.deleteInvoiceButton();
            case "CancelButton" -> buttonsActionListeners.cancelButton();
            case "InsertButtonInDialog" -> buttonsActionListeners.insertButtonInDialog();
            case "CancelButtonInDialog" -> buttonsActionListeners.cancelButtonInDialog();
            case "createLineOK" -> buttonsActionListeners.okButtonNewLineInDialog();
            default -> throw new AssertionError();
        }
    }

    private void rowSelected_InvoiceTable() {
        
        int selectedRowIndex_InvoiceTable = Frame.getInvoiceTableJTableLeftSide().getSelectedRow();
        
        if (selectedRowIndex_InvoiceTable >= 0) {
            

            InvoiceHeader row = Frame.getInvoiceHeaderJTableModel().getInvoicesHeaderList().get(selectedRowIndex_InvoiceTable);
            Frame.getCustomerNameJTextField().setText(row.getCustomerName());
            Frame.getInvoiceDateJTextField().setText(DateFormat.format(row.getInvoiceDate()));
            Frame.getInvoiceNumberJLabel().setText("" + row.getInvoiceNumber());
            Frame.getInvoiceTotalJLabel().setText("" + row.getInvoiceTotal());
            ArrayList<InvoiceLine> lines = row.getInvoiceLines();


            Frame.setInvoiceLineJTableModel(new InvoiceLineJTableModel(lines));
            Frame.getInvoiceItemJTableRightSide().setModel(Frame.getInvoiceLineJTableModel());
            Frame.getInvoiceLineJTableModel().fireTableDataChanged();
        }
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        rowSelected_InvoiceTable();
    }
}
