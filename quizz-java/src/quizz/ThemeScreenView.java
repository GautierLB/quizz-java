/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Vince
 */
public class ThemeScreenView extends BrainStormingView {

    private MainFrame m_mainFrame;

    public ThemeScreenView(MainFrame mainFrame) {
        super(mainFrame);
        initComponents();
        m_mainFrame = mainFrame;
        createQuizzLine(2, "Gautier le BG", 25);
    }

    private void createQuizzLine(int difficulty, String quizzName, int questionsNumber) {
        String[] starsIconTitle = new String[3];

        JPanel starsPanel = new javax.swing.JPanel();
        JLabel star1 = new javax.swing.JLabel();
        JLabel star2 = new javax.swing.JLabel();
        JLabel star3 = new javax.swing.JLabel();
        JLabel quizzLabel = new javax.swing.JLabel();

        starsPanel.setBackground(new java.awt.Color(255, 255, 255));
        starsPanel.setForeground(new java.awt.Color(255, 255, 255));
        starsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        switch (difficulty) {
            case 2:
                starsIconTitle[0] = Constants.STAR_FULL;
                starsIconTitle[1] = Constants.STAR_FULL;
                starsIconTitle[2] = Constants.STAR_EMPTY;
                break;
            case 3:
                starsIconTitle[0] = Constants.STAR_FULL;
                starsIconTitle[1] = Constants.STAR_FULL;
                starsIconTitle[2] = Constants.STAR_FULL;
                break;
            default:
                starsIconTitle[0] = Constants.STAR_FULL;
                starsIconTitle[1] = Constants.STAR_EMPTY;
                starsIconTitle[2] = Constants.STAR_EMPTY;
                break;
        }

        star1.setIcon(new javax.swing.ImageIcon(getClass().getResource(Constants.IMAGE_FOLDER + starsIconTitle[0])));
        star2.setIcon(new javax.swing.ImageIcon(getClass().getResource(Constants.IMAGE_FOLDER + starsIconTitle[1])));
        star3.setIcon(new javax.swing.ImageIcon(getClass().getResource(Constants.IMAGE_FOLDER + starsIconTitle[2])));

        starsPanel.add(star1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        starsPanel.add(star2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));
        starsPanel.add(star3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        add(starsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 150, -1, -1));

        quizzLabel.setText(quizzName + " [" + questionsNumber + "Q]");
        add(quizzLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 150, 162, 20));
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centralSeparator = new javax.swing.JSeparator();
        themeName = new javax.swing.JLabel();
        themeIcon = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        centralSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(centralSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 125, -1, 350));

        themeName.setFont(quizz.Main.s_openSansTitle);
        themeName.setText("ThemeName");
        add(themeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        themeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizz/assets/linux-40.png"))); // NOI18N
        themeIcon.setMaximumSize(new java.awt.Dimension(80, 80));
        themeIcon.setMinimumSize(new java.awt.Dimension(80, 80));
        add(themeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 33, -1, -1));

        backButton.setText("Retour");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backAction(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backAction
        m_mainFrame.changeView(MainFrame.View.MainScreenView);
    }//GEN-LAST:event_backAction


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JSeparator centralSeparator;
    private javax.swing.JLabel themeIcon;
    private javax.swing.JLabel themeName;
    // End of variables declaration//GEN-END:variables
}
