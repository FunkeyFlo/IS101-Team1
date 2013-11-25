package view.employee;

import connectivity.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import main.Session;

/**
 *
 * @author Team AwesomeSauce
 */
public class ChangeCustomer extends javax.swing.JFrame {
    
    private Luggage luggageModel = new Luggage();
    private List<Luggage> luggages;
    private DefaultTableModel modelLuggage;
    private Customer customer = new Customer();
    private User user = new User();

    public ChangeCustomer() {
        customer.getCustomerData(Session.storedCustomerId, "customer_id");
        user.getUserData(customer.getLastChangedBy());
        
        String[] email = seperateString(customer.getEmail(), "@");
        String[] address = seperateString(customer.getAddress(), " ");

        initComponents();

        tfAddress1.setText(address[0]);
        tfAddress2.setText(address[1]);
        tfFirstName.setText(customer.getFirstName());
        tfLastName.setText(customer.getLastName());
        tfPostalCode.setText(customer.getPostalCode());
        tfCity.setText(customer.getCity());
        cbCountry.setSelectedItem(customer.getCountry());
        tfEmail1.setText(email[0]);
        tfEmail2.setText(email[1]);
        tfPhoneHome.setText(customer.getPhoneHome());
        tfPhoneMobile.setText(customer.getPhoneMobile());
        
        tfAddress1.setEditable(false);
        tfAddress2.setEditable(false);
        tfFirstName.setEditable(false);
        tfLastName.setEditable(false);
        tfPostalCode.setEditable(false);
        tfCity.setEditable(false);
        cbCountry.setEditable(false);
        tfEmail1.setEditable(false);
        tfEmail2.setEditable(false);
        tfPhoneHome.setEditable(false);
        tfPhoneMobile.setEditable(false);
        
        modelLuggage = (DefaultTableModel) this.luggageTable.getModel();
        searchLuggage(11, Integer.toString(customer.getCustomerId()), 0);
    }
    
    private void searchLuggage(int dbField, String searchArg, int showHandled) {
        luggages = luggageModel.searchLuggageList(dbField, searchArg, showHandled);
        for(Luggage luggage : luggages) {
            modelLuggage.addRow(new Object[] {new Integer(luggage.getLuggageId()),
                luggage.getCustomerId(),
                luggage.getDescription(),
                luggage.getLocation(),
                luggage.getDateLost(),
                luggage.getStatus()});
        }
    }
    
