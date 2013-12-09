/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.administrator;

import connectivity.DatabaseManager;
import connectivity.QueryManager;
import java.awt.Component;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import main.Session;
import model.User;

/**
 *
 * @author Flo
 */
public class ChangeUser extends javax.swing.JFrame {

    private final DatabaseManager db = new DatabaseManager();
    private final User user = new User();
    private final QueryManager query = new QueryManager();
    private Administrator admin = new Administrator();

    private Component succes, deleteUserPopup, createUserPopup, ErrorPopUp;
    public static String nameTypeToChange, accountToChange;

    /**
     * Creates new form ChangeUser
     */
    public ChangeUser() {
        query.getUserData(Session.tempUsername);

        initComponents();

        tfFirstName.setText(user.getFirstName());
        tfLastName.setText(user.getLastName());
        permissionSelector.setSelectedIndex(user.getPermissionId() - 1);

        tfFirstName.setEditable(false);
        tfLastName.setEditable(false);
        permissionSelector.setEditable(false);
    }

    /**
     * doChangeUser updates the users first name and last name.
     */
    private void doChangeUser() {

        String firstName = tfFirstName.getText().trim();
        String lastName = tfLastName.getText().trim();
        int permissionId = permissionSelector.getSelectedIndex() + 1;
        query.updateUser(Session.tempUsername, firstName, lastName, permissionId);
    }

