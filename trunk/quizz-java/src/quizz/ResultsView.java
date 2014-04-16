/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import quizz.model.Score;

/**
 *
 * @author Gautier
 */
public class ResultsView extends BrainStormingView {

    /**
     * Creates new form AfterQuizzPanel
     * @param main
     */
    public ResultsView(MainFrame main, Score score) {
        super(main);
        if (Main.userPseudo != "User")
        {
            this.saveScore();
        }
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

        jSeparator1 = new javax.swing.JSeparator();
        titleLabel = new javax.swing.JLabel();
        mainPanel = new RoundedPanel();
        goodAnswersLabel = new javax.swing.JLabel();
        pourcentageLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        rankingLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        subtitleLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        goodAnswersValueLabel = new javax.swing.JLabel();
        pourcentageValueLabel = new javax.swing.JLabel();
        scoreValueLabel = new javax.swing.JLabel();
        rankingValueLabel = new javax.swing.JLabel();
        timeValueLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        if (Main.userPseudo == "User")
        {
            validateScoreButton = new javax.swing.JButton();

            setBackground(new java.awt.Color(255, 255, 255));
            setMaximumSize(new java.awt.Dimension(800, 600));
            setMinimumSize(new java.awt.Dimension(800, 600));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
            add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 38, 720, -1));

            titleLabel.setFont(Main.s_openSansTitle);
            titleLabel.setForeground(new java.awt.Color(40, 40, 40));
            titleLabel.setText("Résultats du quizz");
            add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 0, -1, -1));

            mainPanel.setBackground(new java.awt.Color(255, 255, 255));
            mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            mainPanel.setForeground(new java.awt.Color(102, 102, 102));
            mainPanel.setMaximumSize(new java.awt.Dimension(500, 300));
            mainPanel.setMinimumSize(new java.awt.Dimension(500, 300));
            mainPanel.setPreferredSize(new java.awt.Dimension(500, 300));
            mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            goodAnswersLabel.setFont(Main.s_openSans13);
            goodAnswersLabel.setText("Bonnes réponses");
            mainPanel.add(goodAnswersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

            pourcentageLabel.setFont(Main.s_openSans13);
            pourcentageLabel.setText("Pourcentage");
            mainPanel.add(pourcentageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

            scoreLabel.setFont(Main.s_openSans13);
            scoreLabel.setText("Score");
            mainPanel.add(scoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

            rankingLabel.setFont(Main.s_openSans13);
            rankingLabel.setText("Classement");
            mainPanel.add(rankingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

            timeLabel.setFont(Main.s_openSans13);
            timeLabel.setText("Temps");
            mainPanel.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

            subtitleLabel.setFont(Main.s_openSansTitle);
            subtitleLabel.setText("Résultat");
            mainPanel.add(subtitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 12, -1, -1));

            jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
            mainPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, 180));
            mainPanel.add(goodAnswersValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));
            mainPanel.add(pourcentageValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));
            mainPanel.add(scoreValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));
            mainPanel.add(rankingValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));
            mainPanel.add(timeValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

            add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

            backButton.setText("Acceuil");
            backButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    backButtonbackAction(evt);
                }
            });
            add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

            userLabel.setFont(quizz.Main.s_openSans13);
            userLabel.setForeground(new java.awt.Color(102, 102, 102));
            userLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/userIcon-20.png"))); // NOI18N
            userLabel.setText(Main.userPseudo);
            userLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    userLabelMouseClicked(evt);
                }
            });
            add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 6, -1, -1));

            validateScoreButton.setText("Enregister le score");
            validateScoreButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    validateScoreButtonActionPerformed(evt);
                }
            });
            add(validateScoreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 520, -1, -1));
        }
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonbackAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonbackAction
        m_mainFrame.changeView(MainFrame.View.MainScreenView);
    }//GEN-LAST:event_backButtonbackAction

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLabelMouseClicked
        m_mainFrame.addView(MainFrame.modalView.LoginView);
    }//GEN-LAST:event_userLabelMouseClicked

    private void validateScoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateScoreButtonActionPerformed
        m_mainFrame.addView(MainFrame.modalView.LoginView);
    }//GEN-LAST:event_validateScoreButtonActionPerformed

    private void saveScore() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel goodAnswersLabel;
    private javax.swing.JLabel goodAnswersValueLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel pourcentageLabel;
    private javax.swing.JLabel pourcentageValueLabel;
    private javax.swing.JLabel rankingLabel;
    private javax.swing.JLabel rankingValueLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreValueLabel;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeValueLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JButton validateScoreButton;
    // End of variables declaration//GEN-END:variables

    
}