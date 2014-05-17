/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import quizz.model.Quizz;
import quizz.model.Question;
import quizz.model.Answer;
import quizz.model.Score;

/**
 *
 * @author Vince
 */
public class QuestionScreenView extends BrainStormingView {

    private final String circleNew = "/quizz/assets/circleNew-15.png";
    private final String circleEmpty = "/quizz/assets/circleEmpty-15.png";
    private final String circleFull = "/quizz/assets/circleFull-15.png";
    private final String circleDashed = "/quizz/assets/circleDashed-15.png";

    private boolean m_allQuestionsWasDisplayed;
    private int m_idQuizz;
    private int m_currentQuestionNumber;
    private Timestamp m_startTime;
    private Timer m_timer;
    private long m_timeInMillisecondes;
    private ArrayList<JCheckBox> m_checkboxList;
    private ArrayList<JLabel> m_answersImagesList;
    private ArrayList<Question> m_questionsList;
    private ArrayList<Answer> m_answersList;
    private ArrayList<JLabel> m_circleButtonsList;
    private ArrayList<HashMap<Integer, Boolean>> m_answersDictionary;

    public QuestionScreenView(MainFrame mainFrame, Quizz quizz) {
        super(mainFrame);
        initComponents();
        this.initializeTimer(quizz.getTimeMax());
        m_idQuizz = quizz.getId();
        m_startTime = new Timestamp(System.currentTimeMillis());
        m_currentQuestionNumber = 0;
        m_questionsList = Question.getQuestionsForQuizz(m_idQuizz);
        this.shuffleQuestions();
        m_allQuestionsWasDisplayed = false;
        m_answersDictionary = this.defineAnswersDictionary(m_questionsList.size());
        titleLabel.setText(quizz.getName());
        this.addCheckboxToList();
        this.addAnswersImagesToList();
        this.reloadQuestion();
        this.createBottomCircleButtons(quizz.getNbQuest());
    }

