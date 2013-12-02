package view.manager;

import connectivity.Luggage;
import connectivity.Luggage.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import main.Main;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author IS101 Team 1
 */

public class Manager extends javax.swing.JFrame {

    private static final String ALL_LUGGAGE_DATA_GRAPH_NAME = 
            "Verloren, gevonden en afgehandelde baggage per maand";
    private static final String LOST_LUGGAGE_GRAPH_NAME = 
            "Verloren baggage";
    private static final String FOUND_LUGGAGE_GRAPH_NAME = 
            "Gevonden baggage";
    private static final String HANDLED_LUGGAGE_GRAPH_NAME = 
            "Afgehandelde baggage";
    private static final String X_AXIS_NAME = "Maand/Jaar";
    private static final String Y_AXIS_NAME = "Aantal";
    private static final int LOST_LUGGAGE_DBFIELD = 6;
    private static final int FOUND_LUGGAGE_DBFIELD = 8;
    private static final int HANDLED_LUGGAGE_DBFIELD = 10;
    private static final int BEGIN_YEAR = 2010;
    private static final Color TRANS = new Color(0xFF, 0xFF, 0xFF, 0);

    
    public Manager() {
        initComponents();
        int CURRENT_YEAR = getCurrentYear();
        setAllDataGraph(CURRENT_YEAR, CURRENT_YEAR, 1, 12, 0);
        setLostLuggageGraph(CURRENT_YEAR, CURRENT_YEAR, 1, 12, 0);
        setFoundLuggageGraph(CURRENT_YEAR, CURRENT_YEAR, 1, 12, 0);
        setHandledLuggageGraph(CURRENT_YEAR, CURRENT_YEAR, 1, 12);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        overviewPane = new javax.swing.JTabbedPane();
        allGraphsTab = new javax.swing.JPanel();
        allGraphs = new javax.swing.JPanel();
        lostBaggageTab = new javax.swing.JPanel();
        lostBaggage = new javax.swing.JPanel();
        foundBaggageTab = new javax.swing.JPanel();
        foundBaggage = new javax.swing.JPanel();
        handledBaggageTab = new javax.swing.JPanel();
        handledBaggage = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        errorLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbMonthFrom = new javax.swing.JComboBox();
        cbYearFrom = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        buttonUpdateAllDataGraph = new javax.swing.JButton();
        cbMonthTo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbYearTo = new javax.swing.JComboBox();
        labelError = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cbShowAll = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        userMenu = new javax.swing.JMenu();
        changePassword = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();

        jLabel1.setText("ingelogd als gebruiker");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        allGraphs.setBorder(javax.swing.BorderFactory.createTitledBorder("Alle data"));
        allGraphs.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout allGraphsTabLayout = new javax.swing.GroupLayout(allGraphsTab);
        allGraphsTab.setLayout(allGraphsTabLayout);
        allGraphsTabLayout.setHorizontalGroup(
            allGraphsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allGraphsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allGraphs, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addContainerGap())
        );
        allGraphsTabLayout.setVerticalGroup(
            allGraphsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allGraphsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allGraphs, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        overviewPane.addTab("Alle data", allGraphsTab);

        lostBaggage.setBorder(javax.swing.BorderFactory.createTitledBorder("Vermiste bagage"));
        lostBaggage.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout lostBaggageTabLayout = new javax.swing.GroupLayout(lostBaggageTab);
        lostBaggageTab.setLayout(lostBaggageTabLayout);
        lostBaggageTabLayout.setHorizontalGroup(
            lostBaggageTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lostBaggageTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lostBaggage, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addContainerGap())
        );
        lostBaggageTabLayout.setVerticalGroup(
            lostBaggageTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lostBaggageTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lostBaggage, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        overviewPane.addTab("Vermiste bagage", lostBaggageTab);

        foundBaggage.setBorder(javax.swing.BorderFactory.createTitledBorder("Gevonde bagage"));
        foundBaggage.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout foundBaggageTabLayout = new javax.swing.GroupLayout(foundBaggageTab);
        foundBaggageTab.setLayout(foundBaggageTabLayout);
        foundBaggageTabLayout.setHorizontalGroup(
            foundBaggageTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foundBaggageTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(foundBaggage, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addContainerGap())
        );
        foundBaggageTabLayout.setVerticalGroup(
            foundBaggageTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foundBaggageTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(foundBaggage, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        overviewPane.addTab("Gevonden baggage", foundBaggageTab);

        handledBaggage.setBorder(javax.swing.BorderFactory.createTitledBorder("Afgehandelde Bagage"));
        handledBaggage.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout handledBaggageTabLayout = new javax.swing.GroupLayout(handledBaggageTab);
        handledBaggageTab.setLayout(handledBaggageTabLayout);
        handledBaggageTabLayout.setHorizontalGroup(
            handledBaggageTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handledBaggageTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(handledBaggage, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addContainerGap())
        );
        handledBaggageTabLayout.setVerticalGroup(
            handledBaggageTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handledBaggageTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(handledBaggage, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        overviewPane.addTab("Afgehandelde baggage", handledBaggageTab);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opties"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Van"));

        jLabel2.setText("Jaar");

        jLabel3.setText("Maand");

        cbMonthFrom.setMaximumRowCount(12);
        cbMonthFrom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December" }));

        cbYearFrom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbMonthFrom, 0, 101, Short.MAX_VALUE)
                    .addComponent(cbYearFrom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tot"));

        buttonUpdateAllDataGraph.setText("Update");
        buttonUpdateAllDataGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateAllDataGraphActionPerformed(evt);
            }
        });

