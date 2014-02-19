package quizz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Scoring {

    private static final String TABLE_NAME = "BDD_B3I_groupe_3.dbo.[SCORING]";
    private static final String USER = "ID_USER";
    private static final String QUIZZ = "ID_QUIZZ";
    private static final String SCORE = "SCORE";
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
     * Get all the score for the quizz
     *
     * @param idQuizz the id of the quizz
     * @return an ArrayList of scoring
     */
    static public ArrayList<Scoring> getScoreForQuiz(int idQuizz) {
        ArrayList<Scoring> scoreList = new ArrayList<>();
        ArrayList<HashMap<String, Object>> scoreListBdd = DBController.Get().executeSelect("*", "scoring", "WHERE ID_QUIZZ =" + idQuizz);
        for (int i = 0; i < scoreListBdd.size(); i++) {
            Scoring score = new Scoring((int) scoreListBdd.get(i).get(Scoring.USER),
                    (int) scoreListBdd.get(i).get(Scoring.QUIZZ),
                    (int) scoreListBdd.get(i).get(Scoring.SCORE));
            scoreList.add(score);
        }
        return scoreList;
    }

    /**
     * Save in the database the score of the quiz
     */
    public void saveScoring() {
        DBController.Get().executeInsert(Scoring.TABLE_NAME,
                Scoring.USER + ',' + Scoring.QUIZZ + ',' + Scoring.SCORE,
                "" + this.m_idUser
                + "," + this.m_idQuizz
                + "," + this.m_score);
    }
}
