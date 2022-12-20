package View;

import Controller.ImplementsListener;
import Model.InvoiceHeader;
import Model.InvoiceHeaderJTableModel;
import Model.InvoiceLineJTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class MyFrame extends javax.swing.JFrame {


    public MyFrame() {
        initComponents();
        setLocation(220, 70);
    }


    private void initComponents() {

        LeftSideJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTableJTableLeftSide = new javax.swing.JTable();
        invoiceTableJTableLeftSide.getSelectionModel().addListSelectionListener(listener);
        TopRightSide = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invoiceNumberJLabel = new javax.swing.JLabel();
        invoiceDateJTextField = new javax.swing.JTextField();
        customerNameJTextField = new javax.swing.JTextField();
        invoiceTotalJLabel = new javax.swing.JLabel();
        BottomRightSide = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoiceItemJTableRightSide = new javax.swing.JTable();
        createNewInvoiceButtonLeftSIde = new javax.swing.JButton();
        createNewInvoiceButtonLeftSIde.addActionListener(listener);
        deleteInvoiceButtonLeftSIde = new javax.swing.JButton();
        deleteInvoiceButtonLeftSIde.addActionListener(listener);
        saveButtonRightSIde = new javax.swing.JButton();
        saveButtonRightSIde.addActionListener(listener);
        cancelButtonRightSIde = new javax.swing.JButton();
        cancelButtonRightSIde.addActionListener(listener);
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuBar = new javax.swing.JMenu();
        loadFileMenuBarItem = new javax.swing.JMenuItem();
        loadFileMenuBarItem.addActionListener(listener);
        saveFileMenuBarItem = new javax.swing.JMenuItem();
        saveFileMenuBarItem.addActionListener(listener);
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        closeFileMenuBarItem = new javax.swing.JMenuItem();
        closeFileMenuBarItem.addActionListener(listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LeftSideJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice Table"));

        LeftSideJPanel.setPreferredSize(new java.awt.Dimension(360, 470));
        invoiceTableJTableLeftSide.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoiceTableJTableLeftSide);

        javax.swing.GroupLayout LeftSideJPanelLayout = new javax.swing.GroupLayout(LeftSideJPanel);
        LeftSideJPanel.setLayout(LeftSideJPanelLayout);
        LeftSideJPanelLayout.setHorizontalGroup(
            LeftSideJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(LeftSideJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LeftSideJPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        LeftSideJPanelLayout.setVerticalGroup(
            LeftSideJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
            .addGroup(LeftSideJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftSideJPanelLayout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        TopRightSide.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        invoiceNumberJLabel.setText("0");

        invoiceDateJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceDateJTextFieldActionPerformed(evt);
            }
        });

        customerNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameJTextFieldActionPerformed(evt);
            }
        });

        invoiceTotalJLabel.setText("0.0");

        javax.swing.GroupLayout TopRightSideLayout = new javax.swing.GroupLayout(TopRightSide);
        TopRightSide.setLayout(TopRightSideLayout);
        TopRightSideLayout.setHorizontalGroup(
            TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopRightSideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopRightSideLayout.createSequentialGroup()
                        .addGroup(TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TopRightSideLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(invoiceTotalJLabel)
                                .addContainerGap())
                            .addGroup(TopRightSideLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceDateJTextField)
                                    .addComponent(customerNameJTextField)))))
                    .addGroup(TopRightSideLayout.createSequentialGroup()
                        .addGroup(TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TopRightSideLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(invoiceNumberJLabel))
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        TopRightSideLayout.setVerticalGroup(
            TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopRightSideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(invoiceNumberJLabel))
                .addGap(18, 18, 18)
                .addGroup(TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(invoiceDateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(customerNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TopRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(invoiceTotalJLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BottomRightSide.setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice Items"));
        BottomRightSide.setPreferredSize(new java.awt.Dimension(360, 200));

        InvoiceItemJTableRightSide.setModel(new javax.swing.table.DefaultTableModel(

            new Object [][] {

            },
            new String [] {

            }
        ));


        jScrollPane2.setViewportView(InvoiceItemJTableRightSide);

        javax.swing.GroupLayout BottomRightSideLayout = new javax.swing.GroupLayout(BottomRightSide);
        BottomRightSide.setLayout(BottomRightSideLayout);
        BottomRightSideLayout.setHorizontalGroup(
            BottomRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomRightSideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BottomRightSideLayout.setVerticalGroup(
            BottomRightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomRightSideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        createNewInvoiceButtonLeftSIde.setBackground(new java.awt.Color(210, 202, 202));
        createNewInvoiceButtonLeftSIde.setForeground(new java.awt.Color(10, 10, 10));
        createNewInvoiceButtonLeftSIde.setText("Create New Invoice");
        createNewInvoiceButtonLeftSIde.setActionCommand("CreateNewInvoiceButton");
        createNewInvoiceButtonLeftSIde.setPreferredSize(new java.awt.Dimension(132, 33));
        createNewInvoiceButtonLeftSIde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewInvoiceButtonLeftSIdeActionPerformed(evt);
            }
        });

        deleteInvoiceButtonLeftSIde.setBackground(new java.awt.Color(210, 202, 202));
        deleteInvoiceButtonLeftSIde.setForeground(new java.awt.Color(10, 10, 10));
        deleteInvoiceButtonLeftSIde.setText("Delete Invoice");
        deleteInvoiceButtonLeftSIde.setPreferredSize(new java.awt.Dimension(132, 33));
        deleteInvoiceButtonLeftSIde.setActionCommand("DeleteInvoiceButton");
        deleteInvoiceButtonLeftSIde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoiceButtonLeftSIdeActionPerformed(evt);
            }
        });

        saveButtonRightSIde.setBackground(new java.awt.Color(210, 202, 202));
        saveButtonRightSIde.setForeground(new java.awt.Color(10, 10, 10));
        saveButtonRightSIde.setText("Save");
        saveButtonRightSIde.setPreferredSize(new java.awt.Dimension(132, 33));
        saveButtonRightSIde.setActionCommand("SaveButton");

        cancelButtonRightSIde.setBackground(new java.awt.Color(210, 202, 202));
        cancelButtonRightSIde.setForeground(new java.awt.Color(10, 10, 10));
        cancelButtonRightSIde.setText("Cancel");
        cancelButtonRightSIde.setPreferredSize(new java.awt.Dimension(132, 33));
        cancelButtonRightSIde.setActionCommand("CancelButton");
        cancelButtonRightSIde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonRightSIdeActionPerformed(evt);
            }
        });

        MenuBar.setText("File");

        loadFileMenuBarItem.setActionCommand("LoadFile");
        loadFileMenuBarItem.setText("Load File");
        loadFileMenuBarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileMenuBarItemActionPerformed(evt);
            }
        });
        MenuBar.add(loadFileMenuBarItem);

        saveFileMenuBarItem.setActionCommand("SaveFile");
        saveFileMenuBarItem.setText("Save File");
        saveFileMenuBarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileMenuBarItemActionPerformed(evt);
            }
        });
        MenuBar.add(saveFileMenuBarItem);

        jMenuBar1.add(MenuBar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LeftSideJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TopRightSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BottomRightSide, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(createNewInvoiceButtonLeftSIde, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(deleteInvoiceButtonLeftSIde, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(saveButtonRightSIde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(cancelButtonRightSIde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TopRightSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BottomRightSide, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LeftSideJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createNewInvoiceButtonLeftSIde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteInvoiceButtonLeftSIde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveButtonRightSIde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelButtonRightSIde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void loadFileMenuBarItemActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void saveFileMenuBarItemActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void invoiceDateJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void createNewInvoiceButtonLeftSIdeActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void deleteInvoiceButtonLeftSIdeActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void customerNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void closeFileMenuBarItemActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void cancelButtonRightSIdeActionPerformed(java.awt.event.ActionEvent evt) {

    }


    private javax.swing.JPanel BottomRightSide;
    private javax.swing.JTable InvoiceItemJTableRightSide;
    private javax.swing.JPanel LeftSideJPanel;
    private javax.swing.JMenu MenuBar;
    private javax.swing.JPanel TopRightSide;
    private javax.swing.JButton cancelButtonRightSIde;
    private javax.swing.JMenuItem closeFileMenuBarItem;
    private javax.swing.JButton createNewInvoiceButtonLeftSIde;
    private javax.swing.JTextField customerNameJTextField;
    private javax.swing.JButton deleteInvoiceButtonLeftSIde;
    private javax.swing.JTextField invoiceDateJTextField;
    private javax.swing.JLabel invoiceNumberJLabel;
    private javax.swing.JTable invoiceTableJTableLeftSide;
    private javax.swing.JLabel invoiceTotalJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem loadFileMenuBarItem;
    private javax.swing.JButton saveButtonRightSIde;
    private javax.swing.JMenuItem saveFileMenuBarItem;

    private final List<InvoiceHeader> invoicesHeaderList = new ArrayList<>();
    private InvoiceHeaderJTableModel invoiceHeaderJTableModel;
    private InvoiceLineJTableModel invoiceLineJTableModel;

    private CreateNewInvoice newInvoiceDialog;

    private final ImplementsListener listener = new ImplementsListener(this);

    public void setInvoiceHeaderJTableModel(InvoiceHeaderJTableModel invoiceHeaderJTableModel) {this.invoiceHeaderJTableModel = invoiceHeaderJTableModel;}

    public void setInvoiceLineJTableModel(InvoiceLineJTableModel invoiceLineJTableModel) {this.invoiceLineJTableModel = invoiceLineJTableModel;}

    public void setNewInvoiceDialog(CreateNewInvoice newInvoiceDialog) {this.newInvoiceDialog = newInvoiceDialog;}


    public JPanel getBottomRightSide() {return BottomRightSide;}

    public JTable getInvoiceItemJTableRightSide() {return InvoiceItemJTableRightSide;}

    public JPanel getLeftSideJPanel() {return LeftSideJPanel;}

    public JPanel getTopRightSide() {return TopRightSide;}

    public JButton getCancelButtonRightSIde() {return cancelButtonRightSIde;}

    public JMenuItem getCloseFileMenuBarItem() {return closeFileMenuBarItem;}

    public JButton getCreateNewInvoiceButtonLeftSIde() {return createNewInvoiceButtonLeftSIde;}

    public JTextField getCustomerNameJTextField() {return customerNameJTextField;}

    public JButton getDeleteInvoiceButtonLeftSIde() {return deleteInvoiceButtonLeftSIde;}

    public JTextField getInvoiceDateJTextField() {return invoiceDateJTextField;}

    public JLabel getInvoiceNumberJLabel() {return invoiceNumberJLabel;}

    public JTable getInvoiceTableJTableLeftSide() {return invoiceTableJTableLeftSide;}

    public JLabel getInvoiceTotalJLabel() {return invoiceTotalJLabel;}

    public JMenuItem getLoadFileMenuBarItem() {return loadFileMenuBarItem;}

    public JButton getSaveButtonRightSIde() {return saveButtonRightSIde;}

    public JMenuItem getSaveFileMenuBarItem() {return saveFileMenuBarItem;}

    public List<InvoiceHeader> getInvoicesHeaderList() {return invoicesHeaderList;}

    public InvoiceHeaderJTableModel getInvoiceHeaderJTableModel() {return invoiceHeaderJTableModel;}

    public InvoiceLineJTableModel getInvoiceLineJTableModel() {return invoiceLineJTableModel;}

    public CreateNewInvoice getNewInvoiceDialog() {return newInvoiceDialog;}


    public ImplementsListener getListener() {return listener;}

}
