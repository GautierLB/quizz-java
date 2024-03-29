package quizz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Theme {

    private static final String TABLE_NAME = "BDD_B3I_groupe_3.dbo.[THEME]";
    private static final String ID = "ID_THEME";
    private static final String NAME = "NAME_THEME";
    private static final String PICTURE = "PICTURE_THEME";
    private int m_idTheme;
    private String m_nameTheme;
    private String m_pictureTheme;

    /**
     * Theme's constructor
     *
     * @param id The id of the theme.
     * @param name The name of the Theme.
     * @param picture The path or URL of the picture.
     */
    public Theme(int id, String name, String picture) {
        this.m_idTheme = id;
        this.m_nameTheme = name;
        this.m_pictureTheme = picture;
    }

    /**
     * Get all the Theme of the database
     *
     * @return an ArrayList of Theme
     */
    static public ArrayList<Theme> getAllThemes() {
        ArrayList<Theme> themeList = new ArrayList<>();
        ArrayList<HashMap<String, Object>> themeListBdd = DBController.Get().executeSelect("*", "theme", "");
        for (int i = 0; i < themeListBdd.size(); i++) {
            Theme theme = new Theme((int) themeListBdd.get(i).get(Theme.ID),
                    (String) themeListBdd.get(i).get(Theme.NAME),
                    (String) themeListBdd.get(i).get(Theme.PICTURE));
            themeList.add(theme);
        }
        return themeList;
    }

    /**
     * Get a theme by the id
     *
     * @param id the id of the theme we want
     * @return the theme we want
     */
    static public Theme getThemeById(int id) {
        ArrayList<HashMap<String, Object>> themeList = DBController.Get().executeSelect("*", Theme.TABLE_NAME, "where ID_THEME = " + id);
        return new Theme((int) themeList.get(0).get(Theme.ID),
                (String) themeList.get(0).get(Theme.NAME),
                (String) themeList.get(0).get(Theme.PICTURE));
    }
    
    static public Theme getThemeByName(String nameTheme){
        ArrayList<HashMap<String, Object>> themeList = DBController.Get().executeSelect("*", Theme.TABLE_NAME, "where NAME_THEME LIKE '" + nameTheme +"'");
        return new Theme((int) themeList.get(0).get(Theme.ID),
                (String) themeList.get(0).get(Theme.NAME),
                (String) themeList.get(0).get(Theme.PICTURE));
    }

    /**
     * Save in the database the Theme
     */
    public void saveTheme() {
        DBController.Get().executeInsert(Theme.TABLE_NAME,
                Theme.NAME + ',' + Theme.PICTURE,
                "'" + this.getNameTheme()
                + "','" + this.getPictureTheme() + "'");
    }

    /**
     * @return the m_nameTheme
     */
    public String getNameTheme() {
        return m_nameTheme;
    }

    /**
     * @return the m_pictureTheme
     */
    private String getPictureTheme() {
        return m_pictureTheme;
    }
    
    /**
     * @return the m_pictureTheme in big size
     */
    public String getPictureThemeBig() {
        return m_pictureTheme + "-100.png";
    }
    
    /**
     * @return the m_pictureTheme in small size
     */
    public String getPictureThemeSmall() {
        return m_pictureTheme + "-40.png";
    }
    
    /**
     * @return The theme's id.
     */
    public int getId() {
        return m_idTheme;
    }
}
