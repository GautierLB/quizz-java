package quizz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Score {

    private static final String TABLE_NAME = "BDD_B3I_groupe_3.dbo.[SCORING]";
    private static final String USER = "ID_USER";
    private static final String QUIZZ = "ID_QUIZZ";
    private static final String SCORE = "SCORE";
    private static final String NB_GOOD_ANSWERS = "COUNT_GOOD_ANSWER";
    private static final String TIME = "TIME";

    private int m_idQuizz;
    private long m_score;
    private int m_idUser;
    private int m_numberOfGoodAnswers;
    private int m_numberOfQuestions;
    private long m_time;
    private int m_nbQuizz;
    private int m_classement;

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
    public Score(int idQuizz, int goodAnswers, int numberOfQuestions, long time, int classement, int idUser) {
        this.m_idQuizz = idQuizz;
        this.m_numberOfGoodAnswers = goodAnswers;
        this.m_numberOfQuestions = numberOfQuestions;
        this.m_time = time;
        this.m_score = this.loadScore();
        this.m_classement = classement;
        this.m_idUser = idUser;
    }

    /**
     * The construct of Scoring
     *
     * @param idQuizz the Id of the quizz how is concerne by the Score
     * @param goodAnswers the number of good answers
     * @param score
     * @param time the time spent to do the quizz
     */
    public Score(int goodAnswers, int score, long time, int nbQuest, int nbQuizz) {
        this.m_numberOfGoodAnswers = goodAnswers;
        this.m_time = time;
        this.m_score = score;
        this.m_numberOfQuestions = nbQuest;
        this.m_nbQuizz = nbQuizz;
    }

    /**
     * Get all the score for the quizz
     *
     * @param idQuizz the id of the quizz
     * @return an ArrayList of scoring
     */
    /* static public ArrayList<Score> getScoreForQuiz(int idQuizz) {
     ArrayList<Score> scoreList = new ArrayList<>();
     ArrayList<HashMap<String, Object>> scoreListBdd = DBController.Get().executeSelect("*", "scoring", "WHERE ID_QUIZZ =" + idQuizz);
     for (int i = 0; i < scoreListBdd.size(); i++) {
     Score score = new Score((int) scoreListBdd.get(i).get(Score.QUIZZ),
     (int) scoreListBdd.get(i).get(Score.NB_GOOD_ANSWERS),
     (int) scoreListBdd.get(i).get(Score.SCORE),
     (long) scoreListBdd.get(i).get(Score.TIME));
     scoreList.add(score);
     }
     return scoreList;
     }*/
    /**
     * Save in the database the score of the quiz
     */
    public void saveScore(int idUser) {
        DBController.Get().executeInsert(Score.TABLE_NAME,
                Score.USER + ',' + Score.QUIZZ + ',' + Score.SCORE + ',' + Score.NB_GOOD_ANSWERS + ',' + Score.TIME,
                "" + idUser
                + "," + this.getIdQuizz()
                + "," + this.getScore()
                + "," + this.getNumberOfGoodAnswers()
                + "," + this.getTime());

    }

    public static void deleteScoreForAQuizz(int idQuizz) {
        DBController.Get().executeDelete(Score.TABLE_NAME, Quizz.ID_QUIZZ + " = " + idQuizz);
    }

    static public int getClassementForAQuizz(int idQuizz, int scorePlayer) {
        ArrayList<HashMap<String, Object>> scoreList = DBController.Get().executeSelect("SCORE", Score.TABLE_NAME, "WHERE ID_QUIZZ=" + idQuizz + " ORDER BY SCORE ASC");
        int classement = scoreList.size();
        for (int i = 0; i < scoreList.size(); i++) {
            if (scorePlayer > (int) scoreList.get(i).get(Score.SCORE)) {
                classement--;
            }
            System.out.println("score : " + scoreList.get(i).get(Score.SCORE));
        }
        return classement;

    }

    static public Boolean isAlreadyPlayed(int idQuizz, int idUser) {
        ArrayList<HashMap<String, Object>> scoreList = DBController.Get().executeSelect("SCORE", Score.TABLE_NAME, "WHERE ID_QUIZZ=" + idQuizz + " AND ID_USER=" + idUser);
        if (scoreList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void updateTheScore() {
        DBController.Get().executeUpdate(Score.TABLE_NAME, Score.SCORE, Long.toString(this.getScore()),
                Score.QUIZZ + " = " + this.getIdQuizz() + " AND " + Score.USER + " = " + this.getIdUser());
        DBController.Get().executeUpdate(Score.TABLE_NAME, Score.NB_GOOD_ANSWERS, Integer.toString(this.m_numberOfGoodAnswers),
                Score.QUIZZ + " = " + this.getIdQuizz() + " AND " + Score.USER + " = " + this.getIdUser());
        DBController.Get().executeUpdate(Score.TABLE_NAME, Score.TIME, Long.toString(this.m_time),
                Score.QUIZZ + " = " + this.getIdQuizz() + " AND " + Score.USER + " = " + this.getIdUser());
    }

    public static Score getGlobalScore(int idUser) {
        ArrayList<HashMap<String, Object>> scoreListBdd = DBController.Get().executeSelect("*", "scoring", "WHERE " + Score.USER + " = " + idUser);
        ArrayList<HashMap<String, Object>> quizzListBdd = DBController.Get().executeSelect("COUNT(Q." + Quizz.ID_QUIZZ + ")",
                Quizz.TABLE_NAME + " Q , " + Score.TABLE_NAME + "  S , " + User.TABLE_NAME + " U",
                "WHERE Q." + Quizz.ID_QUIZZ + " = S." + Score.QUIZZ + " AND "
                + "S." + Score.USER + " = U." + User.ID + " AND U."
                + User.ID + " = " + idUser);
        ArrayList<HashMap<String, Object>> questionListBdd = DBController.Get().executeSelect(Quizz.NB_QUESTS,
                Quizz.TABLE_NAME + " Q , " + Score.TABLE_NAME + "  S , " + User.TABLE_NAME + " U",
                "WHERE Q." + Quizz.ID_QUIZZ + " = S." + Score.QUIZZ + " AND "
                + "S." + Score.USER + " = U." + User.ID + " AND U."
                + User.ID + " = " + idUser);
        int nbQuest = 0;
        for (int i = 0; i < questionListBdd.size(); i++) {
            nbQuest += (int) questionListBdd.get(i).get(Quizz.NB_QUESTS);
        }
        int nbQuizz = (int) quizzListBdd.get(0).get("");
        int nbGoodAnswers = 0;
        int score = 0;
        long time = 0;
        for (int i = 0; i < scoreListBdd.size(); i++) {
            nbGoodAnswers += (int) scoreListBdd.get(i).get(Score.NB_GOOD_ANSWERS);
            score += (int) scoreListBdd.get(i).get(Score.SCORE);
            time += (int) scoreListBdd.get(i).get(Score.TIME);
        }
        return new Score(nbGoodAnswers, score, time, nbQuest, nbQuizz);
    }

    public static int getAvgGoodAnswer(int idQuizz) {
        ArrayList<HashMap<String, Object>> avgGoodAnswers
                = DBController.Get().executeSelect("AVG(" + Score.NB_GOOD_ANSWERS + ")",
                        Score.TABLE_NAME,
                        "WHERE " + Score.QUIZZ + " = " + idQuizz);
        if (avgGoodAnswers.get(0).get("") != null) {
            return (int) avgGoodAnswers.get(0).get("");
        } else {
            return 0;
        }
    }

    public static int getAvgScore(int idQuizz) {
        ArrayList<HashMap<String, Object>> avgGoodAnswers
                = DBController.Get().executeSelect("AVG(" + Score.SCORE + ")",
                        Score.TABLE_NAME,
                        "WHERE " + Score.QUIZZ + " = " + idQuizz);
        if (avgGoodAnswers.get(0).get("") != null) {
            return (int) avgGoodAnswers.get(0).get("");
        } else {
            return 0;
        }
    }

    public static int getAvgTime(int idQuizz) {
        ArrayList<HashMap<String, Object>> avgTime
                = DBController.Get().executeSelect("AVG(" + Score.TIME + ")",
                        Score.TABLE_NAME,
                        "WHERE " + Score.QUIZZ + " = " + idQuizz);
        if (avgTime.get(0).get("") != null) {
            return (int) avgTime.get(0).get("");
        } else {
            return 0;
        }
    }

    public static int getNbParticipant(int idQuizz) {
        ArrayList<HashMap<String, Object>> nbParticipant
                = DBController.Get().executeSelect("COUNT(DISTINCT S." + Score.USER + ")",
                        Score.TABLE_NAME + " S, " + User.TABLE_NAME + " U",
                        "WHERE U." + User.ID + "  = S." + Score.USER + " AND " + Score.QUIZZ + " = " + idQuizz);
         if (nbParticipant.get(0).get("") != null) {
            return (int) nbParticipant.get(0).get("");
        } else {
            return 0;
        }
    }

    public static Score getStatsForQuizz(Quizz quizz) {
        return new Score(Score.getAvgGoodAnswer(quizz.getId()),
                Score.getAvgScore(quizz.getId()),
                Score.getAvgTime(quizz.getId()),
                quizz.getNbQuest(),
                Score.getNbParticipant(quizz.getId()));
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
    public long getScore() {
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
    public long getTime() {
        return m_time;
    }

    public int goodAnswersPourcentage() {
        return (int) (((double) m_numberOfGoodAnswers / m_numberOfQuestions) * 100);
    }

    private long loadScore() {
        return (long) (10000 * ((double) this.goodAnswersPourcentage() / this.m_time));
    }

    /**
     * @return the m_nbQuizz
     */
    public int getNbQuizz() {
        return m_nbQuizz;
    }

    /**
     * @return the m_classement
     */
    public int getClassement() {
        return m_classement;
    }

    /**
     * @return the m_idUser
     */
    public int getIdUser() {
        return m_idUser;
    }

}