    public String[] seperateString(String itemToSeperate, String sepChar) {
        String[] seperatedItems = {"", ""};

        String[] temp = itemToSeperate.split(sepChar);


        for (int i = 0; i < temp.length-1; i++) {
            seperatedItems[0] += (temp[i] + " ");
        }

        seperatedItems[1] = temp[temp.length-1];

        return seperatedItems;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerRegistrationPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfAddress2 = new javax.swing.JTextField();
        tfAddress1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfFirstName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfLastName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfEmail1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfEmail2 = new javax.swing.JTextField();
        tfPhoneHome = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfPhoneMobile = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btEditCustomer = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfCity = new javax.swing.JTextField();
        cbCountry = new javax.swing.JComboBox();
        warningLabel1 = new javax.swing.JLabel();
        tfPostalCode = new javax.swing.JTextField();
        editInfoLabel = new javax.swing.JLabel();
        chbUnlockFields = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        luggageTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gegevens van " + customer.getFirstName() + " " + customer.getLastName());
        setResizable(false);

        customerRegistrationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Klant gegevens aanpassen"));

        jLabel7.setText("Adres");

        tfAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAddress2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Postcode");

        tfFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFirstNameActionPerformed(evt);
            }
        });

        jLabel13.setText("Voornaam");

        jLabel14.setText("Achternaam");

        jLabel15.setText("E-mail");

        jLabel16.setText("@");

        tfEmail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmail2ActionPerformed(evt);
            }
        });

        jLabel17.setText("Huis telefoon");

        jLabel18.setText("Mobiel tel.");

        btEditCustomer.setText("Aanpassen");
        btEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditCustomerActionPerformed(evt);
            }
        });

        jButton4.setText("Annuleren");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel19.setText("Stad");

        jLabel20.setText("Land");

        cbCountry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nederland", "Turkije", "Australië" }));
        cbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountryActionPerformed(evt);
            }
        });

        warningLabel1.setForeground(new java.awt.Color(255, 0, 0));

        editInfoLabel.setForeground(new java.awt.Color(102, 102, 102));
        editInfoLabel.setText("Gegevens laatst gewijzigd door " + user.getFirstName() + " " + user.getLastName() + " op " + customer.getDateChanged().substring(0, customer.getDateChanged().length()-5));

        chbUnlockFields.setText("Velden ontgrendelen");
        chbUnlockFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbUnlockFieldsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerRegistrationPanelLayout = new javax.swing.GroupLayout(customerRegistrationPanel);
        customerRegistrationPanel.setLayout(customerRegistrationPanelLayout);
        customerRegistrationPanelLayout.setHorizontalGroup(
            customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(warningLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerRegistrationPanelLayout.createSequentialGroup()
                        .addComponent(chbUnlockFields)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditCustomer))
                    .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                        .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(3, 3, 3)
                                .addComponent(tfEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfPhoneHome, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(tfPhoneMobile))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                        .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addGap(39, 39, 39)
                        .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLastName)
                            .addComponent(tfFirstName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfAddress1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customerRegistrationPanelLayout.createSequentialGroup()
                                        .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tfCity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(tfPostalCode, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 173, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        customerRegistrationPanelLayout.setVerticalGroup(
            customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                        .addComponent(tfPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16))
                    .addComponent(tfEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(tfPhoneHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPhoneMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditCustomer)
                    .addComponent(jButton4)
                    .addComponent(chbUnlockFields))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opties"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bagage van " + customer.getFirstName() + " " + customer.getLastName()));

        luggageTable.setAutoCreateRowSorter(true);
        luggageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bagage ID", "Klant ID", "Omschrijving", "Locatie", "Datum Vermist", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        luggageTable.setVerifyInputWhenFocusTarget(false);
        jScrollPane7.setViewportView(luggageTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerRegistrationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerRegistrationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAddress2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAddress2ActionPerformed

    private void tfFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFirstNameActionPerformed

    private void tfEmail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmail2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmail2ActionPerformed

    private void btEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditCustomerActionPerformed
        customer.updateCustomer(tfFirstName.getText().trim(), tfLastName.getText().trim(),
        tfAddress1.getText().trim() + " " + tfAddress2.getText().trim(),
        tfPostalCode.getText().trim(), tfCity.getText().trim(),
        cbCountry.getSelectedItem().toString(), tfEmail1.getText() + "@"
        + tfEmail2.getText(), tfPhoneHome.getText().trim(),
        tfPhoneMobile.getText().trim());
    }//GEN-LAST:event_btEditCustomerActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCountryActionPerformed

    private void chbUnlockFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbUnlockFieldsActionPerformed
        tfAddress1.setEditable(chbUnlockFields.isSelected());
        tfAddress2.setEditable(chbUnlockFields.isSelected());
        tfEmail1.setEditable(chbUnlockFields.isSelected());
        tfEmail2.setEditable(chbUnlockFields.isSelected());
        tfPostalCode.setEditable(chbUnlockFields.isSelected());
        tfCity.setEditable(chbUnlockFields.isSelected());
        cbCountry.setEditable(chbUnlockFields.isSelected());
        tfPhoneHome.setEditable(chbUnlockFields.isSelected());
        tfPhoneMobile.setEditable(chbUnlockFields.isSelected());
        tfFirstName.setEditable(chbUnlockFields.isSelected());
        tfLastName.setEditable(chbUnlockFields.isSelected());        
    }//GEN-LAST:event_chbUnlockFieldsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditCustomer;
    private javax.swing.JComboBox cbCountry;
    private javax.swing.JCheckBox chbUnlockFields;
    private javax.swing.JPanel customerRegistrationPanel;
    private javax.swing.JLabel editInfoLabel;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable luggageTable;
    private javax.swing.JTextField tfAddress1;
    private javax.swing.JTextField tfAddress2;
    private javax.swing.JTextField tfCity;
    private javax.swing.JTextField tfEmail1;
    private javax.swing.JTextField tfEmail2;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfPhoneHome;
    private javax.swing.JTextField tfPhoneMobile;
    private javax.swing.JTextField tfPostalCode;
    private javax.swing.JLabel warningLabel1;
    // End of variables declaration//GEN-END:variables
}