package quizz.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class Score {

    private static final String TABLE_NAME = "BDD_B3I_groupe_3.dbo.[SCORING]";
    private static final String USER = "ID_USER";
    private static final String QUIZZ = "ID_QUIZZ";
    private static final String SCORE = "SCORE";
    private int m_idUser;
    private int m_idQuizz;
    private int m_score;
    private int m_numberOfGoodAnswers;
    private Timestamp m_time;

    /**
     * The construct of Scoring
     *
     * @param idUser the Id of the user how make the score
     * @param idQuizz the Id of the quizz how is concerne by the Score
     * @param score the score of the user
     */
    public Score(int idUser, int idQuizz, int score) {
        this.m_idQuizz = idUser;
        this.m_idUser = idQuizz;
        this.m_score = score;
    }
    
    /**
     * The construct of Scoring
     *
     * @param idUser the Id of the user how make the score
     * @param idQuizz the Id of the quizz how is concerne by the Score
     * @param score the score of the user
     * @param goodAnswers the number of good answers
     * @param time the time spent to do the quizz
     */
    public Score(int idUser, int idQuizz, int score, int goodAnswers, Timestamp time) {
        this.m_idQuizz = idUser;
        this.m_idUser = idQuizz;
        this.m_score = score;
        this.m_numberOfGoodAnswers = goodAnswers;
        this.m_time = time;
    }

    /**
     * Get all the score for the quizz
     *
     * @param idQuizz the id of the quizz
     * @return an ArrayList of scoring
     */
    static public ArrayList<Score> getScoreForQuiz(int idQuizz) {
        ArrayList<Score> scoreList = new ArrayList<>();
        ArrayList<HashMap<String, Object>> scoreListBdd = DBController.Get().executeSelect("*", "scoring", "WHERE ID_QUIZZ =" + idQuizz);
        for (int i = 0; i < scoreListBdd.size(); i++) {
            Score score = new Score((int) scoreListBdd.get(i).get(Score.USER),
                    (int) scoreListBdd.get(i).get(Score.QUIZZ),
                    (int) scoreListBdd.get(i).get(Score.SCORE));
            scoreList.add(score);
        }
        return scoreList;
    }

    /**
     * Save in the database the score of the quiz
     */
    public void saveScore() {
        DBController.Get().executeInsert(Score.TABLE_NAME,
                Score.USER + ',' + Score.QUIZZ + ',' + Score.SCORE,
                "" + this.m_idUser
                + "," + this.getIdQuizz()
                + "," + this.getScore());
    }

    /**
     * @return the m_idQuizz
     */
    public int getIdQuizz() {
        return m_idQuizz;
    }

    /**
     * @return the m_score
     */
    public int getScore() {
        return m_score;
    }

    /**
     * @return the m_numberOfGoodAnswers
     */
    public int getNumberOfGoodAnswers() {
        return m_numberOfGoodAnswers;
    }

    /**
     * @return the m_time
     */
    public Timestamp getTime() {
        return m_time;
    }
    
}