        cbMonthTo.setMaximumRowCount(12);
        cbMonthTo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December" }));

        jLabel4.setText("Maand");

        jLabel5.setText("Jaar");

        cbYearTo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013" }));
        cbYearTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbYearToActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbMonthTo, 0, 101, Short.MAX_VALUE)
                            .addComponent(cbYearTo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(labelError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonUpdateAllDataGraph)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbYearTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(buttonUpdateAllDataGraph)
                        .addContainerGap())
                    .addComponent(labelError, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Legenda"));

        jLabel7.setText("Groen is afgehandelde baggage.");

        jLabel8.setText("Blauw is gevonden baggage.");

        jLabel9.setText("Rood is vermiste baggage.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Overige Opties"));

        cbShowAll.setText("Zie alle data, zelfs als de status van de");
        cbShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowAllActionPerformed(evt);
            }
        });

        jLabel6.setText("baggage niet meer van toepassing is.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbShowAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(cbShowAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(errorLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel))
        );

        userMenu.setText("Gebruiker");

        changePassword.setText("Wachtwoord wijzigen..");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });
        userMenu.add(changePassword);

        logout.setText("Uitloggen");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        userMenu.add(logout);

        menuBar.add(userMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(overviewPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(overviewPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   /**
     * Creates the graph for that will display all the luggage.
     * @param beginYear the year where the graph starts, as specified by 
     * the user
     * @param endYear the year where the graph ends
     * @param beginMonth the month in the year where the graph starts
     * @param endMonth  the month in the year where the graph ends
     */
    private void setAllDataGraph(int beginYear, int endYear,
            int beginMonth, int endMonth, int showIfAttributeNotTrue) {
        DefaultCategoryDataset allDataGraph = 
                new DefaultCategoryDataset();
        allDataGraph.clear();
        
        int numMonths = giveNumMonths(beginYear, endYear, 
                beginMonth, endMonth);
        List<String> yearsAndMonths = generateDates(beginYear, endYear, 
                beginMonth, endMonth);
        
        List<Integer> numTimesLost = getAmountLuggage(numMonths, 
                LOST_LUGGAGE_DBFIELD + showIfAttributeNotTrue, yearsAndMonths);
        List<Integer> numTimesFound = getAmountLuggage(numMonths, 
                FOUND_LUGGAGE_DBFIELD + showIfAttributeNotTrue, yearsAndMonths);
        List<Integer> numTimesHandled = getAmountLuggage(numMonths, 
                HANDLED_LUGGAGE_DBFIELD, yearsAndMonths);
        
        for (int i = 0; i < numMonths; i++) {
            //all graphs
            allDataGraph.setValue(numTimesLost.get(i), 
                    LOST_LUGGAGE_GRAPH_NAME, yearsAndMonths.get(i));
            allDataGraph.setValue(numTimesFound.get(i), 
                    FOUND_LUGGAGE_GRAPH_NAME, yearsAndMonths.get(i));
            allDataGraph.setValue(numTimesHandled.get(i), 
                    HANDLED_LUGGAGE_GRAPH_NAME, yearsAndMonths.get(i));
        }

        //creates the graph
        JFreeChart allGraphsChart = ChartFactory.createBarChart(
                ALL_LUGGAGE_DATA_GRAPH_NAME, X_AXIS_NAME, Y_AXIS_NAME, 
                allDataGraph, PlotOrientation.VERTICAL, 
                false, true, false);
        CategoryPlot allGraphsPlot = allGraphsChart.getCategoryPlot();
        allGraphsPlot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel lostBaggagePanel = new ChartPanel(allGraphsChart);
        allGraphsChart.setBackgroundPaint(TRANS);
        
        //applies the graph to the panel
        allGraphs.setLayout(new BorderLayout());
        allGraphs.add(lostBaggagePanel, BorderLayout.CENTER);
        allGraphs.validate();
        
    }
    
    /**
     * Creates the graph for all lost luggage data
     * @param beginYear the year where the graph starts, as specified by 
     * the user
     * @param endYear the year where the graph ends
     * @param beginMonth the month in the year where the graph starts
     * @param endMonth  the month in the year where the graph ends
     */
    private void setLostLuggageGraph(int beginYear, int endYear, 
            int beginMonth, int endMonth, int showIfAttributeNotTrue) {
        DefaultCategoryDataset lostBaggageGraph = 
                new DefaultCategoryDataset();
        lostBaggageGraph.clear();
        
        int numMonths = giveNumMonths(beginYear, endYear, 
                beginMonth, endMonth);
        List<String> yearsAndMonths = generateDates(beginYear, endYear, 
                beginMonth, endMonth);
        
        List<Integer> numLostPerMonth = getAmountLuggage(numMonths, 
                LOST_LUGGAGE_DBFIELD + showIfAttributeNotTrue, yearsAndMonths);
        
        
        for (int i = 0; i < numMonths; i++) {
            lostBaggageGraph.setValue(numLostPerMonth.get(i), 
                    LOST_LUGGAGE_GRAPH_NAME, yearsAndMonths.get(i));
        }
        
        JFreeChart lostBaggageChart = ChartFactory.createBarChart(
                LOST_LUGGAGE_GRAPH_NAME, X_AXIS_NAME, Y_AXIS_NAME, 
                lostBaggageGraph, PlotOrientation.VERTICAL, 
                false, true, false);
        CategoryPlot lostBaggagePlot = lostBaggageChart.getCategoryPlot();
        lostBaggagePlot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel lostBaggagePanel = new ChartPanel(lostBaggageChart);
        lostBaggageChart.setBackgroundPaint(TRANS);
        
        lostBaggage.setLayout(new BorderLayout());
        lostBaggage.add(lostBaggagePanel, BorderLayout.CENTER);
        lostBaggage.validate();

  
    }
    
    /**
     * Creates the graph for all found luggage data
     * @param beginYear the year where the graph begins, as specified by the user
     * @param endYear the year where the graph ends
     * @param beginMonth the month in the year where the graph begins
     * @param endMonth the month in the year where the graph ends
     */
    private void setFoundLuggageGraph(int beginYear, int endYear, 
            int beginMonth, int endMonth, int showIfAttributeNotTrue) {
        DefaultCategoryDataset foundBaggageGraph = 
                new DefaultCategoryDataset();
        foundBaggageGraph.clear();
        
        int numMonths = giveNumMonths(beginYear, endYear, beginMonth, endMonth);
        List<String> yearsAndMonths = 
                generateDates(beginYear, endYear, beginMonth, endMonth);        
        List<Integer> numFoundPerMonth = getAmountLuggage(numMonths, 
                FOUND_LUGGAGE_DBFIELD + showIfAttributeNotTrue, yearsAndMonths);
        
        //sets data
        for (int i = 0; i < numMonths; i++) {
            foundBaggageGraph.setValue(numFoundPerMonth.get(i), 
                    FOUND_LUGGAGE_GRAPH_NAME, yearsAndMonths.get(i));
        }
        
        //creates graph
        JFreeChart foundBaggageChart = ChartFactory.createBarChart(
                FOUND_LUGGAGE_GRAPH_NAME, X_AXIS_NAME, Y_AXIS_NAME, 
                foundBaggageGraph, PlotOrientation.VERTICAL, 
                false, true, false);
        CategoryPlot foundBaggagePlot = foundBaggageChart.getCategoryPlot();
        foundBaggagePlot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel foundBaggagePanel = new ChartPanel(foundBaggageChart);
        foundBaggageChart.setBackgroundPaint(new Color(0xFF, 0xFF, 0xFF, 0));
        foundBaggageChart.setBackgroundPaint(TRANS);
        
        //applies graph to panel
        foundBaggage.setLayout(new BorderLayout());
        foundBaggage.add(foundBaggagePanel, BorderLayout.CENTER);
        foundBaggage.validate();
    }
    
    /**
     * Creates the graph for all handled luggage data
     * @param beginYear the year where the graph starts, as specified by the user
     * @param endYear the year where the graph ends
     * @param beginMonth the month in the year where the graph begins
     * @param endMonth the month in the year where the graph ends
     */
    private void setHandledLuggageGraph(int beginYear, int endYear, 
            int beginMonth, int endMonth) {
        DefaultCategoryDataset handledBaggageGraph = 
                new DefaultCategoryDataset();
        handledBaggageGraph.clear();
        
        List<String> yearsAndMonths = generateDates(beginYear, endYear,
                beginMonth, endMonth);
        int numMonths = giveNumMonths(beginYear, endYear,
                beginMonth, endMonth);
        List<Integer> numHandledPerMonth = getAmountLuggage(numMonths, 
                HANDLED_LUGGAGE_DBFIELD, yearsAndMonths);
        
        //sets data
        for (int i = 0; i < numMonths; i++) {
            handledBaggageGraph.setValue(numHandledPerMonth.get(i), 
                    HANDLED_LUGGAGE_GRAPH_NAME, yearsAndMonths.get(i));
        }
        
        //creates graph
        JFreeChart handledBaggageChart = ChartFactory.createBarChart(
                HANDLED_LUGGAGE_GRAPH_NAME, X_AXIS_NAME, Y_AXIS_NAME, 
                handledBaggageGraph, PlotOrientation.VERTICAL, 
                false, true, false);
        CategoryPlot handledBaggagePlot = handledBaggageChart.getCategoryPlot();
        handledBaggagePlot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel handledBaggagePanel = new ChartPanel(handledBaggageChart);
        handledBaggageChart.setBackgroundPaint(TRANS);
        
        //applies graph to panel
        handledBaggage.setLayout(new BorderLayout());
        handledBaggage.add(handledBaggagePanel, BorderLayout.CENTER);
        handledBaggage.validate();
    }

    
    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        Main.displayChangeMyPassword();
    }//GEN-LAST:event_changePasswordActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        dispose();
        Main.displayLogin();
    }//GEN-LAST:event_logoutActionPerformed

    private void cbYearToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbYearToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbYearToActionPerformed
    
    /**
     * Gets months and years the user would like to view luggage data in,
     * and gives them as parameters to all set graph methods.
     * @param evt 
     */
    private void buttonUpdateAllDataGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateAllDataGraphActionPerformed
        int yearFrom = cbYearFrom.getSelectedIndex() + BEGIN_YEAR,
        yearTo = cbYearTo.getSelectedIndex() + BEGIN_YEAR,
        monthFrom = cbMonthFrom.getSelectedIndex() + 1,
        monthTo = cbMonthTo.getSelectedIndex() + 1;
        int showIfAttributeNotTrue = cbShowAll.isSelected() ? 1 : 0;
        if (yearFrom > yearTo) { 
            errorPopUp("Begindatum kan niet groter zijn dan einddatum.");
        } else {
            setAllDataGraph(yearFrom, yearTo, monthFrom, monthTo, 
                    showIfAttributeNotTrue);
            setLostLuggageGraph(yearFrom, yearTo, monthFrom, monthTo, 
                    showIfAttributeNotTrue);
            setFoundLuggageGraph(yearFrom, yearTo, monthFrom, monthTo, 
                    showIfAttributeNotTrue);
            setHandledLuggageGraph(yearFrom, yearTo, monthFrom, monthTo);
        }
    }//GEN-LAST:event_buttonUpdateAllDataGraphActionPerformed

    private void cbShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbShowAllActionPerformed
    
    /**
     * @return amount of months between begin year and month and end year and month.
     */
    private static int giveNumMonths(int beginYear, int endYear,
            int beginMonth, int endMonth) {
        int numYears = endYear - beginYear == 0 ? 
                1 : (endYear - beginYear) + 1;
        int numMonths = ((numYears * 12) - beginMonth) - (12 - endMonth) + 1;
        return numMonths;
    }
    
    /**
     * Generates array of strings that will be used in sql statements and
     * shown under the X axis of the graph.
     * @param beginYear the first year the graph will show
     * @param endYear the last year the graph will show
     * @param beginMonth the first month in the first year the graph will show
     * @param endMonth the last month in the last year the graph will show
     * @return String array of format 'yyyy-mm'
     * @see getAmountLuggage
     */
    private static List<String> generateDates(int beginYear, int endYear,
            int beginMonth, int endMonth) {
        List<String> yearsAndMonths = new ArrayList<>();
        int currentMonth = beginMonth - 1;
        int currentYear = beginYear;
        boolean isNextYear = false;
        String insertZero;
        
        int numMonths = giveNumMonths(beginYear, endYear, 
                beginMonth, endMonth);
        
        for (int i = 0; i < numMonths; i++) {
            currentMonth = currentMonth == 12 ? 1 : currentMonth + 1;
            currentYear = isNextYear ? currentYear + 1 : currentYear;
            isNextYear = currentMonth == 12;
            if (currentMonth<=9) {
                insertZero = "0";
            } else insertZero = "";
            yearsAndMonths.add(Integer.toString(currentYear) + "-" 
                    + insertZero + Integer.toString(currentMonth));
        }
        
        return yearsAndMonths;
    }   
    
    /**
     * Used in the graphs to display information of the current year at
     * startup.
     * @return the current year.
     */
    private static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
 
    /**
     * gets an amount of luggage for the specified months
     * @param numMonths how many months worth of data should be returned
     * @param dbField parameter for searchLuggageList method
     * @param yearsAndMonths String array passed on as searchArg parameter
     * in the searchLuggageList method
     * @return amount of luggage
     */
    private List<Integer> getAmountLuggage(int numMonths, int dbField, 
            List<String> yearsAndMonths) {
        List<Luggage> luggage = new ArrayList<>();
        final Luggage LUGGAGE_MODEL = new Luggage();
        List<Integer> numTimesLost = new ArrayList<>();
        for (int i = 0; i < numMonths; i++) {
            luggage.clear();
            luggage = LUGGAGE_MODEL.searchLuggageList(dbField, 
                    yearsAndMonths.get(i), 0);
            numTimesLost.add(0);
            while (numTimesLost.get(i) < luggage.size()) {
                numTimesLost.set(i, numTimesLost.get(i) + 1);
            }
        }
        return numTimesLost;
    }
    
    private void errorPopUp(String errorMessage) {
        Component errorPopUp = null;
        JOptionPane.showMessageDialog(errorPopUp, errorMessage);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allGraphs;
    private javax.swing.JPanel allGraphsTab;
    private javax.swing.JButton buttonUpdateAllDataGraph;
    private javax.swing.JComboBox cbMonthFrom;
    private javax.swing.JComboBox cbMonthTo;
    private javax.swing.JCheckBox cbShowAll;
    private javax.swing.JComboBox cbYearFrom;
    private javax.swing.JComboBox cbYearTo;
    private javax.swing.JMenuItem changePassword;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JPanel foundBaggage;
    private javax.swing.JPanel foundBaggageTab;
    private javax.swing.JPanel handledBaggage;
    private javax.swing.JPanel handledBaggageTab;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelError;
    private javax.swing.JMenuItem logout;
    private javax.swing.JPanel lostBaggage;
    private javax.swing.JPanel lostBaggageTab;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTabbedPane overviewPane;
    private javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables


}