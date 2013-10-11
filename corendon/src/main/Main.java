/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import view.*;

/**
 *
 * @author Florentijn Cornet
 */
public class Main {

    private JFrame frameLogin;

    private Main() {
    }

    public static void displayLogin() {
        Login frameLogin = new Login();
        frameLogin.setVisible(true);
    }
    
    public static void displayGebruiker() { //groupId = 1
        Gebruiker frameEmployee = new Gebruiker();
        frameEmployee.setVisible(true);
    }
    
    public static void displayManager() { //groupId = 2
        Gebruiker frameEmployee = new Gebruiker();
        frameEmployee.setVisible(true);
    }
    
    public static void displayBeheerder() { //groupId = 3
        Gebruiker frameEmployee = new Gebruiker();
        frameEmployee.setVisible(true);
    }

    public static void main(String args[]) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                displayLogin();

            }
        });
    }
}