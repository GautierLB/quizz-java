/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

public class Quizz {

    private static DBController m_controller;
    private int m_idQuizz;
    private int m_idTheme;
    private int m_idAdmin;
    private int m_nbQuestQuizz;
    private int m_difficultyQuizz;
    private int m_timeMaxQuizz;
    private boolean m_retryQuizz;
    private String m_nameQuizz;

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
     */
    public void saveQuizz() {
        this.m_idQuizz = this.m_controller.Get().executeInsert("quizz",
                "id_theme,id_admin,nb_quest_quizz,difficulty_quizz,time_max_quizz,retry_quizz,name_quizz",
                this.m_idTheme + ","
                + this.m_idAdmin + ","
                + this.m_nbQuestQuizz + ","
                + this.m_difficultyQuizz + ","
                + this.m_timeMaxQuizz + ",'"
                + this.m_retryQuizz + "','"
                + this.m_nameQuizz + "'");

    }

    /**
     * Make the link between a question and the quizz in the database (insert
     * COMPOSE)
     *
     * @param question ths question we want to add to the quizz
     */
    public void addQuestion(Question question) {
        this.m_controller.Get().executeInsert("compose",
                "id_quizz,id_question",
                this.m_idQuizz + ","
                + question.GetId());
    }
}
