/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import quizz.model.Quizz;
import quizz.model.Score;
import quizz.model.Theme;

public class ThemeScreenView extends BrainStormingView {

    int m_numberOfLines = 0;

    public ThemeScreenView(MainFrame mainFrame, Theme theme) {
        super(mainFrame);
        initComponents();
        themeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(theme.getPictureThemeSmall())));
        themeName.setText(theme.getNameTheme());
        ArrayList<Quizz> quizzList = Quizz.getQuizzForTheme(theme.getId());
        for (Quizz quizz : quizzList) {
            this.createQuizzLine(quizz);
        }
    }

    /**
     * <b>Create a generic quizz line</b>
     * <p>
     * The quizz line is automalically moved at the right position and the (int)
     * difficulty sets the number of stars.</p>
     *
     * @param difficulty The difficulty of the quizz
     * @param quizzName The name of the quizz
     * @param questionsNumber The number of questions in the quizz
     */
    private void createQuizzLine(Quizz quizzItem) {
        final int lineWidth = 300;
        final Quizz quizz = quizzItem; // Necessary to swap views.
        if (m_numberOfLines < 18) {
            String[] starsIconTitle = new String[3];

            JPanel line = new javax.swing.JPanel();
            JPanel starsPanel = new javax.swing.JPanel();
            JLabel star1 = new javax.swing.JLabel();
            JLabel star2 = new javax.swing.JLabel();
            JLabel star3 = new javax.swing.JLabel();
            JLabel quizzLabel = new javax.swing.JLabel();

            starsPanel.setBackground(new java.awt.Color(255, 255, 255));
            starsPanel.setForeground(new java.awt.Color(255, 255, 255));
            starsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            line.setBackground(new java.awt.Color(255, 255, 255));
            line.setForeground(new java.awt.Color(255, 255, 255));
            line.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            switch (quizz.getDifficulty()) {
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

            line.add(starsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

            quizzLabel.setText(quizz.getName() + " [" + quizz.getNbQuest() + "Q]");
            line.add(quizzLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, lineWidth, 20));
            line.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (!Main.userPseudo.equals("User")) {
                        if (!quizz.isRetryable() && Score.isAlreadyPlayed(quizz.getId(), Main.idPseudo)) {
                            quizzError.setText("Quizz déja fait et non rejouable");
                        } else {
                            m_mainFrame.setQuizz(quizz);
                            m_mainFrame.changeView(MainFrame.View.QuestionScreenView);
                        }
                    } else {
                        m_mainFrame.setQuizz(quizz);
                        m_mainFrame.changeView(MainFrame.View.QuestionScreenView);
                    }
                }
            });
            this.setVisible(true);
            this.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(m_numberOfLines > 8 ? 500 : 110, 130 + ((m_numberOfLines > 8 ? m_numberOfLines - 9 : m_numberOfLines) * 40), lineWidth, 20));
            m_numberOfLines++;
        }
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
        quizzError = new javax.swing.JLabel();

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

        quizzError.setForeground(new java.awt.Color(255, 0, 20));
        add(quizzError, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 240, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backAction
        m_mainFrame.changeView(MainFrame.View.MainScreenView);
    }//GEN-LAST:event_backAction


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JSeparator centralSeparator;
    private javax.swing.JLabel quizzError;
    private javax.swing.JLabel themeIcon;
    private javax.swing.JLabel themeName;
    // End of variables declaration//GEN-END:variables
}
