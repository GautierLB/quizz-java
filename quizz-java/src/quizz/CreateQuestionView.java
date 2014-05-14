/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import quizz.model.Quizz;
import quizz.model.Answer;
import quizz.model.Question;
import quizz.model.QuizzManager;

/**
 *
 * @author Gautier
 */
public class CreateQuestionView extends BrainStormingView {

    /**
     * Creates new form CreateQuestionView
     */
    private boolean oldQuestion = false;
    private String typeQuestion = "Both";
    private JPanel questionPanel;
    public JPanel answerPanel;
    private Quizz quizz;
    public int indexQuestion = 0;
    public int indexAnswer = 0;
    public boolean oldAnswer = false;
    public ArrayList<Question> questionList = new ArrayList();
    public ArrayList<Answer> answerList = new ArrayList<>();
    public ArrayList<ArrayList<Answer>> answerListFinal = new ArrayList<ArrayList<Answer>>();

    public enum Side {

        Left, Right
    };

    public enum Type {

        Image, Answer, ImageAnswer;
    };

    public CreateQuestionView(MainFrame mainFrame, Quizz newQuizz) {
        super(mainFrame);
        this.quizz = newQuizz;
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

        titleLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        questionNumerLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        leftTextButton = new javax.swing.JButton();
        leftImageButton = new javax.swing.JButton();
        leftBothButton = new javax.swing.JButton();
        arrowLeft = new javax.swing.JLabel();
        arrowRight = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        rightTextButton = new javax.swing.JButton();
        rightImageButton = new javax.swing.JButton();
        rightBothButton = new javax.swing.JButton();
        rightPanel = new ImagePanel(true,this);
        leftPanel = new ImageAnswerPanel(false,this);
        SubmitQuizzButton = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(Main.s_openSansTitle);
        titleLabel.setForeground(new java.awt.Color(40, 40, 40));
        titleLabel.setText("Créer une Question");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 0, -1, -1));

        userLabel.setFont(Main.s_openSans13);
        userLabel.setForeground(new java.awt.Color(102, 102, 102));
        userLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/userIcon-20.png"))); // NOI18N
        userLabel.setText(Main.userPseudo);
        userLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLabelMouseClicked(evt);
            }
        });
        add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 6, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 38, 720, -1));

        questionNumerLabel.setFont(Main.s_openSansItalic16);
        questionNumerLabel.setText("Question N°0");
        add(questionNumerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        backButton.setText("Retour");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonbackAction(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        leftTextButton.setBackground(new java.awt.Color(249, 249, 249));
        leftTextButton.setFont(Main.s_openSans13);
        leftTextButton.setLabel("Texte");
        leftTextButton.setMaximumSize(new java.awt.Dimension(90, 35));
        leftTextButton.setMinimumSize(new java.awt.Dimension(90, 35));
        leftTextButton.setPreferredSize(new java.awt.Dimension(90, 35));
        leftTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftTextButtonActionPerformed(evt);
            }
        });
        add(leftTextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        leftImageButton.setBackground(new java.awt.Color(249, 249, 249));
        leftImageButton.setFont(Main.s_openSans13);
        leftImageButton.setLabel("Image");
        leftImageButton.setMaximumSize(new java.awt.Dimension(90, 35));
        leftImageButton.setMinimumSize(new java.awt.Dimension(90, 35));
        leftImageButton.setPreferredSize(new java.awt.Dimension(90, 35));
        leftImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftImageButtonActionPerformed(evt);
            }
        });
        add(leftImageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        leftBothButton.setBackground(new java.awt.Color(249, 249, 249));
        leftBothButton.setFont(Main.s_openSans13);
        leftBothButton.setLabel("Les Deux");
        leftBothButton.setMaximumSize(new java.awt.Dimension(90, 35));
        leftBothButton.setMinimumSize(new java.awt.Dimension(90, 35));
        leftBothButton.setPreferredSize(new java.awt.Dimension(90, 35));
        leftBothButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftBothButtonActionPerformed(evt);
            }
        });
        add(leftBothButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        arrowLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/arrowLeft-60.png"))); // NOI18N
        arrowLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrowLeftgoToPrevious(evt);
            }
        });
        add(arrowLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        arrowRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/arrowRight-60.png"))); // NOI18N
        arrowRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrowRightgoToNextQuestion(evt);
            }
        });
        add(arrowRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setMaximumSize(new java.awt.Dimension(1, 400));
        jSeparator2.setMinimumSize(new java.awt.Dimension(1, 400));
        jSeparator2.setPreferredSize(new java.awt.Dimension(1, 400));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        rightTextButton.setBackground(new java.awt.Color(249, 249, 249));
        rightTextButton.setFont(Main.s_openSans13);
        rightTextButton.setLabel("Texte");
        rightTextButton.setMaximumSize(new java.awt.Dimension(90, 35));
        rightTextButton.setMinimumSize(new java.awt.Dimension(90, 35));
        rightTextButton.setPreferredSize(new java.awt.Dimension(90, 35));
        rightTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightTextButtonActionPerformed(evt);
            }
        });
        add(rightTextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        rightImageButton.setBackground(new java.awt.Color(249, 249, 249));
        rightImageButton.setFont(Main.s_openSans13);
        rightImageButton.setLabel("Image");
        rightImageButton.setMaximumSize(new java.awt.Dimension(90, 35));
        rightImageButton.setMinimumSize(new java.awt.Dimension(90, 35));
        rightImageButton.setPreferredSize(new java.awt.Dimension(90, 35));
        rightImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightImageButtonActionPerformed(evt);
            }
        });
        add(rightImageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, -1));

        rightBothButton.setBackground(new java.awt.Color(249, 249, 249));
        rightBothButton.setFont(Main.s_openSans13);
        rightBothButton.setLabel("Les Deux");
        rightBothButton.setMaximumSize(new java.awt.Dimension(90, 35));
        rightBothButton.setMinimumSize(new java.awt.Dimension(90, 35));
        rightBothButton.setPreferredSize(new java.awt.Dimension(90, 35));
        rightBothButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightBothButtonActionPerformed(evt);
            }
        });
        add(rightBothButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, -1));

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rightPanel.setForeground(new java.awt.Color(102, 102, 102));
        rightPanel.setMaximumSize(new java.awt.Dimension(309, 257));
        rightPanel.setMinimumSize(new java.awt.Dimension(309, 257));
        rightPanel.setPreferredSize(new java.awt.Dimension(309, 307));
        add(rightPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        leftPanel.setMaximumSize(new java.awt.Dimension(309, 307));
        leftPanel.setMinimumSize(new java.awt.Dimension(309, 307));
        leftPanel.setPreferredSize(new java.awt.Dimension(309, 307));
        add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        SubmitQuizzButton.setText("Valider le quizz");
        SubmitQuizzButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        SubmitQuizzButton.setMaximumSize(new java.awt.Dimension(100, 20));
        SubmitQuizzButton.setMinimumSize(new java.awt.Dimension(100, 20));
        SubmitQuizzButton.setPreferredSize(new java.awt.Dimension(100, 20));
		SubmitQuizzButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTheQuizz(evt);
            }
        });
        add(SubmitQuizzButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, -1, -1));
        SubmitQuizzButton.getAccessibleContext().setAccessibleName("SubmitQuizzButton");

        errorLabel.setFont(Main.s_openSans13);
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLabelMouseClicked
        m_mainFrame.addView(MainFrame.modalView.LoginView);
    }//GEN-LAST:event_userLabelMouseClicked

    private void backButtonbackAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonbackAction
        m_mainFrame.changeView(MainFrame.View.CreateQuizzView);
    }//GEN-LAST:event_backButtonbackAction

    private void arrowLeftgoToPrevious(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrowLeftgoToPrevious
        Question questionCreate;

        switch (controlQuestion()) {
            case 0:
                if (typeQuestion.equals("Text")) {
                    AnswerPanel usedPanel = (AnswerPanel) questionPanel;
                    questionCreate = new Question(usedPanel.getText(), "");
                    questionCreate.setType("Text");
                    usedPanel.setText("");
                } else if (typeQuestion.equals("Image")) {
                    ImagePanel usedPanel = (ImagePanel) questionPanel;
                    questionCreate = new Question("", usedPanel.getUrlPicture());
                    questionCreate.setType("Image");
                    usedPanel.setUrlPicture("");
                } else {
                    ImageAnswerPanel usedPanel = (ImageAnswerPanel) questionPanel;
                    questionCreate = new Question(usedPanel.getText(), usedPanel.getUrlPicture());
                    questionCreate.setType("Both");
                    usedPanel.setText("");
                    usedPanel.setUrlPicture("");
                }
                if (oldQuestion) {
                    questionList.set(indexQuestion, questionCreate);
                    answerListFinal.set(indexQuestion, answerList);
                } else {
                    questionList.add(questionCreate);
                    answerListFinal.add(answerList);
                }


                if (indexQuestion != 0) {
                    indexQuestion--;
                    questionNumerLabel.setText("Question N°" + (indexQuestion + 1));
                    oldQuestion = true;
                    Question previousQuestion = questionList.get(indexQuestion);
                    if (previousQuestion.getType().equals("Text")) {
                        questionPanel = this.setNewLayout(Type.Answer, Side.Left);
                        typeQuestion = "Text";
                        AnswerPanel usedPanel = (AnswerPanel) questionPanel;
                        usedPanel.setText(previousQuestion.getLabel());
                    } else if (previousQuestion.getType().equals("Image")) {
                        questionPanel = this.setNewLayout(Type.Image, Side.Left);
                        typeQuestion = "Image";
                        ImagePanel usedPanel = (ImagePanel) questionPanel;
                        usedPanel.setUrlPicture(previousQuestion.getPicture());
                    } else {
                        questionPanel = this.setNewLayout(Type.ImageAnswer, Side.Left);
                        typeQuestion = "Both";
                        ImageAnswerPanel usedPanel = (ImageAnswerPanel) questionPanel;
                        usedPanel.setText(previousQuestion.getLabel());
                        usedPanel.setUrlPicture(previousQuestion.getPicture());
                    }
                    answerList = answerListFinal.get(indexQuestion);
                    if (answerList.get(0).getType().equals("Text")) {
                        answerPanel = this.setNewLayout(Type.Answer, Side.Right);
                        AnswerPanel usedPanel = (AnswerPanel) answerPanel;
                        usedPanel.setText(answerList.get(0).getLabel());
                        usedPanel.setChecked(answerList.get(0).isValid());
                    } else if (answerList.get(0).getType().equals("Image")) {
                        answerPanel = this.setNewLayout(Type.Image, Side.Right);
                        ImagePanel usedPanel = (ImagePanel) answerPanel;
                        usedPanel.setUrlPicture(answerList.get(0).getPicture());
                        usedPanel.setChecked(answerList.get(0).isValid());
                    } else {
                        answerPanel = this.setNewLayout(Type.ImageAnswer, Side.Right);
                        ImageAnswerPanel usedPanel = (ImageAnswerPanel) answerPanel;
                        usedPanel.setText(answerList.get(0).getLabel());
                        usedPanel.setUrlPicture(answerList.get(0).getPicture());
                        usedPanel.setChecked(answerList.get(0).isValid());
                    }

                }
                break;
        }

    }//GEN-LAST:event_arrowLeftgoToPrevious

    /**
     * ! ONLY FOR THE MODIFICATION ! Update the layout for the next answer for
     * the modification
     */
    public void answerDisplay() {
        if (answerList.get(indexAnswer).getType().equals("Text")) {
            answerPanel = this.setNewLayout(Type.Answer, Side.Right);
            AnswerPanel usedPanel = (AnswerPanel) answerPanel;
            usedPanel.setText(answerList.get(indexAnswer).getLabel());
            usedPanel.setChecked(answerList.get(indexAnswer).isValid());
        } else if (answerList.get(indexAnswer).getType().equals("Image")) {
            answerPanel = this.setNewLayout(Type.Image, Side.Right);
            ImagePanel usedPanel = (ImagePanel) answerPanel;
            usedPanel.setUrlPicture(answerList.get(indexAnswer).getPicture());
            usedPanel.setChecked(answerList.get(indexAnswer).isValid());
        } else {
            answerPanel = this.setNewLayout(Type.ImageAnswer, Side.Right);
            ImageAnswerPanel usedPanel = (ImageAnswerPanel) answerPanel;
            usedPanel.setText(answerList.get(indexAnswer).getLabel());
            usedPanel.setUrlPicture(answerList.get(indexAnswer).getPicture());
            usedPanel.setChecked(answerList.get(indexAnswer).isValid());
        }
    }

    /**
     * ! ONLY FOR THE MODIFICATION ! Update the layou for the next question for
     * the modification
     */
    private void questionDisplay() {
        if (questionList.get(indexQuestion).getType().equals("Text")) {
            questionPanel = this.setNewLayout(Type.Answer, Side.Left);
            AnswerPanel usedPanel = (AnswerPanel) questionPanel;
            usedPanel.setText(questionList.get(indexQuestion).getLabel());
        } else if (questionList.get(indexQuestion).getType().equals("Image")) {
            questionPanel = this.setNewLayout(Type.Image, Side.Left);
            ImagePanel usedPanel = (ImagePanel) questionPanel;
            usedPanel.setUrlPicture(questionList.get(indexQuestion).getPicture());
        } else {
            questionPanel = this.setNewLayout(Type.ImageAnswer, Side.Left);
            ImageAnswerPanel usedPanel = (ImageAnswerPanel) questionPanel;
            usedPanel.setText(questionList.get(indexQuestion).getLabel());
            usedPanel.setUrlPicture(questionList.get(indexQuestion).getPicture());
        }
    }

    /**
     * control the fomat for the question and the answers
     *
     * @return Int : 0 : it's OK ; 1 : if we don't have a good answer ; 2 : if
     * we have only one or not answer ; 3 : if we only have good answer ; 4 : if the
     * question is empty ;
     */
    private int controlQuestion() {
        int codeError = 0;
        boolean gotOneWrongAnswer = false;
        boolean gotOneGoodAnswer = false;
        boolean questionEmpty = false;

        for (int i = 0; i < answerList.size(); i++) {
            if (answerList.get(i).isValid() == true) {
                gotOneGoodAnswer = true;
            } else {
                gotOneWrongAnswer = true;
            }
        }

        if (typeQuestion.equals("Text")) {
            AnswerPanel usedPanel = (AnswerPanel) questionPanel;
            if (usedPanel.getText().equals("")) {
                questionEmpty = true;
            }
        } else if (typeQuestion.equals("Image")) {
            ImagePanel usedPanel = (ImagePanel) questionPanel;
            if (usedPanel.getUrlPicture().equals("")) {
                questionEmpty = true;
            }
        } else {
            ImageAnswerPanel usedPanel = (ImageAnswerPanel) questionPanel;
            if (usedPanel.getText().equals("") && usedPanel.getUrlPicture().equals("")) {
                questionEmpty = true;
            }
        }

        if (!gotOneGoodAnswer) {
            codeError = 1;
        } else if (!gotOneWrongAnswer) {
            codeError = 3;
        } else if (questionEmpty) {
            codeError = 4;
        }

        if (answerList.size() < 2) {
            codeError = 2;
        }



        return codeError;

    }

    private void arrowRightgoToNextQuestion(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrowRightgoToNextQuestion
        Question questionCreate;

        switch (controlQuestion()) {
            case 0:
                if (typeQuestion.equals("Text")) {
                    AnswerPanel usedPanel = (AnswerPanel) questionPanel;
                    questionCreate = new Question(usedPanel.getText(), "");
                    questionCreate.setType("Text");
                    usedPanel.setText("");
                } else if (typeQuestion.equals("Image")) {
                    ImagePanel usedPanel = (ImagePanel) questionPanel;
                    questionCreate = new Question("", usedPanel.getUrlPicture());
                    questionCreate.setType("Image");
                    usedPanel.setUrlPicture("");
                } else {
                    ImageAnswerPanel usedPanel = (ImageAnswerPanel) questionPanel;
                    questionCreate = new Question(usedPanel.getText(), usedPanel.getUrlPicture());
                    questionCreate.setType("Both");
                    usedPanel.setText("");
                    usedPanel.setUrlPicture("");
                }
                if (oldQuestion) {
                    questionList.set(indexQuestion, questionCreate);
                    answerListFinal.set(indexQuestion, answerList);
                } else {
                    questionList.add(questionCreate);
                    answerListFinal.add(answerList);
                }

                answerList = new ArrayList<>();
                indexAnswer = 0;
                indexQuestion++;
                questionNumerLabel.setText("Question N°" + (indexQuestion + 1));
                this.setNewLayout(Type.Image, Side.Right);

                if (indexQuestion >= questionList.size()) {
                    oldQuestion = false;
                } else {
                    questionDisplay();
                    answerList = answerListFinal.get(indexQuestion);
                    answerDisplay();
                }
                break;
            case 1:
                this.errorLabel.setText("Vous n'avez aucune bonne réponse");
                break;
            case 2:
                this.errorLabel.setText("Vous n'avez qu'une ou pas de réponse");
                break;
            case 3:
                this.errorLabel.setText("Vous n'avez aucune mauvais réponse");
                break;
            case 4:
                this.errorLabel.setText("Votre question est vide");
                break;
        }
    }//GEN-LAST:event_arrowRightgoToNextQuestion

    public void saveTheQuizz(java.awt.event.ActionEvent evt) {

        Question questionCreate;

        switch (controlQuestion()) {
            case 0:
                if (typeQuestion.equals("Text")) {
                    AnswerPanel usedPanel = (AnswerPanel) questionPanel;
                    questionCreate = new Question(usedPanel.getText(), "");
                    questionCreate.setType("Text");
                    usedPanel.setText("");
                } else if (typeQuestion.equals("Image")) {
                    ImagePanel usedPanel = (ImagePanel) questionPanel;
                    questionCreate = new Question("", usedPanel.getUrlPicture());
                    questionCreate.setType("Image");
                    usedPanel.setUrlPicture("");
                } else {
                    ImageAnswerPanel usedPanel = (ImageAnswerPanel) questionPanel;
                    questionCreate = new Question(usedPanel.getText(), usedPanel.getUrlPicture());
                    questionCreate.setType("Both");
                    usedPanel.setText("");
                    usedPanel.setUrlPicture("");
                }
                if (oldQuestion) {
                    questionList.set(indexQuestion, questionCreate);
                    answerListFinal.set(indexQuestion, answerList);
                } else {
                    questionList.add(questionCreate);
                    answerListFinal.add(answerList);
                }


                for (int k = 0; k < questionList.size(); k++) {
                    QuizzManager.linkAnswersToQuestion(questionList.get(k), answerListFinal.get(k));
                }
                quizz.setNbQuestQuizz(questionList.size());
                QuizzManager.linkQuestionsToQuizz(quizz, questionList);
                break;
            case 1:
                this.errorLabel.setText("Vous n'avez aucune bonne réponse");
                break;
            case 2:
                this.errorLabel.setText("Vous n'avez qu'une ou pas de réponse");
                break;
            case 3:
                this.errorLabel.setText("Vous n'avez aucune mauvais réponse");
                break;
            case 4:
                this.errorLabel.setText("Votre question est vide");
                break;
        }
        m_mainFrame.changeView(MainFrame.View.MainScreenView);
    }

    private void leftTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftTextButtonActionPerformed
        questionPanel = this.setNewLayout(Type.Answer, Side.Left);
        typeQuestion = "Text";
    }//GEN-LAST:event_leftTextButtonActionPerformed

    private void leftImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftImageButtonActionPerformed
        questionPanel = this.setNewLayout(Type.Image, Side.Left);
        typeQuestion = "Image";
    }//GEN-LAST:event_leftImageButtonActionPerformed

    private void leftBothButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftBothButtonActionPerformed
        questionPanel = this.setNewLayout(Type.ImageAnswer, Side.Left);
        typeQuestion = "Both";
    }//GEN-LAST:event_leftBothButtonActionPerformed

    private void rightTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightTextButtonActionPerformed
        this.setNewLayout(Type.Answer, Side.Right);
    }//GEN-LAST:event_rightTextButtonActionPerformed

    private void rightImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightImageButtonActionPerformed
        this.setNewLayout(Type.Image, Side.Right);
    }//GEN-LAST:event_rightImageButtonActionPerformed

    private void rightBothButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightBothButtonActionPerformed
        this.setNewLayout(Type.ImageAnswer, Side.Right);
    }//GEN-LAST:event_rightBothButtonActionPerformed

    private void backButton1backAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1backAction
        m_mainFrame.changeView(MainFrame.View.MainScreenView);
    }//GEN-LAST:event_backButton1backAction

    /**
     * permet de changer le type de panel pour créer question/réponse
     *
     * @param _type le type de panel a affecter
     * @param _side le coté concerné
     */
    public JPanel setNewLayout(Type _type, Side _side) {
        JPanel current = null;
        Boolean response = false;
        switch (_side) {
            case Left:
                current = leftPanel;
                this.remove(leftPanel);
                break;
            case Right:
                current = rightPanel;
                this.remove(rightPanel);
                response = true;
                break;
        }

        switch (_type) {

            case Image:
                current = new ImagePanel(response, this);
                break;
            case Answer:
                current = new AnswerPanel(response, this);
                break;
            case ImageAnswer:
                current = new ImageAnswerPanel(response, this);
                break;
        }
        switch (_side) {
            case Left:
                leftPanel = current;
                this.add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));
                break;
            case Right:
                rightPanel = current;
                this.add(rightPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));
                break;
        }
        current.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        this.revalidate();
        this.repaint();
        return current;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SubmitQuizzButton;
    private javax.swing.JLabel arrowLeft;
    private javax.swing.JLabel arrowRight;
    private javax.swing.JButton backButton;
    private javax.swing.JButton backButton1;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton leftBothButton;
    private javax.swing.JButton leftImageButton;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton leftTextButton;
    private javax.swing.JLabel questionNumerLabel;
    private javax.swing.JButton rightBothButton;
    private javax.swing.JButton rightImageButton;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JButton rightTextButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
