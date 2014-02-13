package quizz.model;

public class Theme {

    private String m_nameTheme;
    private String m_pictureTheme;

    /**
     * The construct of the Theme
     *
     * @param name the name of the Theme
     * @param picture the path or URL of the picture
     */
    public Theme(String name, String picture) {
        this.m_nameTheme = name;
        this.m_pictureTheme = picture;
    }

    /**
     * Save in the database the Theme
     */
    public void saveTheme() {
        DBController.Get().executeInsert("theme",
                "name_theme,picture_theme",
                "'" + this.m_nameTheme
                + "','" + this.m_pictureTheme + "'");
    }
}
