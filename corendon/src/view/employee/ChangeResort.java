/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.employee;

import connectivity.DatabaseManager;
import connectivity.QueryManager;
import java.awt.Component;
import java.awt.Frame;
import java.awt.TextField;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ResourceBundle;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import main.Session;
import model.Luggage;
import model.Resort;
import model.User;

/**
 *
 * @author mark
 */
public class ChangeResort extends javax.swing.JFrame {

    private Resort resort = new Resort();
    private final QueryManager query = new QueryManager();
    private final ResourceBundle BUNDLE = ResourceBundle.getBundle("languages.ResourceBundle"); //, locale
    private Component errorPopUp, confirmationPopUp;
    private String[] resortEmail;

    public ChangeResort() {

        resort = query.getResortData(Session.storedResortId, "resort_id");
        resortEmail = seperateString(resort.getEmail(), "@");

        initComponents();

        tfResortAddress.setText(resort.getAddress());
        tfResortCity.setText(resort.getCity());
        tfResortCountry.setText(resort.getCountry());
        tfResortName.setText(resort.getName());
        tfResortPhone.setText(resort.getPhone());
        tfResortPostalCode.setText(resort.getPostalCode());
        tfResortEmail1.setText(resortEmail[0]);
        tfResortEmail2.setText(resortEmail[1]);

        tfResortEmail1.setEditable(false);
        tfResortEmail2.setEditable(false);
        tfResortAddress.setEditable(false);
        tfResortCity.setEditable(false);
        tfResortCountry.setEditable(false);
        tfResortName.setEditable(false);
        tfResortPhone.setEditable(false);
        tfResortPostalCode.setEditable(false);

    }

