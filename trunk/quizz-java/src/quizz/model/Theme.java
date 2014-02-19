package quizz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Theme {

    public static final String ID = "ID_THEME";
    public static final String NAME = "NAME_THEME";
    public static final String PICTURE = "PICTURE_THEME";
    private int m_idTheme;
    private String m_nameTheme;
    private String m_pictureTheme;

    /**
     * The construct of the Theme
     *
     * @param name the name of the Theme
     * @param picture the path or URL of the picture
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
        ArrayList<HashMap<String, Object>> themeList = DBController.Get().executeSelect("*", "theme", "where ID_THEME = " + id);
        return new Theme((int) themeList.get(0).get(Theme.ID),
                (String) themeList.get(0).get(Theme.NAME),
                (String) themeList.get(0).get(Theme.PICTURE));
    }

    /**
     * Save in the database the Theme
     */
    public void saveTheme() {
        DBController.Get().executeInsert("theme",
                Theme.NAME + ',' + Theme.PICTURE,
                "'" + this.m_nameTheme
                + "','" + this.m_pictureTheme + "'");
    }
}
