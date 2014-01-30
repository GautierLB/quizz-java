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
public abstract class BrainStormingView extends javax.swing.JPanel {
    private MainFrame m_mainFrame;
    protected void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        m_mainFrame.deleteModal();
    }
    BrainStormingView(MainFrame mainFrame){
        m_mainFrame = mainFrame;
    }
}
