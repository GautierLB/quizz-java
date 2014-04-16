/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.BorderLayout;
import quizz.model.Theme;
import quizz.model.Quizz;
import quizz.model.Score;

/**
 *
 * @author Gautier
 */
public class MainFrame extends javax.swing.JFrame {

    public enum View {

        MainScreenView, CreateQuizzView, ThemeScreenView, QuestionScreenView, CreateQuestionView, ResultsView
    };

    public enum modalView {

        LoginView, SignInView;
    };
    LoginDialog m_loginDlg;
    SignInDialog m_signInDlg;
    StatisticsDialog m_statsDialog;
    String m_activeView;

    public MainFrame() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getAccessibleContext().setAccessibleName("mainFrame");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

    }

    /**
     * Permet de choisir la vue a afficher.
     *
     * @param viewName est une enumeration contenant le nom des vues.
     */
    public void changeView(View viewName) {
        this.getContentPane().removeAll();
        switch (viewName) {
            case MainScreenView:
                this.displayMainScreen();
                break;
            case CreateQuizzView:
                this.displayCreateQuizz();
                break;
        }
        this.setVisible(true);
    }
    
    /**
     * Permet de choisir la vue a afficher.
     *
     * @param viewName est une enumeration contenant le nom des vues.
     * @param newQuizz Le quizz a afficher dans la vue suivante.
     */
    public void changeView(View viewName, Quizz newQuizz) {
        this.getContentPane().removeAll();
        switch (viewName) {
            case CreateQuestionView:
                this.displayCreateQuestionScreen(newQuizz);
                break;
            case QuestionScreenView:
                this.displayQuestionScreen(newQuizz);
                break;
        }
        this.setVisible(true);
    }
    
    /**
     * Permet de choisir la vue a afficher.
     *
     * @param viewName est une enumeration contenant le nom des vues.
     * @param score les statistiques a afficher dans la vue suivante.
     */
    public void changeView(View viewName, Score score) {
        this.getContentPane().removeAll();
        switch (viewName) {
            case ResultsView:
                this.displayResultsScreen(score);
        }
        this.setVisible(true);
    }

    /**
     * Permet d'afficher le theme.
     *
     * @param viewName Est une enumeration contenant le nom des vues.
     * @param theme Le theme a afficher dans la vue suivante.
     */
    public void changeView(View viewName, Theme theme) {
        this.getContentPane().removeAll();
        if (viewName == View.ThemeScreenView) {
           this.displayThemeScreen(theme); 
        }
        this.setVisible(true);
    }

    /**
     * Permet de choisir la vue a ajouter(vues modales).
     *
     * @param viewName est une enumeration contenant le nom des vues.
     */
    public void addView(modalView viewName) {
        switch (viewName) {
            case LoginView:
                this.displayLoginPanel();
                break;
            case SignInView:
                this.displaySignInPanel();
                break;
        }
        this.setVisible(true);
    }

    private void displayCreateQuizz() {
        m_activeView = "CreateQuizzView";
        CreateQuizzView createQuizz = new CreateQuizzView(this);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, createQuizz);
    }

    /**
     * Permet d'afficher la vue MainScreen.
     */
    private void displayMainScreen() {
        m_activeView = "MainScreenView";
        MainScreenView mainScreen = new MainScreenView(this);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, mainScreen);
    }

    /**
     * Permet d'afficher la vue ThemeScreen.
     */
    private void displayThemeScreen(Theme theme) {
        m_activeView = "ThemeScreenView";
        ThemeScreenView themeScreen = new ThemeScreenView(this, theme);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, themeScreen);
    }

    /**
     * Permet d'afficher la vue QuestionScreen.
     */
    private void displayQuestionScreen(Quizz quizz) {
        QuestionScreenView questionScreen = new QuestionScreenView(this, quizz);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, questionScreen);
    }

    /**
     * Permet d'afficher la vue CreateQuestionScreen.
     */
     private void displayCreateQuestionScreen(Quizz quizz) {
          m_activeView = "CreateQuestionView";
        CreateQuestionView questionScreen = new CreateQuestionView(this, quizz);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, questionScreen);
    }
     
     private void displayResultsScreen(Score score) {
        m_activeView = "ReultsView";
        ResultsView resultScreen = new ResultsView(this, score);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, resultScreen);
    }

    /**
     * Permet D'afficher le panel de login
     */
    private void displayLoginPanel() {
        if(Main.userPseudo != "User")
        {
            m_statsDialog = new StatisticsDialog(this, new Score(1,1));
            m_statsDialog.setVisible(true);
        } else {
            m_loginDlg = new LoginDialog(this);
            m_loginDlg.setVisible(true);
        }
    }

    /**
     * Permet D'afficher le panel d'inscription
     */
    private void displaySignInPanel() {
        m_signInDlg = new SignInDialog(this);
        m_signInDlg.setVisible(true);
    }

    /**
     * Supprime toutes les fenêtres modales
     */
    public void deleteModal() {
        if (m_loginDlg != null) {
            m_loginDlg.setVisible(false);
            m_loginDlg.dispose();
        }
        if (m_signInDlg != null) {
            m_signInDlg.setVisible(false);
            m_signInDlg.dispose();
        }
        if (m_statsDialog != null) {
            m_statsDialog.setVisible(false);
            m_statsDialog.dispose();
        }
        this.changeView(View.valueOf(m_activeView));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
