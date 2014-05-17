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
public class QuizzDetailsView extends BrainStormingView {

    /**
     * Creates new form QuizzDetailsView
     */
    public QuizzDetailsView(MainFrame main, Score score) {
        super(main);
        initComponents();
        this.goodAnswersValueLabel.setText(Integer.toString(score.getNumberOfGoodAnswers()));
        this.scoreValueLabel.setText(Integer.toString(score.getScore()));
        long secondes = (score.getTime() / 1000) % 60;
        long minutes = ((score.getTime() / 1000) / 60) % 60;
        long heures = (score.getTime() / 1000) / 3600;
        this.timeValueLabel.setText(heures + " heures " + minutes + " minutes et " + secondes + " secondes.");
        this.nbParticipantValueLabel.setText(Integer.toString(score.getNbQuizz()));
        this.pourcentageValueLabel.setText(Integer.toString(score.goodAnswersPourcentage()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        mainPanel3 = new RoundedPanel();
        goodAnswersLabel = new javax.swing.JLabel();
        pourcentageLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        rankingLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        subtitleLabel3 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        goodAnswersValueLabel = new javax.swing.JLabel();
        pourcentageValueLabel = new javax.swing.JLabel();
        scoreValueLabel = new javax.swing.JLabel();
        nbParticipantValueLabel = new javax.swing.JLabel();
        timeValueLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        backButton.setText("Acceuil");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonbackAction(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        mainPanel3.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel3.setForeground(new java.awt.Color(102, 102, 102));
        mainPanel3.setMaximumSize(new java.awt.Dimension(500, 300));
        mainPanel3.setMinimumSize(new java.awt.Dimension(500, 300));
        mainPanel3.setPreferredSize(new java.awt.Dimension(500, 300));
        mainPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goodAnswersLabel.setFont(Main.s_openSans13);
        goodAnswersLabel.setText("Moyenne bonnes réponses");
        mainPanel3.add(goodAnswersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        pourcentageLabel.setFont(Main.s_openSans13);
        pourcentageLabel.setText("Pourcentage");
        mainPanel3.add(pourcentageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        scoreLabel.setFont(Main.s_openSans13);
        scoreLabel.setText("Score moyen");
        mainPanel3.add(scoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        rankingLabel.setFont(Main.s_openSans13);
        rankingLabel.setText("Nombre de participants");
        mainPanel3.add(rankingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        timeLabel.setFont(Main.s_openSans13);
        timeLabel.setText("Temps moyen");
        mainPanel3.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        subtitleLabel3.setFont(Main.s_openSansTitle);
        subtitleLabel3.setText("Résultat");
        mainPanel3.add(subtitleLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        mainPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, 180));
        mainPanel3.add(goodAnswersValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));
        mainPanel3.add(pourcentageValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));
        mainPanel3.add(scoreValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));
        mainPanel3.add(nbParticipantValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));
        mainPanel3.add(timeValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 240, -1, -1));

        add(mainPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 179, -1, -1));

        titleLabel.setFont(Main.s_openSansTitle);
        titleLabel.setForeground(new java.awt.Color(40, 40, 40));
        titleLabel.setText("Statistiques du quizz");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 0, -1, -1));

        jSeparator7.setForeground(new java.awt.Color(102, 102, 102));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 38, 720, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonbackAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonbackAction
        this.m_mainFrame.changeView(MainFrame.View.AdminScreenView);
    }//GEN-LAST:event_backButtonbackAction

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel goodAnswersLabel;
    private javax.swing.JLabel goodAnswersValueLabel;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JPanel mainPanel3;
    private javax.swing.JLabel nbParticipantValueLabel;
    private javax.swing.JLabel pourcentageLabel;
    private javax.swing.JLabel pourcentageValueLabel;
    private javax.swing.JLabel rankingLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreValueLabel;
    private javax.swing.JLabel subtitleLabel3;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeValueLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
