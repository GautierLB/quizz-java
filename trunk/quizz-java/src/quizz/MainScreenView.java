/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

/**
 *
 * @author Vince
 */
public class MainScreenView extends javax.swing.JPanel {

    private MainFrame m_mainFrame;
    public MainScreenView(MainFrame mainFrame) {
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

        mainScreenTitle = new javax.swing.JLabel();
        createQuizz = new javax.swing.JButton();
        mainScreenBtn = new javax.swing.JButton();
        mainScreenBtn2 = new javax.swing.JButton();
        mainScreenBtn3 = new javax.swing.JButton();
        mainScreenBtn4 = new javax.swing.JButton();
        mainScreenBtn5 = new javax.swing.JButton();
        mainScreenBtn6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainScreenTitle.setFont(Main.s_openSansTitle);
        mainScreenTitle.setText("Brain Storming");
        mainScreenTitle.setName("mainScreenTitle"); // NOI18N
        add(mainScreenTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        createQuizz.setText("Créer Quizz");
        createQuizz.setActionCommand("createQuizz");
        createQuizz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createQuizzActionPerformed(evt);
            }
        });
        add(createQuizz, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, -1, 35));

        mainScreenBtn.setBackground(new java.awt.Color(255, 255, 255));
        mainScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/linux-100.png"))); // NOI18N
        mainScreenBtn.setName("mainScreenBtn"); // NOI18N
        mainScreenBtn.setPreferredSize(new java.awt.Dimension(100, 100));
        mainScreenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainScreenBtnActionPerformed(evt);
            }
        });
        add(mainScreenBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 154, -1, -1));

        mainScreenBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/chatDev.jpg"))); // NOI18N
        mainScreenBtn2.setName("mainScreenBtn3"); // NOI18N
        mainScreenBtn2.setPreferredSize(new java.awt.Dimension(100, 100));
        mainScreenBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainScreenBtn2ActionPerformed(evt);
            }
        });
        add(mainScreenBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 154, -1, -1));

        mainScreenBtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/chatDev.jpg"))); // NOI18N
        mainScreenBtn3.setName("mainScreenBtn2"); // NOI18N
        mainScreenBtn3.setPreferredSize(new java.awt.Dimension(100, 100));
        mainScreenBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainScreenBtn3ActionPerformed(evt);
            }
        });
        add(mainScreenBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 154, -1, -1));

        mainScreenBtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/chatDev.jpg"))); // NOI18N
        mainScreenBtn4.setName("mainScreenBtn4"); // NOI18N
        mainScreenBtn4.setPreferredSize(new java.awt.Dimension(100, 100));
        mainScreenBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainScreenBtn4ActionPerformed(evt);
            }
        });
        add(mainScreenBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 394, -1, -1));

        mainScreenBtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/chatDev.jpg"))); // NOI18N
        mainScreenBtn5.setName("mainScreenBtn5"); // NOI18N
        mainScreenBtn5.setPreferredSize(new java.awt.Dimension(100, 100));
        mainScreenBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainScreenBtn5ActionPerformed(evt);
            }
        });
        add(mainScreenBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 394, -1, -1));

        mainScreenBtn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/chatDev.jpg"))); // NOI18N
        mainScreenBtn6.setName("mainScreenBtn6"); // NOI18N
        mainScreenBtn6.setPreferredSize(new java.awt.Dimension(100, 100));
        mainScreenBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainScreenBtn6ActionPerformed(evt);
            }
        });
        add(mainScreenBtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 394, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void createQuizzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createQuizzActionPerformed
        m_mainFrame.changeView(MainFrame.View.CreateQuizzView);
    }//GEN-LAST:event_createQuizzActionPerformed

    private void mainScreenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainScreenBtnActionPerformed
        m_mainFrame.changeView(MainFrame.View.ThemeScreenView);
    }//GEN-LAST:event_mainScreenBtnActionPerformed

    private void mainScreenBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainScreenBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainScreenBtn3ActionPerformed

    private void mainScreenBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainScreenBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainScreenBtn2ActionPerformed

    private void mainScreenBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainScreenBtn6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainScreenBtn6ActionPerformed

    private void mainScreenBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainScreenBtn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainScreenBtn5ActionPerformed

    private void mainScreenBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainScreenBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainScreenBtn4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createQuizz;
    private javax.swing.JButton mainScreenBtn;
    private javax.swing.JButton mainScreenBtn2;
    private javax.swing.JButton mainScreenBtn3;
    private javax.swing.JButton mainScreenBtn4;
    private javax.swing.JButton mainScreenBtn5;
    private javax.swing.JButton mainScreenBtn6;
    private javax.swing.JLabel mainScreenTitle;
    // End of variables declaration//GEN-END:variables
}
