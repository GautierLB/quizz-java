/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import quizz.model.Answer;

/**
 *
 * @author Gautier
 */
public class ImagePanel extends javax.swing.JPanel {

    private CreateQuestionView owner;

    /**
     * Creates new form ImagePanel
     */
    public ImagePanel(Boolean response, CreateQuestionView _owner) {
        initComponents(response);
        this.owner = _owner;
        circleColoration();
    }

    /**
     * Get the url of the panel for the cration of a question
     *
     * @return
     */
    public String getUrlPicture() {
        return (urlTextbox.getText());
    }

    /**
     * Set the url of the panel for modification
     *
     * @param theUrl
     */
    public void setUrlPicture(String theUrl) {
        urlTextbox.setText(theUrl);
    }

    /**
     * set if the checkbox is checked or not for the modification
     *
     * @param isValid Boolean , true if the question is valid , false if the
     * question is not valid
     */
    public void setChecked(boolean isValid) {
        GoodAnswer.setSelected(isValid);
    }

    /**
     * color or not the circle
     */
    public void circleColoration() {
        int goodAnswer[] = new int[4];
        int nbGood = 0;

        for (int i = 0; i < owner.answerList.size(); i++) {
            if (owner.answerList.get(i).isValid()) {
                goodAnswer[nbGood] = i;
                nbGood++;
            }
        }

        switch (owner.answerList.size()) {
            case 1:
                firstCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
                secondCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png")));
                thirdCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png")));
                fourthCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png")));
                break;
            case 2:
                firstCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
                secondCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
                thirdCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png")));
                fourthCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png")));
                break;
            case 3:
                firstCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
                secondCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
                thirdCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
                fourthCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png")));
                break;
            case 4:
                firstCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
                secondCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
                thirdCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
                fourthCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFull-15.png")));
                break;
        }
        
        
        if(nbGood != 0){
            for (int i = 0; i < nbGood; i++) {
                switch(goodAnswer[i]){
                    case 0:
                        firstCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFullGreen-15.png")));
                        break;
                    case 1:
                        secondCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFullGreen-15.png")));
                        break;
                    case 2:
                        thirdCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFullGreen-15.png")));
                        break;
                    case 3:
                        fourthCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleFullGreen-15.png")));
                        break;
                }
            }
        }

    }

    
    private void firstCircleClick(java.awt.event.MouseEvent evt) {
        if (1 <= owner.answerList.size()) {
            owner.indexAnswer = 0;
            if (owner.answerList.get(owner.indexAnswer).getType().equals("Text")) {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.Answer, CreateQuestionView.Side.Right);
                AnswerPanel usedPanel = (AnswerPanel) owner.answerPanel;
                usedPanel.setText(owner.answerList.get(owner.indexAnswer).getLabel());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            } else if (owner.answerList.get(owner.indexAnswer).getType().equals("Image")) {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.Image, CreateQuestionView.Side.Right);
                ImagePanel usedPanel = (ImagePanel) owner.answerPanel;
                usedPanel.setUrlPicture(owner.answerList.get(owner.indexAnswer).getPicture());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            } else {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.ImageAnswer, CreateQuestionView.Side.Right);
                ImageAnswerPanel usedPanel = (ImageAnswerPanel) owner.answerPanel;
                usedPanel.setText(owner.answerList.get(owner.indexAnswer).getLabel());
                usedPanel.setUrlPicture(owner.answerList.get(owner.indexAnswer).getPicture());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            }
        }else{
            urlTextbox.setText("");
        }
    }

    private void secondCircleClick(java.awt.event.MouseEvent evt) {
        if (2 <= owner.answerList.size()) {
            owner.indexAnswer= 1;
            if (owner.answerList.get(owner.indexAnswer).getType().equals("Text")) {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.Answer, CreateQuestionView.Side.Right);
                AnswerPanel usedPanel = (AnswerPanel) owner.answerPanel;
                usedPanel.setText(owner.answerList.get(owner.indexAnswer).getLabel());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            } else if (owner.answerList.get(owner.indexAnswer).getType().equals("Image")) {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.Image, CreateQuestionView.Side.Right);
                ImagePanel usedPanel = (ImagePanel) owner.answerPanel;
                usedPanel.setUrlPicture(owner.answerList.get(owner.indexAnswer).getPicture());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            } else {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.ImageAnswer, CreateQuestionView.Side.Right);
                ImageAnswerPanel usedPanel = (ImageAnswerPanel) owner.answerPanel;
                usedPanel.setText(owner.answerList.get(owner.indexAnswer).getLabel());
                usedPanel.setUrlPicture(owner.answerList.get(owner.indexAnswer).getPicture());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            }
        }else{
            urlTextbox.setText("");
        }
    }

    private void thirdCircleClick(java.awt.event.MouseEvent evt) {
        if (3 <= owner.answerList.size()) {
            owner.indexAnswer = 2;
            if (owner.answerList.get(owner.indexAnswer).getType().equals("Text")) {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.Answer, CreateQuestionView.Side.Right);
                AnswerPanel usedPanel = (AnswerPanel) owner.answerPanel;
                usedPanel.setText(owner.answerList.get(owner.indexAnswer).getLabel());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            } else if (owner.answerList.get(owner.indexAnswer).getType().equals("Image")) {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.Image, CreateQuestionView.Side.Right);
                ImagePanel usedPanel = (ImagePanel) owner.answerPanel;
                usedPanel.setUrlPicture(owner.answerList.get(owner.indexAnswer).getPicture());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            } else {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.ImageAnswer, CreateQuestionView.Side.Right);
                ImageAnswerPanel usedPanel = (ImageAnswerPanel) owner.answerPanel;
                usedPanel.setText(owner.answerList.get(owner.indexAnswer).getLabel());
                usedPanel.setUrlPicture(owner.answerList.get(owner.indexAnswer).getPicture());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            }
        }else{
            urlTextbox.setText("");
        }
    }

    private void fourthCircleClick(java.awt.event.MouseEvent evt) {
        if (4 <= owner.answerList.size()) {
            owner.indexAnswer = 3;
            if (owner.answerList.get(owner.indexAnswer).getType().equals("Text")) {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.Answer, CreateQuestionView.Side.Right);
                AnswerPanel usedPanel = (AnswerPanel) owner.answerPanel;
                usedPanel.setText(owner.answerList.get(owner.indexAnswer).getLabel());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            } else if (owner.answerList.get(owner.indexAnswer).getType().equals("Image")) {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.Image, CreateQuestionView.Side.Right);
                ImagePanel usedPanel = (ImagePanel) owner.answerPanel;
                usedPanel.setUrlPicture(owner.answerList.get(owner.indexAnswer).getPicture());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            } else {
                owner.answerPanel = owner.setNewLayout(CreateQuestionView.Type.ImageAnswer, CreateQuestionView.Side.Right);
                ImageAnswerPanel usedPanel = (ImageAnswerPanel) owner.answerPanel;
                usedPanel.setText(owner.answerList.get(owner.indexAnswer).getLabel());
                usedPanel.setUrlPicture(owner.answerList.get(owner.indexAnswer).getPicture());
                usedPanel.setChecked(owner.answerList.get(owner.indexAnswer).isValid());
                owner.oldAnswer = true;
            }
        }else{
            urlTextbox.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Boolean response) {

        urlLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        urlTextbox = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(309, 307));
        setMinimumSize(new java.awt.Dimension(309, 307));
        setPreferredSize(new java.awt.Dimension(309, 307));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        urlLabel.setFont(Main.s_openSans13);
        urlLabel.setText("Url de l'image");
        add(urlLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        titleLabel.setFont(Main.s_openSans13);
        titleLabel.setForeground(new java.awt.Color(40, 40, 40));
        titleLabel.setText("Ajoutez une Image");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        if( response == true){
			firstCircle = new javax.swing.JLabel();
			secondCircle = new javax.swing.JLabel();
			thirdCircle = new javax.swing.JLabel();
			fourthCircle = new javax.swing.JLabel();
			addResponse = new javax.swing.JLabel();
			addResponse.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					addResponseMouseClicked(evt);
				}
			});
			GoodAnswer = new javax.swing.JCheckBox();
			
			firstCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			firstCircle.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					firstCircleClick(evt);
				}
			});
			add(firstCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

			secondCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			secondCircle.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					secondCircleClick(evt);
				}
			});
			add(secondCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

			thirdCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			thirdCircle.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					thirdCircleClick(evt);
				}
			});
			add(thirdCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

			fourthCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			fourthCircle.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					fourthCircleClick(evt);
				}
			});
			add(fourthCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

			addResponse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/plus-20.png"))); // NOI18N
			add(addResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 250, -1, -1));
			titleLabel.setText("Ajoutez une Réponse");
			
			GoodAnswer.setFont(Main.s_openSans13);
			GoodAnswer.setLabel("Bonne réponse");
			GoodAnswer.setMaximumSize(new java.awt.Dimension(150, 20));
			GoodAnswer.setMinimumSize(new java.awt.Dimension(150, 20));
			GoodAnswer.setOpaque(false);
			GoodAnswer.setPreferredSize(new java.awt.Dimension(150, 20));
			add(GoodAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
		}

        urlTextbox.setText(" ");
        urlTextbox.setMaximumSize(new java.awt.Dimension(80, 20));
        urlTextbox.setMinimumSize(new java.awt.Dimension(80, 20));
        urlTextbox.setPreferredSize(new java.awt.Dimension(80, 20));
        add(urlTextbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addResponseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addImageLabelMouseClicked
        if (!owner.oldAnswer) {
            if (owner.answerList.size() != 4) {
                Answer answerCreate = new Answer("", urlTextbox.getText(), GoodAnswer.isSelected());
                answerCreate.setType("Image");
                owner.answerList.add(answerCreate);
                urlTextbox.setText("");
                GoodAnswer.setSelected(false);
                circleColoration();
            }
        } else {
            Answer answerCreate = new Answer("", urlTextbox.getText(), GoodAnswer.isSelected());
                answerCreate.setType("Image");
                owner.answerList.set(owner.indexAnswer, answerCreate);
                urlTextbox.setText("");
                GoodAnswer.setSelected(false);
                owner.indexAnswer++;
            if (owner.indexAnswer >= owner.answerList.size()) {
                owner.oldAnswer = false;
                circleColoration();
            } else {
                owner.answerDisplay();
            }
        }
    }//GEN-LAST:event_addImageLabelMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addResponse;
    private javax.swing.JLabel firstCircle;
    private javax.swing.JLabel fourthCircle;
    private javax.swing.JLabel secondCircle;
    private javax.swing.JLabel thirdCircle;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField urlTextbox;
	public javax.swing.JCheckBox GoodAnswer;
    // End of variables declaration//GEN-END:variables
}
