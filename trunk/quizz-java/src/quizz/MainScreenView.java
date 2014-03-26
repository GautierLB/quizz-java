/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.util.ArrayList;
import quizz.model.Theme;

/**
 *
 * @author Vince
 */
public class MainScreenView extends BrainStormingView {

    private ArrayList<Theme> m_themesList;
    
    public MainScreenView(MainFrame mainFrame) {
        super(mainFrame);
        initComponents();
        m_themesList = Theme.getAllThemes();
        themeLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(m_themesList.get(0).getPictureThemeBig())));
        themeLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(m_themesList.get(1).getPictureThemeBig())));
        themeLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(m_themesList.get(2).getPictureThemeBig())));
        themeLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(m_themesList.get(3).getPictureThemeBig())));
        themeLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource(m_themesList.get(4).getPictureThemeBig())));
        themeLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource(m_themesList.get(5).getPictureThemeBig())));
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
        themeLabel6 = new javax.swing.JLabel();
        themeLabel1 = new javax.swing.JLabel();
        themeLabel2 = new javax.swing.JLabel();
        themeLabel3 = new javax.swing.JLabel();
        themeLabel4 = new javax.swing.JLabel();
        themeLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainScreenTitle.setFont(quizz.Main.s_openSansTitle);
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

        themeLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/linux-100.png"))); // NOI18N
        themeLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themeLabel6MouseClicked(evt);
            }
        });
        add(themeLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 350, 100, 100));

        themeLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/linux-100.png"))); // NOI18N
        themeLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themeLabel1MouseClicked(evt);
            }
        });
        add(themeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 150, 100, 100));

        themeLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/linux-100.png"))); // NOI18N
        themeLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themeLabel2MouseClicked(evt);
            }
        });
        add(themeLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 100, 100));

        themeLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/linux-100.png"))); // NOI18N
        themeLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themeLabel3MouseClicked(evt);
            }
        });
        add(themeLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 150, 100, 100));

        themeLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/linux-100.png"))); // NOI18N
        themeLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themeLabel4MouseClicked(evt);
            }
        });
        add(themeLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 350, 100, 100));

        themeLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/linux-100.png"))); // NOI18N
        themeLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themeLabel5MouseClicked(evt);
            }
        });
        add(themeLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 100, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void createQuizzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createQuizzActionPerformed
        m_mainFrame.changeView(MainFrame.View.CreateQuizzView);
    }//GEN-LAST:event_createQuizzActionPerformed
    
    private void themeLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themeLabel1MouseClicked
        m_mainFrame.changeView(MainFrame.View.ThemeScreenView, m_themesList.get(0));
    }//GEN-LAST:event_themeLabel1MouseClicked

    private void themeLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themeLabel2MouseClicked
        m_mainFrame.changeView(MainFrame.View.ThemeScreenView, m_themesList.get(1));
    }//GEN-LAST:event_themeLabel2MouseClicked

    private void themeLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themeLabel3MouseClicked
        m_mainFrame.changeView(MainFrame.View.ThemeScreenView, m_themesList.get(2));
    }//GEN-LAST:event_themeLabel3MouseClicked

    private void themeLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themeLabel4MouseClicked
        m_mainFrame.changeView(MainFrame.View.ThemeScreenView, m_themesList.get(3));
    }//GEN-LAST:event_themeLabel4MouseClicked

    private void themeLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themeLabel5MouseClicked
        m_mainFrame.changeView(MainFrame.View.ThemeScreenView, m_themesList.get(4));
    }//GEN-LAST:event_themeLabel5MouseClicked

    private void themeLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themeLabel6MouseClicked
        m_mainFrame.changeView(MainFrame.View.ThemeScreenView, m_themesList.get(5));
    }//GEN-LAST:event_themeLabel6MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createQuizz;
    private javax.swing.JLabel mainScreenTitle;
    private javax.swing.JLabel themeLabel1;
    private javax.swing.JLabel themeLabel2;
    private javax.swing.JLabel themeLabel3;
    private javax.swing.JLabel themeLabel4;
    private javax.swing.JLabel themeLabel5;
    private javax.swing.JLabel themeLabel6;
    // End of variables declaration//GEN-END:variables
}
