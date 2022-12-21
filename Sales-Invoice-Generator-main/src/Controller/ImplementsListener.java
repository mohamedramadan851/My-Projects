
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


public class ImplementsListener implements ActionListener, ListSelectionListener {

    private final MyFrame frame;
    private final DateFormat  dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    AllButtonsActionListeners buttonsActionListeners;
    LoadFileMenuBarActionListener loadFileMenuBarActionListner;
    SaveFileMenuBarActionListener saveFileMenuBarActionListner;
    CloseFileActionListener closeFileMenuBarActionListener;
    
    
    public ImplementsListener(MyFrame frame) {
        this.frame = frame;
        this.buttonsActionListeners = new AllButtonsActionListeners(frame);
        this.loadFileMenuBarActionListner = new LoadFileMenuBarActionListener(frame);
        this.saveFileMenuBarActionListner = new SaveFileMenuBarActionListener(frame);
        this.closeFileMenuBarActionListener = new CloseFileActionListener(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "LoadFile" -> loadFileMenuBarActionListner.loadFileMenuBar();
            case "SaveFile" -> saveFileMenuBarActionListner.saveFileMenuBar();
            case "CloseFile" -> closeFileMenuBarActionListener.closeFileMenuBar();
            case "CreateNewInvoiceButton" -> buttonsActionListeners.displayNewInvoiceDialog();
            case "DeleteInvoiceButton" -> buttonsActionListeners.deleteInvoiceButton();
            case "SaveButton" -> buttonsActionListeners.displaySaveButtonNewLineDialog();
            case "CancelButton" -> buttonsActionListeners.cancelButton();
            case "InsertButtonInDialog" -> buttonsActionListeners.insertButtonInDialog();
            case "CancelButtonInDialog" -> buttonsActionListeners.cancelButtonInDialog();
            case "createLineOK" -> buttonsActionListeners.okButtonNewLineInDialog();
            case "createLineCancel" -> buttonsActionListeners.cancelButtonNewLineInDialog();
            default -> throw new AssertionError();
        }
    }

    private void rowSelected_InvoiceTable() {
        
        int selectedRowIndex_InvoiceTable = frame.getInvoiceTableJTableLeftSide().getSelectedRow();
        
        if (selectedRowIndex_InvoiceTable >= 0) {
            
            InvoiceHeader row = frame.getInvoiceHeaderJTableModel().getInvoicesHeaderList().get(selectedRowIndex_InvoiceTable);
            frame.getCustomerNameJTextField().setText(row.getCustomerName());
            frame.getInvoiceDateJTextField().setText(dateFormat.format(row.getInvoiceDate()));
            frame.getInvoiceNumberJLabel().setText("" + row.getInvoiceNumber());
            frame.getInvoiceTotalJLabel().setText("" + row.getInvoiceTotal());
            ArrayList<InvoiceLine> lines = row.getInvoiceLines();

            frame.setInvoiceLineJTableModel(new InvoiceLineJTableModel(lines));
            frame.getInvoiceItemJTableRightSide().setModel(frame.getInvoiceLineJTableModel());
            frame.getInvoiceLineJTableModel().fireTableDataChanged();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        rowSelected_InvoiceTable();
    }

}
