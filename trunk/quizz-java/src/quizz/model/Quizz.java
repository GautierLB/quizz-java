/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Quizz {

    private static final String TABLE_NAME = "BDD_B3I_groupe_3.dbo.[QUIZZ]";
    private static final String ID_THEME = "ID_THEME";
    private static final String ID_ADMIN = "ID_ADMIN";
    private static final String NB_QUESTS = "NB_QUEST_QUIZZ";
    private static final String DIFFICULTY = "DIFFICULTY_QUIZZ";
    private static final String TIME_MAX = "TIME_MAX_QUIZZ";
    private static final String RETRY = "RETRY_QUIZZ";
    private static final String NAME = "NAME_QUIZZ";
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
     * @param idTheme The id of the quizz theme
     * @param idAdmin The id of the Admin that have created the quizz
     * @param dif The difficulty of the quizz
     * @param time The time to make the quizz
     * @param retry Boolean to know if the user can retry or not
     * @param name The name of the quizz
     */
    public Quizz(int idTheme, int idAdmin, int dif, int time, boolean retry, String name) {
        this.m_idTheme = idTheme;
        this.m_idAdmin = idAdmin;
        this.m_difficultyQuizz = dif;
        this.m_timeMaxQuizz = time;
        this.m_retryQuizz = retry;
        this.m_nameQuizz = name;
    }

    /**
     * Get the quizz for a specificated theme
     *
     * @param idTheme the id of the theme
     * @return an ArrayList of Quizz
     */
    static public ArrayList<Quizz> getQuizzForTheme(int idTheme) {
        ArrayList<Quizz> quizzList = new ArrayList<>();
        ArrayList<HashMap<String, Object>> quizzListBdd = DBController.Get().executeSelect("*", Quizz.TABLE_NAME, "WHERE ID_THEME =" + idTheme);
        for (int i = 0; i < quizzListBdd.size(); i++) {
            Quizz quizz = new Quizz((int) quizzListBdd.get(i).get(Quizz.ID_THEME),
                    (int) quizzListBdd.get(i).get(Quizz.ID_ADMIN),
                    (int) quizzListBdd.get(i).get(Quizz.DIFFICULTY),
                    (int) quizzListBdd.get(i).get(Quizz.TIME_MAX),
                    (boolean) quizzListBdd.get(i).get(Quizz.RETRY),
                    (String) quizzListBdd.get(i).get(Quizz.NAME));  
            quizz.setNbQuestQuizz((int) quizzListBdd.get(i).get(Quizz.NB_QUESTS));
            quizzList.add(quizz);
        }
        return quizzList;
    }

    /**
     * Save the Quiz in the database
     *
     * @return index of saved
     */
    public int saveQuizz() {
        this.m_idQuizz = DBController.Get().executeInsert(TABLE_NAME,
                ID_THEME + "," + ID_ADMIN + "," + NB_QUESTS + "," + DIFFICULTY + "," + TIME_MAX + "," + RETRY + "," + NAME,
                this.m_idTheme + ","
                + this.m_idAdmin + ","
                + this.m_nbQuestQuizz + ","
                + this.m_difficultyQuizz + ","
                + this.m_timeMaxQuizz + ",'"
                + this.m_retryQuizz + "','"
                + this.m_nameQuizz + "'");
        return this.m_idQuizz;
    }

    public int getId() {
        return this.m_idQuizz;
    }
    
    public String getName() {
        return this.m_nameQuizz;
    }
    
    public Boolean isRetryable() {
        return this.m_retryQuizz;
    }
    
    public int getTimeMax() {
        return this.m_timeMaxQuizz;
    }
    
    public int getDifficulty() {
        return this.m_difficultyQuizz;
    }
    
    public int getNbQuest() {
        return this.m_nbQuestQuizz;
    }

    /**
     * @param nbQuestQuizz the number of questions to set
     */
    public void setNbQuestQuizz(int nbQuestQuizz) {
        this.m_nbQuestQuizz = nbQuestQuizz;
    }
}
