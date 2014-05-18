/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import quizz.model.Score;
import quizz.model.User;

/**
 *
 * @author Gautier
 */
public class StatisticsDialogPanel extends RoundedPanel {

    /**
     * Creates new form StatisticsDialogPanel
     */
    
    private MainFrame m_mainFrame;
    
    public StatisticsDialogPanel(MainFrame mainFrame,Score score) {
        initComponents();
        m_mainFrame = mainFrame;
        this.goodAnswersValueLabel.setText(Integer.toString(score.getNumberOfGoodAnswers()));
        this.scoreValueLabel.setText(Long.toString(score.getScore()));
        this.rankingValueLabel.setText(Integer.toString(5));
        long secondes = (score.getTime() / 1000) % 60;
        long minutes = ((score.getTime() / 1000) / 60) % 60;
        long heures = (score.getTime() / 1000) / 3600;
        this.timeValueLabel.setText(heures + " heures " + minutes + " minutes et " + secondes + " secondes");
        this.nbQuizzValueLabel.setText(Integer.toString(score.getNbQuizz()));
        this.pourcentageValueLabel.setText(Integer.toString(score.goodAnswersPourcentage()));
        if(!m_mainFrame.getActiveView().equals("MainScreenView")){
            this.btDeconnexion.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        nbQuizzsLabel = new javax.swing.JLabel();
        nbQuizzValueLabel = new javax.swing.JLabel();
        btDeconnexion = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setForeground(new java.awt.Color(102, 102, 102));
        mainPanel.setMaximumSize(new java.awt.Dimension(500, 300));
        mainPanel.setMinimumSize(new java.awt.Dimension(500, 300));
        mainPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goodAnswersLabel.setFont(Main.s_openSans13);
        goodAnswersLabel.setText("Bonnes réponses");
        mainPanel.add(goodAnswersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        pourcentageLabel.setFont(Main.s_openSans13);
        pourcentageLabel.setText("Pourcentage");
        mainPanel.add(pourcentageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        scoreLabel.setFont(Main.s_openSans13);
        scoreLabel.setText("Score");
        mainPanel.add(scoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        rankingLabel.setFont(Main.s_openSans13);
        rankingLabel.setText("Classement");
        mainPanel.add(rankingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        timeLabel.setFont(Main.s_openSans13);
        timeLabel.setText("Temps");
        mainPanel.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        subtitleLabel.setFont(Main.s_openSansTitle);
        subtitleLabel.setText("Résultat");
        mainPanel.add(subtitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        mainPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, 220));
        mainPanel.add(goodAnswersValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));
        mainPanel.add(pourcentageValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));
        mainPanel.add(scoreValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));
        mainPanel.add(rankingValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));
        mainPanel.add(timeValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        nbQuizzsLabel.setFont(Main.s_openSans13);
        nbQuizzsLabel.setText("Quizzs effectués");
        mainPanel.add(nbQuizzsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));
        mainPanel.add(nbQuizzValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        btDeconnexion.setText("Deconnexion");
        btDeconnexion.setMaximumSize(new java.awt.Dimension(120, 25));
        btDeconnexion.setMinimumSize(new java.awt.Dimension(120, 25));
        btDeconnexion.setPreferredSize(new java.awt.Dimension(120, 25));
        btDeconnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDeconnexionMouseClicked(evt);
            }
        });
        mainPanel.add(btDeconnexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 360));
    }// </editor-fold>//GEN-END:initComponents

    private void btDeconnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeconnexionMouseClicked
        User.deconnexionUser();
        m_mainFrame.deleteModal();
    }//GEN-LAST:event_btDeconnexionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeconnexion;
    private javax.swing.JLabel goodAnswersLabel;
    private javax.swing.JLabel goodAnswersValueLabel;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nbQuizzValueLabel;
    private javax.swing.JLabel nbQuizzsLabel;
    private javax.swing.JLabel pourcentageLabel;
    private javax.swing.JLabel pourcentageValueLabel;
    private javax.swing.JLabel rankingLabel;
    private javax.swing.JLabel rankingValueLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreValueLabel;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeValueLabel;
    // End of variables declaration//GEN-END:variables
}