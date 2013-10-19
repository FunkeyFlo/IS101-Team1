/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.medewerker.Medewerker;
import view.manager.Manager;
import view.beheerder.Beheerder;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import view.*;
import view.medewerker.*;

/**
 *
 * @author Florentijn Cornet
 */
public class Main {

    private JFrame frameLogin;
    public static Session session;
    
    private Main() {
    }

    public static void displayLogin() {
        Login frameLogin = new Login();
        frameLogin.setVisible(true);
    }
    
    public static void displayMedewerker() { //permissionId = 1
        Medewerker frameMedewerker = new Medewerker();
        frameMedewerker.setVisible(true);
    }
    
    public static void displayManager() { //permissionId = 2
        Manager frameManager = new Manager();
        frameManager.setVisible(true);
    }
    
    public static void displayBeheerder() { //permissionId = 3
        Beheerder frameBeheerder = new Beheerder();
        frameBeheerder.setVisible(true);
    }
    
    public static void displayLinkLuggage() {
        LinkLuggage frameLinkLuggage = new LinkLuggage();
        frameLinkLuggage.setVisible(true);
    }
    
    public static void displayRegisterCustomer() {
        RegisterCustomer frameRegisterCustomer = new RegisterCustomer();
        frameRegisterCustomer.setVisible(true);
    }
    
    public static void displayChangeMyPassword() {
        ChangeMyPassword frameChangeMyPassword = new ChangeMyPassword();
        frameChangeMyPassword.setVisible(true);
    }

    public static void main(String args[]) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                displayLogin();
                Session session = new Session();

            }
        });
    }
}