/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;
import quizz.model.User;

/**
 *
 * @author Gautier
 */
public class SignInDialogPanel extends RoundedPanel {

    /**
     * Creates new form SignInDialog
     */
    private MainFrame m_mainFrame;

    SignInDialogPanel(MainFrame mainFrame) {
        initComponents();
        m_mainFrame = mainFrame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pseudoTextBox = new javax.swing.JTextField();
        passwordTextBox = new JPasswordField(10);
        userIconLabel = new javax.swing.JLabel();
        padlockIconLabel = new javax.swing.JLabel();
        confirmPasswordTextBox = new JPasswordField(10);
        emailTextBox = new javax.swing.JTextField();
        padlockIconLabel2 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        messageIconLabel = new javax.swing.JLabel();
        signInButton = new javax.swing.JButton();
        pseudoErrors = new javax.swing.JLabel();
        passwordErrors = new javax.swing.JLabel();
        confirmPasswordErrors = new javax.swing.JLabel();
        emailErrors = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(450, 316));
        setMinimumSize(new java.awt.Dimension(450, 316));
        setPreferredSize(new java.awt.Dimension(450, 316));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pseudoTextBox.setFont(Main.s_openSans13);
        pseudoTextBox.setForeground(new java.awt.Color(170, 170, 170));
        pseudoTextBox.setText("Pseudo");
        pseudoTextBox.setToolTipText("");
        pseudoTextBox.setMaximumSize(new java.awt.Dimension(150, 10));
        pseudoTextBox.setMinimumSize(new java.awt.Dimension(150, 5));
        pseudoTextBox.setPreferredSize(new java.awt.Dimension(150, 5));
        pseudoTextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pseudoTextBoxFocusGained(evt);
            }
        });
        add(pseudoTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 82, 120, 20));

        passwordTextBox.setFont(Main.s_openSans13);
        passwordTextBox.setForeground(new java.awt.Color(170, 170, 170));
        passwordTextBox.setText("jTextField2");
        passwordTextBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        passwordTextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordTextBoxFocusGained(evt);
            }
        });
        add(passwordTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 122, 120, -1));

        userIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/userIcon-25.png"))); // NOI18N
        add(userIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 82, 25, -1));

        padlockIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/padlock-25.png"))); // NOI18N
        add(padlockIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 122, 25, -1));

        confirmPasswordTextBox.setFont(Main.s_openSans13);
        confirmPasswordTextBox.setForeground(new java.awt.Color(170, 170, 170));
        confirmPasswordTextBox.setText("jTextField2");
        confirmPasswordTextBox.setToolTipText("");
        confirmPasswordTextBox.setMaximumSize(new java.awt.Dimension(120, 10));
        confirmPasswordTextBox.setMinimumSize(new java.awt.Dimension(120, 5));
        confirmPasswordTextBox.setPreferredSize(new java.awt.Dimension(120, 5));
        confirmPasswordTextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmPasswordTextBoxFocusGained(evt);
            }
        });
        add(confirmPasswordTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 165, 120, 20));

        emailTextBox.setFont(Main.s_openSans13);
        emailTextBox.setForeground(new java.awt.Color(170, 170, 170));
        emailTextBox.setText("e-mail");
        emailTextBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailTextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTextBoxFocusGained(evt);
            }
        });
        add(emailTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 205, 120, -1));

        padlockIconLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/padlock-25.png"))); // NOI18N
        add(padlockIconLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 165, 25, -1));

        titleLabel.setFont(Main.s_openSans28);
        titleLabel.setText("Inscription");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 23, -1, -1));

        messageIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/messageIcon-25.png"))); // NOI18N
        add(messageIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 205, 25, -1));

        signInButton.setText("Inscription");
        signInButton.setMaximumSize(new java.awt.Dimension(100, 35));
        signInButton.setMinimumSize(new java.awt.Dimension(100, 35));
        signInButton.setPreferredSize(new java.awt.Dimension(100, 35));
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });
        add(signInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 248, 120, -1));

        pseudoErrors.setForeground(new java.awt.Color(255, 0, 0));
        pseudoErrors.setMaximumSize(new java.awt.Dimension(120, 20));
        pseudoErrors.setMinimumSize(new java.awt.Dimension(120, 20));
        pseudoErrors.setPreferredSize(new java.awt.Dimension(120, 20));
        add(pseudoErrors, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        passwordErrors.setForeground(new java.awt.Color(255, 0, 0));
        passwordErrors.setMaximumSize(new java.awt.Dimension(150, 20));
        passwordErrors.setMinimumSize(new java.awt.Dimension(150, 20));
        passwordErrors.setPreferredSize(new java.awt.Dimension(150, 20));
        add(passwordErrors, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        confirmPasswordErrors.setForeground(new java.awt.Color(255, 0, 0));
        confirmPasswordErrors.setMaximumSize(new java.awt.Dimension(200, 20));
        confirmPasswordErrors.setMinimumSize(new java.awt.Dimension(200, 20));
        confirmPasswordErrors.setPreferredSize(new java.awt.Dimension(200, 20));
        add(confirmPasswordErrors, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        emailErrors.setForeground(new java.awt.Color(255, 0, 0));
        emailErrors.setMaximumSize(new java.awt.Dimension(150, 20));
        emailErrors.setMinimumSize(new java.awt.Dimension(150, 20));
        emailErrors.setPreferredSize(new java.awt.Dimension(150, 20));
        add(emailErrors, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void confirmPasswordTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordTextBoxActionPerformed

    private void pseudoTextBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pseudoTextBoxFocusGained
        this.pseudoTextBox.setText("");
    }//GEN-LAST:event_pseudoTextBoxFocusGained

    private void passwordTextBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextBoxFocusGained
        this.passwordTextBox.setText("");
    }//GEN-LAST:event_passwordTextBoxFocusGained

    private void confirmPasswordTextBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPasswordTextBoxFocusGained
        this.confirmPasswordTextBox.setText("");
    }//GEN-LAST:event_confirmPasswordTextBoxFocusGained

    private void emailTextBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextBoxFocusGained
        this.emailTextBox.setText("");
    }//GEN-LAST:event_emailTextBoxFocusGained

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        this.cleanLabels();
        if (checkValues()) {
            User toCreate = new User(this.pseudoTextBox.getText(), this.passwordTextBox.getText(), this.emailTextBox.getText());
            if (toCreate.saveUser()) {
                Main.userPseudo = this.pseudoTextBox.getText();
                m_mainFrame.deleteModal();
            } else {
                this.pseudoErrors.setText("Pseudo déjà utilisé !");
            }
        }
    }//GEN-LAST:event_signInButtonActionPerformed

    private Boolean checkValues() {
        Boolean error = true;
        if (this.pseudoTextBox.getText().isEmpty()) {
            this.pseudoErrors.setText("Pseudo Manquant !");
            error = false;
        }
        if (this.passwordTextBox.getText().isEmpty()) {
            this.passwordErrors.setText("Mot de passe Manquant !");
            error = false;
        }
        if (this.confirmPasswordTextBox.getText().isEmpty()) {
            this.confirmPasswordErrors.setText("Confirmez votre mot de passe");
            error = false;
        }
        if (this.emailTextBox.getText().isEmpty()) {
            this.emailErrors.setText("Email manquant!");
            error = false;
        } else if (!isEmailAdress(this.emailTextBox.getText())) {
            this.emailErrors.setText("Email invalide !");
            error = false;
        }
        return error;
    }

    private boolean isEmailAdress(String email) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher m = p.matcher(email.toUpperCase());
        return m.matches();
    }
    
    private void cleanLabels() {
        this.pseudoErrors.setText("");
        this.passwordErrors.setText("");
        this.confirmPasswordErrors.setText("");
        this.emailErrors.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirmPasswordErrors;
    private javax.swing.JTextField confirmPasswordTextBox;
    private javax.swing.JLabel emailErrors;
    private javax.swing.JTextField emailTextBox;
    private javax.swing.JLabel messageIconLabel;
    private javax.swing.JLabel padlockIconLabel;
    private javax.swing.JLabel padlockIconLabel2;
    private javax.swing.JLabel passwordErrors;
    private javax.swing.JTextField passwordTextBox;
    private javax.swing.JLabel pseudoErrors;
    private javax.swing.JTextField pseudoTextBox;
    private javax.swing.JButton signInButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userIconLabel;
    // End of variables declaration//GEN-END:variables

    
}