    private boolean createPopUp(String message) {
        boolean createConfirm = false;
        final JOptionPane createUserPopPane = new JOptionPane(message,
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION);
        final JDialog dialog = new JDialog((Frame) createUserPopup,
                "Druk op een knop", true);
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
            createConfirm = true;
        }
        return createConfirm;
    }

    private void errorPopUp(String errorMessage) {
        JOptionPane.showMessageDialog(ErrorPopUp, errorMessage);
    }

    /**
     * Checks if the input is not empty.
     *
     * @return correct output firsts and lastname.
     */
    private boolean errorCheckCreateUser() {
        boolean isError[] = new boolean[2];
        boolean totalCorrectInput = true;
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String empty = "";

        if (firstName.equals(empty)) {
            isError[0] = true;
        } else {
            isError[0] = false;
        }

        if (lastName.equals(empty)) {
            isError[1] = true;
        } else {
            isError[1] = false;
        }

        for (int x = 0; x < isError.length; x++) {
            if (isError[x] == true) {
                totalCorrectInput = false;
            }
        }

        return totalCorrectInput;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userCreationPanel = new javax.swing.JPanel();
        tfFirstName = new javax.swing.JTextField();
        tfLastName = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        permissionLabel = new javax.swing.JLabel();
        permissionSelector = new javax.swing.JComboBox();
        btCancel = new javax.swing.JButton();
        createUser = new javax.swing.JButton();
        chbUnlockFields = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gegevens aanpassen van gebruiker " + Session.tempUsername );

        userCreationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Gebruiker aanmaken"));

        tfFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFirstNameActionPerformed(evt);
            }
        });
        tfFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFirstNameKeyPressed(evt);
            }
        });

        tfLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLastNameActionPerformed(evt);
            }
        });
        tfLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfLastNameKeyPressed(evt);
            }
        });

        firstNameLabel.setText("Voornaam");

        lastNameLabel.setText("Achternaam");

        permissionLabel.setText("Gebruikersgroep");

        permissionSelector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Medewerker", "Manager", "Beheerder" }));
        permissionSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionSelectorActionPerformed(evt);
            }
        });
        permissionSelector.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                permissionSelectorKeyPressed(evt);
            }
        });

        btCancel.setText("Annuleren");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        createUser.setText("Aanpassen");
        createUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserActionPerformed(evt);
            }
        });

        chbUnlockFields.setText("Velden ontgrendelen");
        chbUnlockFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbUnlockFieldsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userCreationPanelLayout = new javax.swing.GroupLayout(userCreationPanel);
        userCreationPanel.setLayout(userCreationPanelLayout);
        userCreationPanelLayout.setHorizontalGroup(
            userCreationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userCreationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userCreationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFirstName)
                    .addComponent(tfLastName)
                    .addGroup(userCreationPanelLayout.createSequentialGroup()
                        .addComponent(chbUnlockFields)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(btCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createUser))
                    .addGroup(userCreationPanelLayout.createSequentialGroup()
                        .addGroup(userCreationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel)
                            .addComponent(lastNameLabel)
                            .addComponent(permissionLabel)
                            .addComponent(permissionSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        userCreationPanelLayout.setVerticalGroup(
            userCreationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userCreationPanelLayout.createSequentialGroup()
                .addComponent(firstNameLabel)
                .addGap(1, 1, 1)
                .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastNameLabel)
                .addGap(1, 1, 1)
                .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(permissionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(permissionSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(userCreationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancel)
                    .addComponent(createUser)
                    .addComponent(chbUnlockFields))
                .addGap(99, 99, 99))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userCreationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userCreationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFirstNameActionPerformed
    /**
     * calls upon the errorCheckCreateUser method to check if the user input is
     * not empty. then changes user.
     *
     * @param evt
     */

    private void tfFirstNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFirstNameKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            boolean totalCorrectInput = errorCheckCreateUser();
            boolean isConfirm = false;
            if (totalCorrectInput == false) {
                errorPopUp("Vul a.u.b. alle velden correct in.");
            } else {
                isConfirm = createPopUp("Weet u zeker dat u de gegevens van deze gebruiker wilt aanpassen?");
                if (isConfirm == true) {
                    doChangeUser();
                    dispose();
                    admin.searchUserTable(9999, "");
                }
            }
        }
    }//GEN-LAST:event_tfFirstNameKeyPressed

    private void tfLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLastNameActionPerformed

    private void tfLastNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLastNameKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            boolean totalCorrectInput = errorCheckCreateUser();
            boolean isConfirm = false;
            if (totalCorrectInput == false) {
                errorPopUp("Vul a.u.b. alle velden in voordat u het opnieuw probeert.");
            } else {
                isConfirm = createPopUp("Weet u zeker dat u de gegevens van deze gebruiker wilt aanpassen?");
                if (isConfirm == true) {
                    doChangeUser();
                    dispose();
                    admin.searchUserTable(9999, "");
                }
            }
        }
    }//GEN-LAST:event_tfLastNameKeyPressed

    private void permissionSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permissionSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permissionSelectorActionPerformed

    private void permissionSelectorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_permissionSelectorKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            boolean totalCorrectInput = errorCheckCreateUser();
            boolean isConfirm = false;
            if (totalCorrectInput == false) {
                errorPopUp("Vul a.u.b. alle velden in voordat u het opnieuw probeert.");
            } else {
                isConfirm = createPopUp("Weet u zeker dat u de gegevens van deze gebruiker wilt aanpassen?");
                if (isConfirm == true) {
                    doChangeUser();
                    dispose();
                    admin.searchUserTable(9999, "");
                }
            }
        }
    }//GEN-LAST:event_permissionSelectorKeyPressed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void createUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserActionPerformed

        boolean totalCorrectInput = errorCheckCreateUser();
        boolean isConfirm = false;
        if (totalCorrectInput == false) {
            errorPopUp("Please fill in all the fields before trying again.");
        } else {
            isConfirm = createPopUp("Weet u zeker dat u deze gebruiker wilt aanmaken?");
            if (isConfirm == true) {
                doChangeUser();
                dispose();
                admin.searchUserTable(9999, "");
            }
        }
    }//GEN-LAST:event_createUserActionPerformed

    private void chbUnlockFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbUnlockFieldsActionPerformed
        tfFirstName.setEditable(chbUnlockFields.isSelected());
        tfLastName.setEditable(chbUnlockFields.isSelected());
        permissionSelector.setEditable(chbUnlockFields.isSelected());
    }//GEN-LAST:event_chbUnlockFieldsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JCheckBox chbUnlockFields;
    private javax.swing.JButton createUser;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel permissionLabel;
    private javax.swing.JComboBox permissionSelector;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JPanel userCreationPanel;
    // End of variables declaration//GEN-END:variables
}
