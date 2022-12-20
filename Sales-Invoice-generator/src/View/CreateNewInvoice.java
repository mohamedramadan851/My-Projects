
package View;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CreateNewInvoice extends JDialog {

    private JLabel customerNameJLabel;
    private JTextField customerNameJTextField;

    private JLabel invoiceDateJLabel;
    private JTextField invoiceDateJTextField;

    private JButton insertJButton;
    private JButton cancelJButton;

    public CreateNewInvoice(MyFrame frame) {

        setTitle("Create New Invoice");
        setLocation(300, 300);
        
        customerNameJLabel = new JLabel("Customer Name");
        customerNameJTextField = new JTextField(15);

        invoiceDateJLabel = new JLabel("Invoice Date");
        invoiceDateJTextField = new JTextField(15);

        insertJButton = new JButton("Insert");
        insertJButton.setActionCommand("InsertButtonInDialog");
        insertJButton.addActionListener(frame.getListener());

        cancelJButton = new JButton("Cancel");
        cancelJButton.setActionCommand("CancelButtonInDialog");
        cancelJButton.addActionListener(frame.getListener());

        setLayout(new GridLayout(3, 2, 15, 15));

        add(customerNameJLabel);
        add(customerNameJTextField);

        add(invoiceDateJLabel);
        add(invoiceDateJTextField);

        add(insertJButton);
        add(cancelJButton);

        pack();
    }

    public JTextField getCustomerNameJTextField() {return customerNameJTextField;}

    public JTextField getInvoiceDateJTextField() {return invoiceDateJTextField;}
}
