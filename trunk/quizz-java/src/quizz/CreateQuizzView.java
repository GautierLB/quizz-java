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
public class CreateQuizzView extends javax.swing.JPanel {

    /**
     * Creates new form CreateQuizzPanel
     */
    public CreateQuizzView() {
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

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(Quizz.s_openSans);
        titleLabel.setText("Créer un Quizz");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        titleLabel.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("CreateQuizzPanel");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
