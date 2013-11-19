package view.popUps;

import connectivity.*;
import main.Session;

/**
 *
 * @author Viktor
 */
public class ChangeCustomer extends javax.swing.JFrame {

    Customer customer = new Customer();

    public ChangeCustomer() {
        customer.getCustomerData(Session.storedCustomerId, "customer_id");
        
        String email = customer.getEmail();   
        String[] result = email.split("@");
        String emailName = result[0];
        String emailDomain = result[1];
        
        String[] postalCode = seperateString(customer.getPostalCode());
        String[] address = seperateString(customer.getAddress());
        
        
        initComponents();
        
        tfAddress1.setText(address[0]);
        tfAddress2.setText(address[1]);
        tfFirstName.setText(customer.getFirstName());
        tfLastName.setText(customer.getLastName());
        tfPostalCode1.setText(postalCode[0]);
        tfPostalCode2.setText(postalCode[1]);
        tfCity.setText(customer.getCity());
        cbCountry.setSelectedItem(customer.getCountry());
        tfEmail1.setText(emailName);
        tfEmail2.setText(emailDomain);
        tfPhoneHome.setText(customer.getPhoneHome());
        tfPhoneMobile.setText(customer.getPhoneMobile());
        
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
        tfPostalCode2 = new javax.swing.JTextField();
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
        changeCustomer = new javax.swing.JButton();
        cancelChangeCustomer = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfCity = new javax.swing.JTextField();
        cbCountry = new javax.swing.JComboBox();
        warningLabel1 = new javax.swing.JLabel();
        tfPostalCode1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        customerRegistrationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Klant Registreren"));

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

        changeCustomer.setText("Aanpassen");
        changeCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeCustomerActionPerformed(evt);
            }
        });

        cancelChangeCustomer.setText("Annuleren");
        cancelChangeCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelChangeCustomerActionPerformed(evt);
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

        javax.swing.GroupLayout customerRegistrationPanelLayout = new javax.swing.GroupLayout(customerRegistrationPanel);
        customerRegistrationPanel.setLayout(customerRegistrationPanelLayout);
        customerRegistrationPanelLayout.setHorizontalGroup(
            customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warningLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerRegistrationPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelChangeCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeCustomer))
                    .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                        .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEmail2))
                            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfPhoneHome, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
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
                                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                                        .addComponent(tfAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCity, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                                        .addComponent(tfPostalCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPostalCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 27, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        customerRegistrationPanelLayout.setVerticalGroup(
            customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                .addContainerGap()
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
                        .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPostalCode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPostalCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel15))
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
                .addComponent(warningLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeCustomer)
                    .addComponent(cancelChangeCustomer))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(customerRegistrationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(26, 26, 26)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(customerRegistrationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void changeCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeCustomerActionPerformed

    }//GEN-LAST:event_changeCustomerActionPerformed

    private void cancelChangeCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelChangeCustomerActionPerformed
        dispose();
    }//GEN-LAST:event_cancelChangeCustomerActionPerformed

    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCountryActionPerformed
    
    public String[] seperateString(String itemToSeperate){
        String[] seperatedItems = {"", ""};
        
        String[] temp = itemToSeperate.split(" ");
        
        
        for (int i = 0; i < temp.length-1; i++) {
            seperatedItems[0] += (temp[i] + " ");
        }
        
        seperatedItems[1] = temp[temp.length-1];
       
        
        return seperatedItems;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangeCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeCustomer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelChangeCustomer;
    private javax.swing.JComboBox cbCountry;
    private javax.swing.JButton changeCustomer;
    private javax.swing.JPanel customerRegistrationPanel;
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
    private javax.swing.JTextField tfAddress1;
    private javax.swing.JTextField tfAddress2;
    private javax.swing.JTextField tfCity;
    private javax.swing.JTextField tfEmail1;
    private javax.swing.JTextField tfEmail2;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfPhoneHome;
    private javax.swing.JTextField tfPhoneMobile;
    private javax.swing.JTextField tfPostalCode1;
    private javax.swing.JTextField tfPostalCode2;
    private javax.swing.JLabel warningLabel1;
    // End of variables declaration//GEN-END:variables
}
