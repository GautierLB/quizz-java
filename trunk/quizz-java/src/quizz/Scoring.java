/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

/**
 *
 *
 */
public class Scoring {

    private static DBController m_controller;
    private int m_idUser;
    private int m_idQuizz;
    private int m_score;

    public Scoring(int idUser, int idQuizz, int score) {
        this.m_idQuizz = idUser;
        this.m_idUser = idQuizz;
        this.m_score = score;
    }

    /**
     * Save in the database the score of the quiz
     */
    public void saveScoring() {
        this.m_controller.Get().executeInsert("scoring",
                "id_user,id_quizz,score",
                "" + this.m_idUser
                + "," + this.m_idQuizz
                + "," + this.m_score);
    }
}
