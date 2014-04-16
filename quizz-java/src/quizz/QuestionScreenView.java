/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import quizz.model.Quizz;
import quizz.model.Question;
import quizz.model.Answer;
import quizz.model.Score;
import quizz.model.User;

/**
 *
 * @author Vince
 */
public class QuestionScreenView extends BrainStormingView {

    private int m_idQuizz;
    private int m_numberOfGoodAnswers;
    private int m_currentQuestionNumber;
    private Timestamp m_startTime;
    private ArrayList<JCheckBox> m_checkboxList;
    private ArrayList<Question> m_questionsList;
    private ArrayList<Answer> m_answersList;
    private ArrayList<JLabel> m_circleButtonsList;

    public QuestionScreenView(MainFrame mainFrame, Quizz quizz) {
        super(mainFrame);
        initComponents();
        m_idQuizz = quizz.getId();
        m_startTime = new Timestamp(System.currentTimeMillis());
        m_numberOfGoodAnswers = 0;
        m_currentQuestionNumber = 0;
        m_questionsList = Question.getQuestionsForQuizz(m_idQuizz);
        titleLabel.setText(quizz.getName());
        this.addCheckboxToList();
        this.reloadQuestion();
        this.createBottomCircleButtons(quizz.getNbQuest());
    }

    private void addCheckboxToList() {
        m_checkboxList = new ArrayList<>();
        m_checkboxList.add(answerLabel1);
        m_checkboxList.add(answerLabel2);
        m_checkboxList.add(answerLabel3);
        m_checkboxList.add(answerLabel4);
    }

    private void reloadQuestion() {
        Question question = m_questionsList.get(m_currentQuestionNumber);
        questionLabel.setText(question.getLabel());
        m_answersList = Answer.getAnswerForQuestion(question.getId());
        this.hideAnswersCheckboxs();

        for (int i = 0; i < m_answersList.size(); i++) {
            m_checkboxList.get(i).setVisible(true);
            m_checkboxList.get(i).setText(m_answersList.get(i).getLabel());
        }
    }

    private void hideAnswersCheckboxs() {
        for (int i = 0; i < m_checkboxList.size(); i++) {
            m_checkboxList.get(i).setVisible(false);
            m_checkboxList.get(i).setSelected(false);
        }
    }

    private void reloadBottomCirleButtons() {
        for (int i = 0; i < m_questionsList.size(); i++) {
            if (i <= m_currentQuestionNumber) {
                m_circleButtonsList.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
            } else {
                m_circleButtonsList.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png")));
            }
        }
    }

    private void createBottomCircleButtons(int numberOfQuestions) {
        m_circleButtonsList = new ArrayList<>();
        int startPoint = (m_mainFrame.getWidth() - (numberOfQuestions * 20)) / 2;
        for (int i = 0; i < numberOfQuestions; i++) {
            JLabel circleButton = new javax.swing.JLabel();
            if (i > 0) {
                circleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png")));
            } else {
                circleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
            }
            this.add(circleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(startPoint + (20 * i), 550, -1, -1));
            m_circleButtonsList.add(circleButton);
        }
    }

