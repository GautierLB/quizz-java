package quizz.model;

public class Scoring {

    private int m_idUser;
    private int m_idQuizz;
    private int m_score;

    /**
     * The construct of Scoring
     *
     * @param idUser the Id of the user how make the score
     * @param idQuizz the Id of the quizz how is concerne by the Score
     * @param score the score of the user
     */
    public Scoring(int idUser, int idQuizz, int score) {
        this.m_idQuizz = idUser;
        this.m_idUser = idQuizz;
        this.m_score = score;
    }

    /**
     * Save in the database the score of the quiz
     */
    public void saveScoring() {
        DBController.Get().executeInsert("scoring",
                "id_user,id_quizz,score",
                "" + this.m_idUser
                + "," + this.m_idQuizz
                + "," + this.m_score);
    }
}
