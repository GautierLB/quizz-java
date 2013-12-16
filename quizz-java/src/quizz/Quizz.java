/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gautier
 */
public class Quizz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainScreenView mainScreen = new MainScreenView();
        mainScreen.setVisible(true);
        try {
            Font OpenSans = new Font(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("OpenSans-Regular.ttf"))).getFamily(), Font.BOLD, 38);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Quizz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur dans le chargement de la police");
        }
    }
    
}