    private void errorPopUp(String errorMessage) {
        JOptionPane.showMessageDialog(errorPopUp, errorMessage);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfResortCountry = new javax.swing.JTextField();
        tfResortEmail1 = new javax.swing.JTextField();
        tfResortName = new javax.swing.JTextField();
        tfResortEmail2 = new javax.swing.JTextField();
        tfResortPhone = new javax.swing.JTextField();
        tfResortCity = new javax.swing.JTextField();
        tfResortAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfResortPostalCode = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        chbUnlockFields = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText(BUNDLE.getString("phoneNumber"));

        jLabel2.setText(BUNDLE.getString("email"));

        jLabel3.setText(BUNDLE.getString("country"));

        jLabel4.setText(BUNDLE.getString("address"));

        jLabel5.setText(BUNDLE.getString("city"));

        jLabel6.setText(BUNDLE.getString("name"));

        jLabel7.setText("@");

        jButton1.setText(BUNDLE.getString("cancel"));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(BUNDLE.getString("adjust"));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText(BUNDLE.getString("postalCode"));

        chbUnlockFields.setText(BUNDLE.getString("unlockFields"));
        chbUnlockFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbUnlockFieldsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chbUnlockFields)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfResortPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfResortEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfResortEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfResortPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfResortCity)
                                        .addComponent(tfResortCountry)
                                        .addComponent(tfResortAddress)
                                        .addComponent(tfResortName, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 67, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(tfResortAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfResortCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfResortCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfResortName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfResortPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfResortPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfResortEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfResortEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(chbUnlockFields))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String resortName = tfResortName.getText();
        String resortAddress = tfResortAddress.getText();
        String resortCountry = tfResortCountry.getText();
        String resortPostalCode = tfResortPostalCode.getText();
        String resortCity = tfResortCity.getText();
        String resortEmail = tfResortEmail1.getText() + "@" + tfResortEmail2.getText();
        String resortPhone = tfResortPhone.getText();
        String[] resortConfirmMsg = BUNDLE.getStringArray("changeResortConfirm");
        boolean finalCheck = false;
        boolean [] correctInput = new boolean[7];
        
        if(resortName.equals("")){
            errorPopUp(BUNDLE.getString("enterResortName"));
            correctInput[0] = false;
        }
        else if(resortName.length() > 50){
            errorPopUp(BUNDLE.getString("nameTooLong"));
            correctInput[0] = false;
        }
        else
            correctInput[0] = true;
        
        if(resortAddress.equals("")){
            errorPopUp(BUNDLE.getString("enterAddress"));
            correctInput[1] = false;
        }
        else if(resortAddress.length() > 75){
            errorPopUp(BUNDLE.getString("addressTooLong"));
            correctInput[1] = false;
        }
        else
            correctInput[1] = true;
        
        if(resortCountry.equals("")){
            errorPopUp(BUNDLE.getString("enterCountry"));
            correctInput[2] = false;
        }
        else if(resortCountry.length() > 45){
            errorPopUp(BUNDLE.getString("countryTooLong"));
            correctInput[2] = false;
        }
        else
            correctInput[2] = true;
        
        if(resortPostalCode.length() > 45){
            errorPopUp(BUNDLE.getString("postalCodeTooLong"));
            correctInput[3] = false;
        }
        else
            correctInput[3] = true;
        
        if(resortCity.equals("")){
            errorPopUp(BUNDLE.getString("enterResortCity"));
            correctInput[4] = false;
        }
        else if(resortCity.length() > 45){
            errorPopUp(BUNDLE.getString("cityTooLong"));
            correctInput[4] = false;
        }
        else
            correctInput[4] = true;
        
        if(resortEmail.length() > 100){
            errorPopUp(BUNDLE.getString("emailTooLong"));
            correctInput[5] = false;
        }
        else
            correctInput[5] = true;
        
        if(resortPhone.equals("")){
            errorPopUp(BUNDLE.getString("enterResortPhone"));
            correctInput[6] = false;
        }
        else if(resortPhone.length() > 20){
            errorPopUp(BUNDLE.getString("phoneTooLong"));
            correctInput[6] = false;
        }
        else
            correctInput[6] = true;
        
        
        if(correctInput.toString().contains("true")){
        finalCheck = confirmationPopUp(resortConfirmMsg[0] + "\n"
                + resortConfirmMsg[1] + resortName + "\n" + resortConfirmMsg[2] 
                + resortAddress + "\n" + resortConfirmMsg[3] + resortCountry
                + "\n" + resortConfirmMsg[4] + resortPostalCode + "\n"
                + resortConfirmMsg[5] + resortCity + "\n" + "\n" 
                + resortConfirmMsg[6] + resortEmail + "\n" + resortConfirmMsg[7] 
                + resortPhone);

        if (finalCheck == true) {
            query.updateResort(resort.getId(),
                    tfResortName.getText(),
                    tfResortAddress.getText(),
                    tfResortCountry.getText(),
                    tfResortCity.getText(),
                    tfResortPhone.getText(),
                    tfResortEmail1.getText() + "@" + tfResortEmail2.getText(),
                    tfResortPostalCode.getText());
        
            dispose();
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean confirmationPopUp(String message) {
        boolean confirm = false;
        final JOptionPane createUserPopPane = new JOptionPane(message,
                JOptionPane.WARNING_MESSAGE,
                JOptionPane.YES_NO_OPTION);
        final JDialog dialog = new JDialog((Frame) confirmationPopUp,
                BUNDLE.getString("pressButton"), true);
        dialog.setContentPane(createUserPopPane);
        createUserPopPane.addPropertyChangeListener(
                new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent e) {
                        String prop = e.getPropertyName();

                        if (dialog.isVisible()
                        && (e.getSource() == createUserPopPane)
                        && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                            dialog.setVisible(false);
                        }
                    }
                });
        dialog.pack();
        dialog.setVisible(true);
        int value = ((Integer) createUserPopPane.getValue()).intValue();
        if (value == JOptionPane.YES_OPTION) {
            confirm = true;
        }
        return confirm;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chbUnlockFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbUnlockFieldsActionPerformed
        tfResortEmail1.setEditable(chbUnlockFields.isSelected());
        tfResortEmail2.setEditable(chbUnlockFields.isSelected());
        tfResortAddress.setEditable(chbUnlockFields.isSelected());
        tfResortCity.setEditable(chbUnlockFields.isSelected());
        tfResortCountry.setEditable(chbUnlockFields.isSelected());
        tfResortName.setEditable(chbUnlockFields.isSelected());
        tfResortPhone.setEditable(chbUnlockFields.isSelected());
        tfResortPostalCode.setEditable(chbUnlockFields.isSelected());
    }//GEN-LAST:event_chbUnlockFieldsActionPerformed

    public String[] seperateString(String itemToSeperate, String sepChar) {
        String[] seperatedItems = {"", ""};
        if (itemToSeperate == null) {
            return seperatedItems;
        } else {

            String[] temp = itemToSeperate.split(sepChar);

            for (int i = 0; i < temp.length - 1; i++) {
                seperatedItems[0] += (temp[i] + " ");
            }

            seperatedItems[1] = temp[temp.length - 1];

            return seperatedItems;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chbUnlockFields;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tfResortAddress;
    private javax.swing.JTextField tfResortCity;
    private javax.swing.JTextField tfResortCountry;
    private javax.swing.JTextField tfResortEmail1;
    private javax.swing.JTextField tfResortEmail2;
    private javax.swing.JTextField tfResortName;
    private javax.swing.JTextField tfResortPhone;
    private javax.swing.JTextField tfResortPostalCode;
    // End of variables declaration//GEN-END:variables
}
