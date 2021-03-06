package view.employee;

import connectivity.QueryManager;
import java.awt.Component;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.Main;
import main.Session;
import model.Customer;
import model.Luggage;
import model.Resort;
import model.User;

/**
 *
 * @author Team AwesomeSauce
 */
public class ExtendedCustomer extends javax.swing.JFrame {

    private final QueryManager query = new QueryManager();
    private User user = new User();
    private Customer customer = new Customer();
    private final Session session = new Session();
    private Resort resort = new Resort();

    private OverviewPrint print = new OverviewPrint();
    private List<Luggage> luggages;
    private DefaultTableModel modelLuggage;

    private DefaultListModel model = new DefaultListModel();
    private Component errorPopUp, confirmationPopUp;
    private String[] email, address;
    private String[] resortEmail;

    private final ResourceBundle BUNDLE = ResourceBundle.getBundle("languages.ResourceBundle");

    /**
     * Method to show the old information of the customer and can be replaced by
     * new information if the user wants too. Also the information can be
     * edited.
     */
    public ExtendedCustomer() {
        customer = query.getCustomerData(Session.storedCustomerId, "customer_id");
        user = query.getUserDataInt(customer.getLastChangedBy());
        resort = query.getResortData(Integer.toString(customer.getResortId()), "resort_id");
        System.out.println(resort.getCountry());

        System.out.println("");
        resortEmail = seperateString(resort.getEmail(), "@");
        email = seperateString(customer.getEmail(), "@");
        address = seperateString(customer.getAddress(), " ");

        initComponents();

        editInfoLabel.setText(BUNDLE.getString("lastChangedBy")
                + user.getFirstName() + " " + user.getLastName()
                + BUNDLE.getString("on") + customer.getDateChanged().substring(0,
                        customer.getDateChanged().length() - 5));

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
        tfResortName.setText(resort.getName());
        tfResortAddress.setText(resort.getAddress());
        tfResortCity.setText(resort.getCity());
        tfResortCountry.setText(resort.getCountry());
        tfResortPhoneNumber.setText(resort.getPhone());
        tfResortPostalCode.setText(resort.getPostalCode());
        tfResortEmail.setText(resortEmail[0]);
        tfResortEmail2.setText(resortEmail[1]);

        tfAddress1.setEditable(false);
        tfAddress2.setEditable(false);
        tfFirstName.setEditable(false);
        tfLastName.setEditable(false);
        tfPostalCode.setEditable(false);
        tfCity.setEditable(false);
        cbCountry.enable(false);
        tfEmail1.setEditable(false);
        tfEmail2.setEditable(false);
        tfPhoneHome.setEditable(false);
        tfPhoneMobile.setEditable(false);
        tfResortAddress.setEditable(false);
        tfResortCity.setEditable(false);
        tfResortCountry.setEditable(false);
        tfResortEmail.setEditable(false);
        tfResortEmail2.setEditable(false);
        tfResortName.setEditable(false);
        tfResortPhoneNumber.setEditable(false);
        tfResortPostalCode.setEditable(false);

        listBagageToPrint.setModel(model);
        modelLuggage = (DefaultTableModel) this.luggageTable.getModel();
        searchLuggage(11, Integer.toString(customer.getCustomerId()), 0);
    }

    /**
     * Method to show when the customer information is edited.
     */
    private void initFields() {
        customer = query.getCustomerData(Session.storedCustomerId, "customer_id");
        user = query.getUserDataInt(customer.getLastChangedBy());

        editInfoLabel.setText(BUNDLE.getString("lastChangedBy")
                + user.getFirstName() + " " + user.getLastName()
                + BUNDLE.getString("on") + customer.getDateChanged().substring(0,
                        customer.getDateChanged().length() - 5));

        modelLuggage = (DefaultTableModel) this.luggageTable.getModel();
        searchLuggage(11, Integer.toString(customer.getCustomerId()), 0);
    }

