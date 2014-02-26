/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

/**
 *
 * @author Gautier
 */
public class ImageAnswerPanel extends javax.swing.JPanel {

    /**
     * Creates new form ImageAnswerPanel
     */
    public ImageAnswerPanel(Boolean response) {
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

        titleLabel = new javax.swing.JLabel();
        ImageAddPanel = new javax.swing.JPanel();
        addImage = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AnswerArea = new javax.swing.JTextPane();
        titleTextLabel = new javax.swing.JLabel();
        titleImageLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(309, 307));
        setMinimumSize(new java.awt.Dimension(309, 307));
        setPreferredSize(new java.awt.Dimension(309, 307));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(Main.s_openSans13);
        titleLabel.setForeground(new java.awt.Color(40, 40, 40));
        titleLabel.setText("Ajoutez une Question");
		add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));
       
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

        ImageAddPanel.setBackground(new java.awt.Color(255, 255, 255));
        ImageAddPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        ImageAddPanel.setMaximumSize(new java.awt.Dimension(100, 183));
        ImageAddPanel.setMinimumSize(new java.awt.Dimension(100, 183));

        addImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/plus-20.png"))); // NOI18N

        javax.swing.GroupLayout ImageAddPanelLayout = new javax.swing.GroupLayout(ImageAddPanel);
        ImageAddPanel.setLayout(ImageAddPanelLayout);
        ImageAddPanelLayout.setHorizontalGroup(
            ImageAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
            .addGroup(ImageAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ImageAddPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addImage)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ImageAddPanelLayout.setVerticalGroup(
            ImageAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
            .addGroup(ImageAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ImageAddPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addImage)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(ImageAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 60, 100, 183));

        jScrollPane2.setMaximumSize(new java.awt.Dimension(100, 183));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(100, 183));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 183));
        jScrollPane2.setViewportView(AnswerArea);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 60, -1, -1));

        titleTextLabel.setFont(Main.s_openSans13);
        titleTextLabel.setText("Texte");
        add(titleTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        titleImageLabel.setFont(Main.s_openSans13);
        titleImageLabel.setText("Image");
        add(titleImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane AnswerArea;
	private javax.swing.JCheckBox GoodAnswer;
    private javax.swing.JPanel ImageAddPanel;
    private javax.swing.JLabel addImage;
    private javax.swing.JLabel addResponse;
    private javax.swing.JLabel firstCircle;
    private javax.swing.JLabel fourthCircle;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel secondCircle;
    private javax.swing.JLabel thirdCircle;
    private javax.swing.JLabel titleImageLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel titleTextLabel;
    // End of variables declaration//GEN-END:variables
}