    private void initializeTimer(long time) {
        if (time > 1000) {
            m_timeInMillisecondes = time;
            m_timer = new Timer();
            m_timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    m_timeInMillisecondes--;
                    long secondes = (m_timeInMillisecondes / 1000) % 60;
                    long minutes = ((m_timeInMillisecondes / 1000) / 60) % 60;
                    //long heures = (m_timeInMillisecondes / 1000) / 3600;
                    timerLabel.setText((minutes < 10 ? ("0" + minutes) : minutes) + ":" + (secondes < 10 ? ("0" + secondes) : secondes) + "");
                    if (m_timeInMillisecondes == 0) {
                        m_timer.cancel();
                        m_timer.purge();
                        goToResultsView();
                    }
                }
            }, 0, 1);
        } else {
            timerLabel.setVisible(false);
        }
    }

    private ArrayList<HashMap<Integer, Boolean>> defineAnswersDictionary(int arrayLength) {
        ArrayList<HashMap<Integer, Boolean>> answersDictionary = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            HashMap<Integer, Boolean> dicoTemplate = new HashMap<>();
            dicoTemplate.put(-2, null); // Si aucune reponse n'a ete selectionnee.
            dicoTemplate.put(-1, false); // Si la question est juste ou non.
            dicoTemplate.put(0, false);
            dicoTemplate.put(1, false);
            dicoTemplate.put(2, false);
            dicoTemplate.put(3, false);
            answersDictionary.add(dicoTemplate);
        }
        return answersDictionary;
    }

    private void addCheckboxToList() {
        m_checkboxList = new ArrayList<>();
        m_checkboxList.add(answerLabel1);
        m_checkboxList.add(answerLabel2);
        m_checkboxList.add(answerLabel3);
        m_checkboxList.add(answerLabel4);
    }

    private void addAnswersImagesToList() {
        m_answersImagesList = new ArrayList<>();
        m_answersImagesList.add(imageLabel1);
        m_answersImagesList.add(imageLabel2);
        m_answersImagesList.add(imageLabel3);
        m_answersImagesList.add(imageLabel4);
    }

    private void addAnswerImageListener(JLabel label, final String questionImageLink, final String answerImageLink) {
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reloadPictureLabel(answerImageLink);
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        reloadPictureLabel(questionImageLink);
                    }
                }, 3000, 3000);
            }
        });
    }

    private void hideAnswersCheckboxsAndImages() {
        for (int i = 0; i < m_checkboxList.size(); i++) {
            m_checkboxList.get(i).setVisible(false);
            m_checkboxList.get(i).setSelected(false);
            m_answersImagesList.get(i).setVisible(false);
        }
    }

    private void createBottomCircleButtons(int numberOfQuestions) {
        m_circleButtonsList = new ArrayList<>();
        int startPoint = (m_mainFrame.getWidth() - (numberOfQuestions * 20)) / 2;
        for (int i = 0; i < numberOfQuestions; i++) {
            JLabel circleButton = new javax.swing.JLabel();
            if (i > 0) {
                circleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(circleNew)));
            } else {
                circleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(circleDashed)));
            }
            this.add(circleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(startPoint + (20 * i), 550, -1, -1));
            m_circleButtonsList.add(circleButton);
        }
    }

    private void reloadBottomCirleButtons() {
        for (int i = 0; i < m_questionsList.size(); i++) {
            if (i == m_currentQuestionNumber) {
                if (m_currentQuestionNumber == m_questionsList.size() - 1) {
                    m_allQuestionsWasDisplayed = true;
                }
                m_circleButtonsList.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource(circleDashed)));
            } else if (m_answersDictionary.get(i).get(-2) == null && !m_allQuestionsWasDisplayed) {
                m_circleButtonsList.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource(circleNew)));
            } else if (m_answersDictionary.get(i).get(-2)) {
                m_circleButtonsList.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource(circleEmpty)));
            } else if (!m_answersDictionary.get(i).get(-2)) {
                m_circleButtonsList.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource(circleFull)));
            }
        }
    }

    private void checkAnswers() {
        boolean answerIsGood = true;
        int notSelectedNumber = 0;
        for (int i = 0; i < m_answersList.size(); i++) {
            if (m_checkboxList.get(i).isSelected()) {
                m_answersDictionary.get(m_currentQuestionNumber).put(i, true);
                if (!m_answersList.get(i).isValid()) {
                    answerIsGood = false;
                }
            } else {
                m_answersDictionary.get(m_currentQuestionNumber).put(i, false);
                notSelectedNumber++;
            }
        }

        if (answerIsGood && notSelectedNumber < m_answersList.size()) {
            m_answersDictionary.get(m_currentQuestionNumber).put(-1, true);
            m_answersDictionary.get(m_currentQuestionNumber).put(-2, false);
        } else {
            m_answersDictionary.get(m_currentQuestionNumber).put(-1, false);
            if (notSelectedNumber == m_answersList.size()) {
                m_answersDictionary.get(m_currentQuestionNumber).put(-2, true);
            } else {
                m_answersDictionary.get(m_currentQuestionNumber).put(-2, false);
            }
        }
        System.out.println("Nombre de reponses correctes : " + this.numberOfPoints() + "/" + m_questionsList.size());
    }

    private void shuffleQuestions() {
        long seed = System.nanoTime();
        Collections.shuffle(m_questionsList, new Random(seed));
    }

    private void reloadQuestion() {
        Question question = m_questionsList.get(m_currentQuestionNumber);
        questionTextPane.setText(question.getLabel());
        StyledDocument doc = questionTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        this.reloadPictureLabel(question.getPicture());
        m_answersList = Answer.getAnswerForQuestion(question.getId());
        this.hideAnswersCheckboxsAndImages();

        for (int i = 0; i < m_answersList.size(); i++) {
            m_checkboxList.get(i).setVisible(true);
            m_checkboxList.get(i).setText(m_answersList.get(i).getLabel());
            m_checkboxList.get(i).setSelected(m_answersDictionary.get(m_currentQuestionNumber).get(i));
            if (m_answersList.get(i).getPicture() != null) {
                m_answersImagesList.get(i).setVisible(true);
                this.addAnswerImageListener(m_answersImagesList.get(i), question.getPicture(), m_answersList.get(i).getPicture());
            }
        }
    }

    /**
     * Reload the picture label for each question
     *
     * @param actualQuestion the actual question
     */
    private void reloadPictureLabel(final String path) {
        if (path != null && !path.isEmpty()) {
            try {
                URL url = new URL(path);
                BufferedImage image = ImageIO.read(url);
                this.picture_label.setIcon(new ImageIcon(image));
            } catch (IOException ex) {
                Logger.getLogger(QuestionScreenView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.picture_label.setIcon(null);
        }
    }

    private int numberOfPoints() {
        int points = 0;
        for (int i = 0; i < m_answersDictionary.size(); i++) {
            if (m_answersDictionary.get(i).get(-1)) {
                points++;
            }
        }
        return points;
    }

    private void goToResultsView() {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        long diffInMillis = currentTime.getTime() - m_startTime.getTime();
        Score score = new Score(m_idQuizz, this.numberOfPoints(), m_questionsList.size(), diffInMillis, Score.getClassementForAQuizz(m_idQuizz, this.numberOfPoints()), Main.idPseudo);
        this.m_mainFrame.setScore(score);
        m_mainFrame.changeView(MainFrame.View.ResultsView);
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
        answerLabel1 = new javax.swing.JCheckBox();
        answerLabel2 = new javax.swing.JCheckBox();
        answerLabel3 = new javax.swing.JCheckBox();
        answerLabel4 = new javax.swing.JCheckBox();
        arrowLeft = new javax.swing.JLabel();
        arrowRight = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        picture_label = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        questionTextPane = new javax.swing.JTextPane();
        timerLabel = new javax.swing.JLabel();
        imageLabel1 = new javax.swing.JLabel();
        imageLabel2 = new javax.swing.JLabel();
        imageLabel3 = new javax.swing.JLabel();
        imageLabel4 = new javax.swing.JLabel();

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
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 5, 220, -1));

        answerLabel1.setLabel("Réponse 1");
        add(answerLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 400, -1));

        answerLabel2.setLabel("Réponse 2");
        add(answerLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 400, -1));

        answerLabel3.setLabel("Réponse 3");
        add(answerLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 400, -1));

        answerLabel4.setLabel("Réponse 4");
        add(answerLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 400, -1));

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
        add(picture_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 570, 220));

        jScrollPane.setBorder(null);

        questionTextPane.setEditable(false);
        questionTextPane.setBorder(null);
        questionTextPane.setText("Question ?");
        jScrollPane.setViewportView(questionTextPane);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 285, 500, 40));

        timerLabel.setFont(Main.s_openSansTitle);
        timerLabel.setForeground(new java.awt.Color(40, 40, 40));
        timerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/time-25.png"))); // NOI18N
        timerLabel.setText("Timer");
        add(timerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 5, 110, -1));

        imageLabel1.setForeground(new java.awt.Color(0, 0, 255));
        imageLabel1.setText("> Image <");
        add(imageLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, 23));

        imageLabel2.setForeground(new java.awt.Color(0, 0, 255));
        imageLabel2.setText("> Image <");
        add(imageLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, -1, 23));

        imageLabel3.setForeground(new java.awt.Color(0, 0, 255));
        imageLabel3.setText("> Image <");
        add(imageLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, 23));

        imageLabel4.setForeground(new java.awt.Color(0, 0, 255));
        imageLabel4.setText("> Image <");
        add(imageLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, 23));
    }// </editor-fold>//GEN-END:initComponents

    private void goToPrevious(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToPrevious
        this.checkAnswers();
        if (m_currentQuestionNumber > 0) {
            m_currentQuestionNumber--;
            this.reloadQuestion();
            this.checkAnswers();
            this.reloadBottomCirleButtons();
        }
    }//GEN-LAST:event_goToPrevious

    private void goToNextQuestion(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToNextQuestion
        this.checkAnswers();
        if (m_currentQuestionNumber < m_questionsList.size() - 1) {
            m_currentQuestionNumber++;
            this.reloadQuestion();
            this.reloadBottomCirleButtons();
        } else {
            this.goToResultsView();
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
    private javax.swing.JLabel imageLabel1;
    private javax.swing.JLabel imageLabel2;
    private javax.swing.JLabel imageLabel3;
    private javax.swing.JLabel imageLabel4;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel picture_label;
    private javax.swing.JTextPane questionTextPane;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables

}
