package quizz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {

    public static final String TABLE_NAME = "BDD_B3I_groupe_3.dbo.[QUESTIONS]";
    public static final String ID = "ID_QUESTION";
    public static final String LABEL = "LABEL_QUESTION";
    public static final String PICTURE = "PICTURE_QUESTION";
    private String m_labelQuestion;
    private String m_pictureQuestion;
    private int m_id;

    /**
     * The construct of a Question
     *
     * @param label The label of the question
     * @param picture The path of the picture (or the URL)
     */
    public Question(String label, String picture) {
        this.m_labelQuestion = label;
        this.m_pictureQuestion = picture;
    }

    /**
     * get all the Question from a quizz
     *
     * @param idQuizz the id of the quizz
     * @return an ArrayList of Question
     */
    static public ArrayList<Question> getQuestionForQuizz(int idQuizz) {
        ArrayList<Question> quizzList = new ArrayList<>();
        ArrayList<HashMap<String, Object>> quizzListBdd = DBController.Get().executeSelect("*", Question.TABLE_NAME + " , " + QuizzManager.QUIZZ_COMPOSE_QUESTIONS, "WHERE ID_QUIZZ =" + idQuizz);
        for (int i = 0; i < quizzListBdd.size(); i++) {
            Question question = new Question((String) quizzListBdd.get(i).get(Question.LABEL),
                    (String) quizzListBdd.get(i).get(Question.PICTURE));
            quizzList.add(question);
        }
        return quizzList;
    }

    /**
     * Save in the database the Question
     *
     * @return the id of the created question
     */
    public int saveQuestionInDB() {
        this.m_id = DBController.Get().executeInsert(Question.TABLE_NAME,
                Question.LABEL + ',' + Question.PICTURE,
                "'" + this.m_labelQuestion + "','" + this.m_pictureQuestion + "'");
        return this.m_id;
    }

    public int getId() {
        return this.m_id;
    }
}
