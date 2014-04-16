package quizz.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class Score {

    private static final String TABLE_NAME = "BDD_B3I_groupe_3.dbo.[SCORING]";
    private static final String USER = "ID_USER";
    private static final String QUIZZ = "ID_QUIZZ";
    private static final String SCORE = "SCORE";
    private int m_idQuizz;
    private int m_score;
    private int m_numberOfGoodAnswers;
    private int m_numberOfQuestions;
    private Timestamp m_time;

    /**
     * The construct of Scoring
     *
     * @param idQuizz the Id of the quizz how is concerne by the Score
     * @param score the score of the user
     */
    public Score(int idQuizz, int score) {
        this.m_idQuizz = idQuizz;
        this.m_score = score;
    }
    
    /**
     * The construct of Scoring
     *
     * @param idQuizz the Id of the quizz how is concerne by the Score
     * @param goodAnswers the number of good answers
     * @param numberOfQuestions the number of questions in the quizz
     * @param time the time spent to do the quizz
     */
    public Score(int idQuizz, int goodAnswers, int numberOfQuestions, Timestamp time) {
        this.m_idQuizz = idQuizz;
        this.m_numberOfGoodAnswers = goodAnswers;
        this.m_numberOfQuestions = numberOfQuestions;
        this.m_time = time;
        this.m_score = this.loadScore();
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
            Score score = new Score((int) scoreListBdd.get(i).get(Score.QUIZZ),
                    (int) scoreListBdd.get(i).get(Score.SCORE));
            scoreList.add(score);
        }
        return scoreList;
    }

    /**
     * Save in the database the score of the quiz
     */
    public void saveScore(int idUser) {
        DBController.Get().executeInsert(Score.TABLE_NAME,
                Score.USER + ',' + Score.QUIZZ + ',' + Score.SCORE,
                "" + idUser
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
    
    public int goodAnswersPourcentage() {
        return m_numberOfGoodAnswers * 100 / m_numberOfQuestions;
    }
    
    private int loadScore() {
        return 1000 * (this.goodAnswersPourcentage() / 100);
    }
    
}
