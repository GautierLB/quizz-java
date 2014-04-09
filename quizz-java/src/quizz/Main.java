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
import quizz.model.User;

public class Main {

    public static Font s_openSansTitle;
    public static Font s_openSans13;
    public static Font s_openSansItalic16;
    public static Font s_openSans28;
    public static String userPseudo="User";
    
    public static void main(String[] args) {
        Boolean test = User.controlLogin("Bobby", "02101993");
        System.out.println("resultat : "+test);
        Main.initFont();
        MainFrame mainFrame = new MainFrame();
        mainFrame.changeView(MainFrame.View.MainScreenView);
    }

    public static void initFont() {
        try {
          Main.s_openSansTitle = new Font(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/quizz/assets/OpenSans-Regular.ttf"))).getFamily(), 0, 24);
          Main.s_openSans13 = new Font(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/quizz/assets/OpenSans-Regular.ttf"))).getFamily(), 0, 13);
          Main.s_openSansItalic16 = new Font(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/quizz/assets/OpenSans-Regular.ttf"))).getFamily(), 0, 16);
          Main.s_openSans28 = new Font(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/quizz/assets/OpenSans-Italic.ttf"))).getFamily(), 0, 28);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur dans le chargement de la police");
        }
    }
}
