/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

/**
 *
 *
 */
public class Theme {

    private static DBController m_controller;
    private String m_nameTheme;
    private String m_pictureTheme;

    public Theme(String name, String picture) {
        this.m_nameTheme = name;
        this.m_pictureTheme = picture;
    }

    /**
     * Save in the database the Theme
     */
    public void saveTheme() {
        this.m_controller.Get().executeInsert("theme",
                "name_theme,picture_theme",
                "'" + this.m_nameTheme
                + "','" + this.m_pictureTheme + "'");
    }
}
