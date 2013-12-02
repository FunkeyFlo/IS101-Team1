package view.employee;

import connectivity.*;
import java.awt.Component;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import main.Session;

/**
 *
 * @author Team AwesomeSauce
 */
public class ChangeLuggage extends javax.swing.JFrame {

    private Component ErrorPopUp;
    private Component confirmationPopUp;
    private Luggage luggage = new Luggage();
    private User user = new User();

    public ChangeLuggage() {
        luggage.getLuggageData(Session.storedLuggageId, "luggage_id");
        user.getUserDataInt(luggage.getLastChangedBy());

        initComponents();
        tfDescription.setText(luggage.getDescription());
        tfLocation.setText(luggage.getLocation());
        cbStatus.setSelectedIndex(luggage.getStatus()-1);
        
        tfDescription.setEditable(false);
        tfLocation.setEditable(false);
        
        //ER MOET NOG WAT KOMEN VOOR rbDone en rbStatus
    }

    private void errorPopUp(String errorMessage) {
        JOptionPane.showMessageDialog(ErrorPopUp, errorMessage);
    }

    /**
    * A pop up with an error message.
    * @param message the message it should show. 
    * @return  returns a boolean to see if the error should pop up.
    */
    private boolean confirmationPopUp(String message) {
        boolean confirm = false;
        final JOptionPane createUserPopPane = new JOptionPane(message,
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION);
        final JDialog dialog = new JDialog((Frame) confirmationPopUp, "Druk op een knop", true);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        luggageRegistrationPanel = new javax.swing.JLayeredPane();
        lblCustomerID5 = new javax.swing.JLabel();
        lblCustomerID6 = new javax.swing.JLabel();
        tfLocation = new javax.swing.JTextField();
        lblCustomerID7 = new javax.swing.JLabel();
        btUpdateLuggage = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfDescription = new javax.swing.JTextArea();
        editLuggageInfo = new javax.swing.JLabel();
        chbUnlockFields = new javax.swing.JCheckBox();
        cbStatus = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gegevens van baggage artikel: " + luggage.getLuggageId());

        luggageRegistrationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Bagage Registeren"));

        lblCustomerID5.setText("Omschrijving");

        lblCustomerID6.setText("Locatie");

        tfLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLocationActionPerformed(evt);
            }
        });

        lblCustomerID7.setText("Status");

        btUpdateLuggage.setText("Aanpassen");
        btUpdateLuggage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateLuggageActionPerformed(evt);
            }
        });

        btCancel.setText("Annuleren");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        tfDescription.setColumns(20);
        tfDescription.setRows(5);
        jScrollPane2.setViewportView(tfDescription);

        editLuggageInfo.setForeground(new java.awt.Color(102, 102, 102));
        editLuggageInfo.setText("Laatst gewijzigd door " + user.getFirstName() + " " + user.getLastName() + " op " + luggage.getDateChanged().substring(0, luggage.getDateChanged().length()-5));

        chbUnlockFields.setText("Velden ontgrendelen");
        chbUnlockFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbUnlockFieldsActionPerformed(evt);
            }
        });

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vermist", "Gevonden", "Afgehandeld" }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout luggageRegistrationPanelLayout = new javax.swing.GroupLayout(luggageRegistrationPanel);
        luggageRegistrationPanel.setLayout(luggageRegistrationPanelLayout);
        luggageRegistrationPanelLayout.setHorizontalGroup(
            luggageRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(luggageRegistrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(luggageRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editLuggageInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(luggageRegistrationPanelLayout.createSequentialGroup()
                        .addComponent(chbUnlockFields)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btUpdateLuggage))
                    .addGroup(luggageRegistrationPanelLayout.createSequentialGroup()
                        .addGroup(luggageRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustomerID5)
                            .addComponent(lblCustomerID6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCustomerID7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(luggageRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                            .addGroup(luggageRegistrationPanelLayout.createSequentialGroup()
                                .addGroup(luggageRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        luggageRegistrationPanelLayout.setVerticalGroup(
            luggageRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(luggageRegistrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editLuggageInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(luggageRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(luggageRegistrationPanelLayout.createSequentialGroup()
                        .addComponent(lblCustomerID5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(luggageRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerID6)
                    .addComponent(tfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(luggageRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerID7)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(luggageRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btUpdateLuggage)
                    .addComponent(btCancel)
                    .addComponent(chbUnlockFields))
                .addContainerGap())
        );
        luggageRegistrationPanel.setLayer(lblCustomerID5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        luggageRegistrationPanel.setLayer(lblCustomerID6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        luggageRegistrationPanel.setLayer(tfLocation, javax.swing.JLayeredPane.DEFAULT_LAYER);
        luggageRegistrationPanel.setLayer(lblCustomerID7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        luggageRegistrationPanel.setLayer(btUpdateLuggage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        luggageRegistrationPanel.setLayer(btCancel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        luggageRegistrationPanel.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        luggageRegistrationPanel.setLayer(editLuggageInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        luggageRegistrationPanel.setLayer(chbUnlockFields, javax.swing.JLayeredPane.DEFAULT_LAYER);
        luggageRegistrationPanel.setLayer(cbStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(luggageRegistrationPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(luggageRegistrationPanel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLocationActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    /**
     * Updates Luggage with the textfieldinputs. 
     * Its also uses error handling showing message when input is incorrect. 
     * @param evt 
     */
    private void btUpdateLuggageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateLuggageActionPerformed
        boolean correctInput[] = new boolean[2];
        boolean totalCorrectInput = false;
        boolean finalCheck = false;
        
        String description = tfDescription.getText();
        String location = tfLocation.getText();
        
        if (description.equals("")) {
            errorPopUp("Vul een omschrijving in en probeer het nog eens.");
            correctInput[0] = false;
        } else if (description.length() > 200) {
            errorPopUp("Het karakterlimiet voor de omschrijving is overschreden.");
            correctInput[0] = false;
        } else {
            correctInput[0] = true;
        }

        if (location.equals("")) {
            errorPopUp("Vul een locatie in en probeer het nog eens.");
            correctInput[1] = false;
        } else if (location.length() > 50) {
            errorPopUp("Het karakterlimiet voor de locatie is overschreden.");
            correctInput[0] = false;
        } else {
            correctInput[1] = true;
        }

        for (int counter = 0; counter < correctInput.length; counter++) {
            if (correctInput[counter] == false) {
                totalCorrectInput = false;
            } else {
                totalCorrectInput = true;
            }
        }
        
        if (totalCorrectInput == true) {

            finalCheck = confirmationPopUp("Nieuwe baggagegegevens:" + "\n" + "Omschrinving: " + description + "\n"
                    + "Locatie: " + location);
        }
        
        if (finalCheck == true) {
            luggage.updateLuggage(luggage.getLuggageId(),
                    tfDescription.getText().trim(),
                    tfLocation.getText().trim(),
                    cbStatus.getSelectedIndex()+1);
        }
        dispose();
    }//GEN-LAST:event_btUpdateLuggageActionPerformed

    private void chbUnlockFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbUnlockFieldsActionPerformed
        tfDescription.setEditable(chbUnlockFields.isSelected());
        tfLocation.setEditable(chbUnlockFields.isSelected());
    }//GEN-LAST:event_chbUnlockFieldsActionPerformed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btUpdateLuggage;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JCheckBox chbUnlockFields;
    private javax.swing.JLabel editLuggageInfo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCustomerID5;
    private javax.swing.JLabel lblCustomerID6;
    private javax.swing.JLabel lblCustomerID7;
    private javax.swing.JLayeredPane luggageRegistrationPanel;
    private javax.swing.JTextArea tfDescription;
    private javax.swing.JTextField tfLocation;
    // End of variables declaration//GEN-END:variables
}
