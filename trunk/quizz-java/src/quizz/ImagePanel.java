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

    /**
     * Creates new form ImagePanel
     */
    public ImagePanel(Boolean response) {
        initComponents(response);
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
			GoodAnswer = new javax.swing.JCheckBox();
			
			firstCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			add(firstCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

			secondCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			add(secondCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

			thirdCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			add(thirdCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

			fourthCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
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
        //Answer answerCreate = new Answer("",image,GoodAnswer.isSelected());
        //answerList.add(answerCreate);
        //image.setText("");
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
