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
    public static Font openSans;
    
    public static void main(String[] args) {
        try {
          Quizz.openSans = new Font(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("OpenSans-Regular.ttf"))).getFamily(), 0, 34);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Quizz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur dans le chargement de la police");
        }
        MainScreenView mainScreen = new MainScreenView();
        mainScreen.setVisible(true);
        CreateQuizzView createScreen = new CreateQuizzView();
        createScreen.setVisible(true);
    }
    
}
