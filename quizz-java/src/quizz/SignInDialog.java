/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import javax.swing.JPasswordField;

/**
 *
 * @author Gautier
 */
public class SignInDialog extends RoundedPanel {

    /**
     * Creates new form SignInDialog
     */
    public SignInDialog() {
        initComponents();
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
        confirmPasswordTextBpx = new javax.swing.JTextField();
        passwordTextBox1 = new JPasswordField(10);
        padlockIconLabel2 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        messageIconLabel = new javax.swing.JLabel();
        signInButton = new javax.swing.JButton();

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

        passwordTextBox.setFont(Main.s_openSans13);
        passwordTextBox.setForeground(new java.awt.Color(170, 170, 170));
        passwordTextBox.setText("jTextField2");
        passwordTextBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        userIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/userIcon-25.png"))); // NOI18N

        padlockIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/padlock-25.png"))); // NOI18N

        confirmPasswordTextBpx.setFont(Main.s_openSans13);
        confirmPasswordTextBpx.setForeground(new java.awt.Color(170, 170, 170));
        confirmPasswordTextBpx.setText("jTextField2");
        confirmPasswordTextBpx.setToolTipText("");
        confirmPasswordTextBpx.setMaximumSize(new java.awt.Dimension(120, 10));
        confirmPasswordTextBpx.setMinimumSize(new java.awt.Dimension(120, 5));
        confirmPasswordTextBpx.setPreferredSize(new java.awt.Dimension(120, 5));
        confirmPasswordTextBpx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordTextBpxActionPerformed(evt);
            }
        });

        passwordTextBox1.setFont(Main.s_openSans13);
        passwordTextBox1.setForeground(new java.awt.Color(170, 170, 170));
        passwordTextBox1.setText("e-mail");
        passwordTextBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        passwordTextBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextBox1ActionPerformed(evt);
            }
        });

        padlockIconLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/padlock-25.png"))); // NOI18N

        titleLabel.setFont(Main.s_openSans28);
        titleLabel.setText("Inscription");

        messageIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/messageIcon-25.png"))); // NOI18N

        signInButton.setText("Inscription");
        signInButton.setMaximumSize(new java.awt.Dimension(100, 35));
        signInButton.setMinimumSize(new java.awt.Dimension(100, 35));
        signInButton.setPreferredSize(new java.awt.Dimension(100, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(padlockIconLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(confirmPasswordTextBpx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(messageIconLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(passwordTextBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userIconLabel)
                                    .addGap(5, 5, 5)
                                    .addComponent(pseudoTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(padlockIconLabel)
                                    .addGap(5, 5, 5)
                                    .addComponent(passwordTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(titleLabel)))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titleLabel)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userIconLabel)
                    .addComponent(pseudoTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(padlockIconLabel)
                    .addComponent(passwordTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmPasswordTextBpx, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(padlockIconLabel2))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordTextBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messageIconLabel))
                .addGap(18, 18, 18)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pseudoTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pseudoTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pseudoTextBoxActionPerformed

    private void confirmPasswordTextBpxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordTextBpxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordTextBpxActionPerformed

    private void passwordTextBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField confirmPasswordTextBpx;
    private javax.swing.JLabel messageIconLabel;
    private javax.swing.JLabel padlockIconLabel;
    private javax.swing.JLabel padlockIconLabel2;
    private javax.swing.JTextField passwordTextBox;
    private javax.swing.JTextField passwordTextBox1;
    private javax.swing.JTextField pseudoTextBox;
    private javax.swing.JButton signInButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userIconLabel;
    // End of variables declaration//GEN-END:variables
}
