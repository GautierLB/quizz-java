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

        addImageLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(309, 307));
        setMinimumSize(new java.awt.Dimension(309, 307));
        setPreferredSize(new java.awt.Dimension(309, 307));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/plus-45.png"))); // NOI18N
        addImageLabel.setMaximumSize(new java.awt.Dimension(45, 45));
        addImageLabel.setMinimumSize(new java.awt.Dimension(45, 45));
        addImageLabel.setPreferredSize(new java.awt.Dimension(45, 45));
        add(addImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 130, -1, -1));

        titleLabel.setFont(Main.s_openSans13);
        titleLabel.setForeground(new java.awt.Color(40, 40, 40));
        titleLabel.setText("Ajoutez une Question");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));
		
		if( response == true){
			firstCircle = new javax.swing.JLabel();
			secondCircle = new javax.swing.JLabel();
			thirdCircle = new javax.swing.JLabel();
			fourthCircle = new javax.swing.JLabel();
			addResponse = new javax.swing.JLabel();
			
			firstCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			add(firstCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

			secondCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			add(secondCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

			thirdCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			add(thirdCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

			fourthCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/circleEmpty-15.png"))); // NOI18N
			add(fourthCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

			addResponse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/plus-20.png"))); // NOI18N
			add(addResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));
			titleLabel.setText("Ajoutez une Réponse");
		}

        
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addImageLabel;
    private javax.swing.JLabel addResponse;
    private javax.swing.JLabel firstCircle;
    private javax.swing.JLabel fourthCircle;
    private javax.swing.JLabel secondCircle;
    private javax.swing.JLabel thirdCircle;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
