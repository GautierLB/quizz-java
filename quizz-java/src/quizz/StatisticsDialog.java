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
import java.awt.*;
import javax.swing.JDialog;

public class StatisticsDialog extends JDialog {

    public StatisticsDialog(MainFrame parent) {
        super(parent, "Statistiques", true);
        this.setModal(false);
        StatisticsDialogPanel stats = new StatisticsDialogPanel(parent);
        getContentPane().add(stats, BorderLayout.CENTER);
        this.setUndecorated(true);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);

    }
}