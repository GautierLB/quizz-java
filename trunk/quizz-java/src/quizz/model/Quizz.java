/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.model;

public class Quizz {

    private int m_idQuizz;
    private int m_idTheme;
    private int m_idAdmin;
    private int m_nbQuestQuizz;
    private int m_difficultyQuizz;
    private int m_timeMaxQuizz;
    private boolean m_retryQuizz;
    private String m_nameQuizz;

    /**
     * The construct of a quizz
     *
     * @param idTheme The Id of the theme for the question
     * @param idAdmin The Id of the Admin how have create the quizz
     * @param nb The number of questions
     * @param dif The difficulty of the quizz
     * @param time The time to make the quizz
     * @param retry Boolean for know if the user a the right to retry or not
     * @param name The name of the quizz
     */
    public Quizz(int idTheme, int idAdmin, int nb, int dif, int time, boolean retry, String name) {
        this.m_idTheme = idTheme;
        this.m_idAdmin = idAdmin;
        this.m_nbQuestQuizz = nb;
        this.m_difficultyQuizz = dif;
        this.m_timeMaxQuizz = time;
        this.m_retryQuizz = retry;
        this.m_nameQuizz = name;
    }

    /**
     * Save the Quiz in the database
     * 
     * @return index of saved 
     */
    public int saveQuizz() {
        return DBController.Get().executeInsert("quizz",
                "id_theme,id_admin,nb_quest_quizz,difficulty_quizz,time_max_quizz,retry_quizz,name_quizz",
                this.m_idTheme + ","
                + this.m_idAdmin + ","
                + this.m_nbQuestQuizz + ","
                + this.m_difficultyQuizz + ","
                + this.m_timeMaxQuizz + ",'"
                + this.m_retryQuizz + "','"
                + this.m_nameQuizz + "'");

    }
}