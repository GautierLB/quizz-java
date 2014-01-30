/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

/**
 *
 * @author Gautier
 */
import java.awt.*;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
 
public class LoginDialog extends JDialog {
 
    public LoginDialog(MainFrame parent) {
        super(parent, "Login", true);
        this.setModal(false);
        LoginDialogPanel login = new LoginDialogPanel(parent); 
        getContentPane().add(login, BorderLayout.CENTER);
        this.setUndecorated(true);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
            
    }            
}