    private void checkAnswers() {
        boolean answerIsGood = false;
        for (int i = 0; i < m_checkboxList.size(); i++) {
            if (m_checkboxList.get(i).isSelected()) { 
                answerIsGood = m_answersList.get(i).isValid();
            }
        }
        if (answerIsGood) {
            m_numberOfGoodAnswers++;
        } else {
            m_numberOfGoodAnswers--;
        }
        System.out.println("Nombre de reponses correctes : " + (m_numberOfGoodAnswers < 0 ? 0 : m_numberOfGoodAnswers) + "/" + m_questionsList.size());
        System.out.println("Pourcentage : ");
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
        heart1 = new javax.swing.JLabel();
        heart2 = new javax.swing.JLabel();
        heart3 = new javax.swing.JLabel();
        heart4 = new javax.swing.JLabel();
        heart5 = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        questionPicture = new javax.swing.JLabel();
        answerLabel4 = new javax.swing.JCheckBox();
        answerLabel1 = new javax.swing.JCheckBox();
        answerLabel2 = new javax.swing.JCheckBox();
        answerLabel3 = new javax.swing.JCheckBox();
        arrowLeft = new javax.swing.JLabel();
        arrowRight = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 493));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 38, 720, -1));

        titleLabel.setFont(Main.s_openSansTitle);
        titleLabel.setForeground(new java.awt.Color(40, 40, 40));
        titleLabel.setText("Créer un Quizz");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 5, 150, -1));

        heart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/heartFull-20.png"))); // NOI18N
        add(heart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        heart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/heartFull-20.png"))); // NOI18N
        add(heart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        heart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/heartFull-20.png"))); // NOI18N
        add(heart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        heart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/heartFull-20.png"))); // NOI18N
        add(heart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        heart5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/heartEmpty-20.png"))); // NOI18N
        add(heart5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        questionLabel.setText("Question ?");
        add(questionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 500, 60));

        questionPicture.setToolTipText("");
        add(questionPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 220, 120));

        answerLabel4.setLabel("Réponse 4");
        add(answerLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 400, -1));

        answerLabel1.setLabel("Réponse 1");
        add(answerLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 400, -1));

        answerLabel2.setLabel("Réponse 2");
        add(answerLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 400, -1));

        answerLabel3.setLabel("Réponse 3");
        add(answerLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 400, -1));

        arrowLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/arrowLeft-60.png"))); // NOI18N
        arrowLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToPrevious(evt);
            }
        });
        add(arrowLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        arrowRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/arrowRight-60.png"))); // NOI18N
        arrowRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToNextQuestion(evt);
            }
        });
        add(arrowRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, -1, -1));

        userLabel.setFont(quizz.Main.s_openSans13);
        userLabel.setForeground(new java.awt.Color(102, 102, 102));
        userLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/userIcon-20.png"))); // NOI18N
        userLabel.setText(Main.userPseudo);
        userLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLabelMouseClicked(evt);
            }
        });
        add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 10, -1, -1));

        backButton.setText("Quitter");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonAction(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 540, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void goToPrevious(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToPrevious
        if (m_currentQuestionNumber > 0) {
            m_currentQuestionNumber--;
            this.reloadQuestion();
            this.reloadBottomCirleButtons();
        }
    }//GEN-LAST:event_goToPrevious

    private void goToNextQuestion(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToNextQuestion
        if (m_currentQuestionNumber < m_questionsList.size() - 1) {
            m_currentQuestionNumber++;
            this.checkAnswers();
            this.reloadQuestion();
            this.reloadBottomCirleButtons();
        } else {
            Timestamp ts = new Timestamp(m_startTime.compareTo(new Timestamp(System.currentTimeMillis())));
            Score score = new Score(m_idQuizz, m_numberOfGoodAnswers, m_questionsList.size(), ts);
            m_mainFrame.changeView(MainFrame.View.ResultsView, score);
        }
    }//GEN-LAST:event_goToNextQuestion

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLabelMouseClicked
        m_mainFrame.addView(MainFrame.modalView.LoginView);
    }//GEN-LAST:event_userLabelMouseClicked

    private void quitButtonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonAction
        m_mainFrame.changeView(MainFrame.View.MainScreenView);
    }//GEN-LAST:event_quitButtonAction


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox answerLabel1;
    private javax.swing.JCheckBox answerLabel2;
    private javax.swing.JCheckBox answerLabel3;
    private javax.swing.JCheckBox answerLabel4;
    private javax.swing.JLabel arrowLeft;
    private javax.swing.JLabel arrowRight;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel heart1;
    private javax.swing.JLabel heart2;
    private javax.swing.JLabel heart3;
    private javax.swing.JLabel heart4;
    private javax.swing.JLabel heart5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionPicture;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables

}