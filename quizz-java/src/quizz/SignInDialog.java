package quizz;

/**
 *
 * @author Gautier
 */
import java.awt.*;
import javax.swing.JDialog;
 
public class SignInDialog extends JDialog {
 
    public SignInDialog(MainFrame parent) {
        super(parent, "Inscription", true);
        this.setModal(false);
        SignInDialogPanel login = new SignInDialogPanel(parent); 
        getContentPane().add(login, BorderLayout.CENTER);
        this.setUndecorated(true);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
            
    }            
}