    /**
     * Searches through the luggage database and loads the results into the
     * luggage table.
     *
     * @param dbField specifies the field to search in. Setting this parameter
     * to 0 searches all fields.
     * @param searchArg argument used to search the database.
     * @param showHandled when this parameter is 1 it will show luggage that has
     * already been handled.
     */
    private void searchLuggage(int dbField, String searchArg, int showHandled) {
        modelLuggage.setRowCount(0);
        luggages = query.searchLuggageList(dbField, searchArg, showHandled);
        for (Luggage luggage : luggages) {
            modelLuggage.addRow(new Object[]{new Integer(luggage.getLuggageId()),
                luggage.getCustomerId(),
                luggage.getDescription(),
                luggage.getLocation(),
                luggage.getDateLost(),
                luggage.getStatus()});
        }
    }

    /**
     * Method to seperate specific information in different parts, so the error
     * handling wouldn't be stuck on one specific information part if the
     * information was incorrect.
     *
     * @param itemToSeperate Is used to seperate information so the error
     * handling can check specific on one part of the information.
     * @param sepChar Is the character what determines when information should
     * be seperated.
     * @return
     */
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

    /**
     * Method used to create and display an error message and is used for error-
     * handling.
     *
     * @param errorMessage The message that will be displayed as a pop-up.
     */
    private void errorPopUp(String errorMessage) {
        JOptionPane.showMessageDialog(errorPopUp, errorMessage);
    }

    /**
     * Method to display a yes-or no pop-up that confirms the user's choice.
     *
     * @param message The message you get for clicking the create button and
     * will be displayed a pop-up.
     * @return The confirmation for creating.
     */
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
        lblCustomerEmail = new javax.swing.JLabel();
        tfEmail1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfEmail2 = new javax.swing.JTextField();
        tfPhoneMobile = new javax.swing.JTextField();
        btEditCustomer = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        lblCustomerCountry = new javax.swing.JLabel();
        tfCity = new javax.swing.JTextField();
        cbCountry = new javax.swing.JComboBox();
        warningLabel1 = new javax.swing.JLabel();
        tfPostalCode = new javax.swing.JTextField();
        chbUnlockFields = new javax.swing.JCheckBox();
        editInfoLabel = new javax.swing.JLabel();
        tfPhoneHome = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBagageToPrint = new javax.swing.JList();
        btDeleteListItem = new javax.swing.JButton();
        btClearList = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btCreatePdf = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        luggageTable = new javax.swing.JTable();
        btAddToList = new javax.swing.JButton();
        chbHideHandled = new javax.swing.JCheckBox();
        chbHideLost = new javax.swing.JCheckBox();
        chbHideFound = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        tfResortName = new javax.swing.JTextField();
        tfResortCountry = new javax.swing.JTextField();
        tfResortAddress = new javax.swing.JTextField();
        tfResortCity = new javax.swing.JTextField();
        tfResortEmail = new javax.swing.JTextField();
        tfResortPostalCode = new javax.swing.JTextField();
        tfResortPhoneNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfResortEmail2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gegevens van " + customer.getFirstName() + " " + customer.getLastName());
        setIconImage(getToolkit().getImage(getClass().getResource("/img/corendon.png")));
        setMinimumSize(new java.awt.Dimension(947, 870));

        customerRegistrationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(BUNDLE.getString("changeCustomerInfo")
        ));

        jLabel7.setText(BUNDLE.getString("address"));

        tfAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAddress2ActionPerformed(evt);
            }
        });

        jLabel12.setText(BUNDLE.getString("postalCode"));

        tfFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFirstNameActionPerformed(evt);
            }
        });

        jLabel13.setText(BUNDLE.getString("firstName"));

        jLabel14.setText(BUNDLE.getString("lastName"));

        lblCustomerEmail.setText(BUNDLE.getString("email"));

        jLabel16.setText("@");

        tfEmail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmail2ActionPerformed(evt);
            }
        });

        btEditCustomer.setText(BUNDLE.getString("adjust"));
        btEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditCustomerActionPerformed(evt);
            }
        });

        jButton4.setText(BUNDLE.getString("cancel"));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel19.setText(BUNDLE.getString("city"));

        lblCustomerCountry.setText(BUNDLE.getString("country"));

        cbCountry.setModel(new javax.swing.DefaultComboBoxModel(BUNDLE.getStringArray("countriesComboBox")));
        cbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountryActionPerformed(evt);
            }
        });

        warningLabel1.setForeground(new java.awt.Color(255, 0, 0));

        chbUnlockFields.setText(BUNDLE.getString("unlockFields"));
        chbUnlockFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbUnlockFieldsActionPerformed(evt);
            }
        });

        editInfoLabel.setForeground(new java.awt.Color(102, 102, 102));

        jLabel17.setText(BUNDLE.getString("phoneHome"));

        jLabel18.setText(BUNDLE.getString("phoneMobile"));

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
                        .addComponent(lblCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(3, 3, 3)
                        .addComponent(tfEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                        .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCustomerCountry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
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
                                    .addComponent(tfEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPhoneMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPhoneHome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 133, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        customerRegistrationPanelLayout.setVerticalGroup(
            customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerRegistrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerCountry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCustomerEmail)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPhoneHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(BUNDLE.getString("printTicket")
        ));

        listBagageToPrint.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jScrollPane1.setViewportView(listBagageToPrint);

        btDeleteListItem.setText(BUNDLE.getString("deleteFromList"));
        btDeleteListItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteListItemActionPerformed(evt);
            }
        });

        btClearList.setText(BUNDLE.getString("clearList"));
        btClearList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearListActionPerformed(evt);
            }
        });

        jLabel1.setText(BUNDLE.getString("itemsToPrint"));

        btCreatePdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/121.png"))); // NOI18N
        btCreatePdf.setText(BUNDLE.getString("printTicket"));
        btCreatePdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreatePdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btClearList)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(btCreatePdf)
                            .addComponent(btDeleteListItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(86, 114, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDeleteListItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btClearList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCreatePdf)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bagage van " + customer.getFirstName() + " " + customer.getLastName()));

        luggageTable.setAutoCreateRowSorter(true);
        luggageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            BUNDLE.getStringArray("luggageTableFields")
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        btAddToList.setText(BUNDLE.getString("addToPrintList"));
        btAddToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddToListActionPerformed(evt);
            }
        });

        chbHideHandled.setText(BUNDLE.getString("hideHandled"));

        chbHideLost.setText(BUNDLE.getString("hideMissing"));

        chbHideFound.setText(BUNDLE.getString("hideFound"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btAddToList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chbHideHandled)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chbHideLost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chbHideFound)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAddToList)
                    .addComponent(chbHideHandled)
                    .addComponent(chbHideLost)
                    .addComponent(chbHideFound))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(BUNDLE.getString("resortInfo")));

        jLabel2.setText(BUNDLE.getString("name"));

        jLabel3.setText(BUNDLE.getString("address"));

        jLabel4.setText(BUNDLE.getString("country"));

        jLabel5.setText(BUNDLE.getString("email"));

        jLabel6.setText(BUNDLE.getString("phoneNumber"));

        jLabel8.setText(BUNDLE.getString("city"));

        jLabel9.setText(BUNDLE.getString("postalCode"));

        jLabel10.setText("@");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfResortName, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(tfResortCountry)
                    .addComponent(tfResortCity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfResortPostalCode, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfResortAddress, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfResortPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfResortEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfResortEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 195, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfResortCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(tfResortPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfResortCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfResortAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(tfResortPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfResortName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfResortEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfResortEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addContainerGap(31, Short.MAX_VALUE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(customerRegistrationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE)))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteListItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteListItemActionPerformed
        model.removeElement(listBagageToPrint.getSelectedValue());
    }//GEN-LAST:event_btDeleteListItemActionPerformed

    private void btAddToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddToListActionPerformed
        try {
            int luggageID = Integer.parseInt(luggageTable.getValueAt(luggageTable.getSelectedRow(), 0).toString());
            if(model.contains(luggageID))
            errorPopUp(BUNDLE.getString("luggageAlreadyAdded"));    
            else
            model.addElement((Integer) luggageID);
        } catch (IndexOutOfBoundsException e) {
            errorPopUp(BUNDLE.getString("selectLuggageToAdd"));
        }
    }//GEN-LAST:event_btAddToListActionPerformed

    private void btClearListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearListActionPerformed
        model.removeAllElements();
    }//GEN-LAST:event_btClearListActionPerformed

    private void btCreatePdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreatePdfActionPerformed
        for (int i = 0; i < listBagageToPrint.getModel().getSize(); i++) {
            session.addToList((Integer) listBagageToPrint.getModel().getElementAt(i));
        }
        Main.displaySaveDocument();
    }//GEN-LAST:event_btCreatePdfActionPerformed

    private void chbUnlockFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbUnlockFieldsActionPerformed
        tfAddress1.setEditable(chbUnlockFields.isSelected());
        tfAddress2.setEditable(chbUnlockFields.isSelected());
        tfEmail1.setEditable(chbUnlockFields.isSelected());
        tfEmail2.setEditable(chbUnlockFields.isSelected());
        tfPostalCode.setEditable(chbUnlockFields.isSelected());
        tfCity.setEditable(chbUnlockFields.isSelected());
        cbCountry.enable(chbUnlockFields.isSelected());
        tfPhoneHome.setEditable(chbUnlockFields.isSelected());
        tfPhoneMobile.setEditable(chbUnlockFields.isSelected());
        tfFirstName.setEditable(chbUnlockFields.isSelected());
        tfLastName.setEditable(chbUnlockFields.isSelected());
    }//GEN-LAST:event_chbUnlockFieldsActionPerformed

    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCountryActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditCustomerActionPerformed
        String firstName = tfFirstName.getText().trim();
        String lastName = tfLastName.getText().trim();
        String address1 = tfAddress1.getText().trim();
        String address2 = tfAddress2.getText().trim();
        String postalCode = tfPostalCode.getText().trim();
        String city = tfCity.getText().trim();
        String country = cbCountry.getSelectedItem().toString();
        String email1 = tfEmail1.getText().trim();
        String email2 = tfEmail2.getText().trim();
        String phoneHome = tfPhoneHome.getText().trim();
        String phoneMobile = tfPhoneMobile.getText().trim();
        String[] popUpMsg = BUNDLE.getStringArray("confirmationChangeCustomer");

        boolean correctInput[] = new boolean[8];
        boolean totalCorrectInput = true;
        boolean finalCheck;

        if (firstName.equals("")) {
            errorPopUp(BUNDLE.getString("enterFirstName"));
            correctInput[0] = false;
        } else {
            correctInput[0] = true;
        }

        if (lastName.equals("")) {
            errorPopUp(BUNDLE.getString("enterLastName"));
            correctInput[1] = false;
        } else {
            correctInput[1] = true;
        }

        if (address1.equals("") || address2.equals("")) {
            errorPopUp(BUNDLE.getString("enterAddress"));
            correctInput[2] = false;
        } else {
            correctInput[2] = true;
        }

        if (postalCode.equals("")) {
            errorPopUp(BUNDLE.getString("enterPostalCode"));
            correctInput[3] = false;
        } else {
            correctInput[3] = true;
        }

        if (city.equals("")) {
            errorPopUp(BUNDLE.getString("enterCity"));
            correctInput[4] = false;
        } else {
            correctInput[4] = true;
        }

        if (email1.equals("") || email2.equals("")) {
            errorPopUp(BUNDLE.getString("enterEmail"));
            correctInput[5] = false;
        } else {
            correctInput[5] = true;
        }

        if (phoneHome.equals("")) {
            correctInput[6] = true;
        } else if (phoneHome.matches("[0-9]+")) {
            correctInput[6] = true;
        } else {
            errorPopUp(BUNDLE.getString("enterPhoneHome"));
            correctInput[6] = false;
        }

        if (phoneMobile.equals("")) {
            correctInput[7] = true;
        } else if (phoneMobile.matches("[0-9]+")) {
            correctInput[7] = true;
        } else {
            errorPopUp(BUNDLE.getString("enterPhoneMobile"));
            correctInput[7] = false;
        }

        for (int i = 0; i < correctInput.length; i++) {
            if (correctInput[i] == false) {
                totalCorrectInput = false;
                break;
            } else {
                totalCorrectInput = true;
            }
        }
        System.out.println(totalCorrectInput);
        if (totalCorrectInput == true) {
            finalCheck = confirmationPopUp(popUpMsg[0] + "   \n"
                    + popUpMsg[1] + firstName + "   \n" + popUpMsg[2] + lastName + "   \n"
                    + popUpMsg[3] + address1 + " " + address2 + "   \n" + popUpMsg[4] + postalCode
                    + "   \n" + popUpMsg[5] + city + "   \n" + popUpMsg[6] + country + "   \n" + popUpMsg[7]
                    + email1 + "@" + email2 + "   \n" + popUpMsg[8] + phoneHome + "   \n"
                    + popUpMsg[9] + phoneMobile);
        } else {
            finalCheck = false;
        }

        if (finalCheck == true) {
            query.updateCustomer(tfFirstName.getText().trim(),
                    tfLastName.getText().trim(),
                    tfAddress1.getText().trim() + " " + tfAddress2.getText().trim(),
                    tfPostalCode.getText().trim(),
                    tfCity.getText().trim(),
                    cbCountry.getSelectedItem().toString(),
                    tfEmail1.getText() + "@" + tfEmail2.getText(), tfPhoneHome.getText().trim(),
                    tfPhoneMobile.getText().trim());

            tfAddress1.setEditable(false);
            tfAddress2.setEditable(false);
            tfFirstName.setEditable(false);
            tfLastName.setEditable(false);
            tfPostalCode.setEditable(false);
            tfCity.setEditable(false);
            cbCountry.enable(false);
            tfEmail1.setEditable(false);
            tfEmail2.setEditable(false);
            tfPhoneHome.setEditable(false);
            tfPhoneMobile.setEditable(false);
            chbUnlockFields.setSelected(false);
            initFields();
        }
    }//GEN-LAST:event_btEditCustomerActionPerformed

    private void tfEmail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmail2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmail2ActionPerformed

    private void tfFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFirstNameActionPerformed

    private void tfAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAddress2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAddress2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddToList;
    private javax.swing.JButton btClearList;
    private javax.swing.JButton btCreatePdf;
    private javax.swing.JButton btDeleteListItem;
    private javax.swing.JButton btEditCustomer;
    private javax.swing.JComboBox cbCountry;
    private javax.swing.JCheckBox chbHideFound;
    private javax.swing.JCheckBox chbHideHandled;
    private javax.swing.JCheckBox chbHideLost;
    private javax.swing.JCheckBox chbUnlockFields;
    private javax.swing.JPanel customerRegistrationPanel;
    private javax.swing.JLabel editInfoLabel;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblCustomerCountry;
    private javax.swing.JLabel lblCustomerEmail;
    private javax.swing.JList listBagageToPrint;
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
    private javax.swing.JTextField tfResortAddress;
    private javax.swing.JTextField tfResortCity;
    private javax.swing.JTextField tfResortCountry;
    private javax.swing.JTextField tfResortEmail;
    private javax.swing.JTextField tfResortEmail2;
    private javax.swing.JTextField tfResortName;
    private javax.swing.JTextField tfResortPhoneNumber;
    private javax.swing.JTextField tfResortPostalCode;
    private javax.swing.JLabel warningLabel1;
    // End of variables declaration//GEN-END:variables
}
