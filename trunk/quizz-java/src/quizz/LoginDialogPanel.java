/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import javax.swing.JPasswordField;
import quizz.model.User;

/**
 *
 * @author Gautier
 */
public class LoginDialogPanel extends RoundedPanel {

    /**
     * Creates new form LoginDialog
     */
    private MainFrame m_mainFrame;
    private BrainStormingView owner;

    public LoginDialogPanel(MainFrame mainFrame) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TitleLabel = new javax.swing.JLabel();
        pseudoTextBox = new javax.swing.JTextField();
        passwordTextBox = new JPasswordField(10);
        userIconLabel = new javax.swing.JLabel();
        padlockIconLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        signInButton = new javax.swing.JButton();
        pseudoErrors = new javax.swing.JLabel();
        passwordErrors = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(400, 240));
        setMinimumSize(new java.awt.Dimension(400, 240));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 240));
        setRequestFocusEnabled(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(Main.s_openSans28);
        TitleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/key-30.png"))); // NOI18N
        TitleLabel.setText("Connexion");
        add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 10, -1, -1));

        pseudoTextBox.setFont(Main.s_openSans13);
        pseudoTextBox.setForeground(new java.awt.Color(170, 170, 170));
        pseudoTextBox.setText("Pseudo");
        pseudoTextBox.setToolTipText("");
        pseudoTextBox.setMaximumSize(new java.awt.Dimension(120, 10));
        pseudoTextBox.setMinimumSize(new java.awt.Dimension(120, 5));
        pseudoTextBox.setPreferredSize(new java.awt.Dimension(120, 5));
        pseudoTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pseudoTextBoxActionPerformed(evt);
            }
        });
        pseudoTextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pseudoTextBoxFocusGained(evt);
            }
        });
        add(pseudoTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 120, 20));

        passwordTextBox.setFont(Main.s_openSans13);
        passwordTextBox.setForeground(new java.awt.Color(170, 170, 170));
        passwordTextBox.setText("jTextField2");
        passwordTextBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        passwordTextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordTextBoxFocusGained(evt);
            }
        });
        add(passwordTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 120, -1));

        userIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/userIcon-25.png"))); // NOI18N
        add(userIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        padlockIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/padlock-25.png"))); // NOI18N
        add(padlockIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        loginButton.setText("Connexion");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 190, -1, -1));

        signInButton.setText("Inscription");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });
        add(signInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 190, -1, -1));

        pseudoErrors.setForeground(new java.awt.Color(255, 0, 0));
        add(pseudoErrors, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        passwordErrors.setForeground(new java.awt.Color(255, 0, 0));
        add(passwordErrors, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void pseudoTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pseudoTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pseudoTextBoxActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost

    }//GEN-LAST:event_formFocusLost

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        this.m_mainFrame.deleteModal();
        this.m_mainFrame.addView(MainFrame.modalView.SignInView);
    }//GEN-LAST:event_signInButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        Boolean autenth;
        this.cleanLabels();
        if (checkValues()) {
            autenth = User.controlLogin(this.pseudoTextBox.getText(), this.passwordTextBox.getText());
            if (autenth) {                
                Main.userPseudo = this.pseudoTextBox.getText();
                this.m_mainFrame.deleteModal();
            } else {
                
                this.pseudoErrors.setText("Erreur de connexion ! ");
                this.passwordErrors.setText("Identifiants invalides !");
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void pseudoTextBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pseudoTextBoxFocusGained
        this.pseudoTextBox.setText("");
    }//GEN-LAST:event_pseudoTextBoxFocusGained

    private void passwordTextBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextBoxFocusGained
        this.passwordTextBox.setText("");
    }//GEN-LAST:event_passwordTextBoxFocusGained
    
    private Boolean checkValues() {
        Boolean error = true;
        if (this.pseudoTextBox.getText().isEmpty()) {
            this.pseudoErrors.setText("Pseudo manquant !");
            error = false;
        }
        if (this.passwordTextBox.getText().isEmpty()) {
            this.passwordErrors.setText("Mot de passe manquant !");
            error = false;
        }
        return error;
    }

     private void cleanLabels() {
        this.pseudoErrors.setText("");
        this.passwordErrors.setText("");
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel padlockIconLabel;
    private javax.swing.JLabel passwordErrors;
    private javax.swing.JTextField passwordTextBox;
    private javax.swing.JLabel pseudoErrors;
    private javax.swing.JTextField pseudoTextBox;
    private javax.swing.JButton signInButton;
    private javax.swing.JLabel userIconLabel;
    // End of variables declaration//GEN-END:variables
}
