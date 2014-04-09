package quizz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {

    public static final String TABLE_NAME = "BDD_B3I_groupe_3.dbo.[QUESTIONS]";
    public static final String ID = "ID_QUESTION";
    public static final String LABEL = "LABEL_QUESTION";
    public static final String PICTURE = "PICTURE_QUESTION";
    private int m_id;
    private String m_labelQuestion;
    private String m_pictureQuestion;
    private String m_type;

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
     * Used when we create a question from DB because we know the ID
     *
     * @param id The id of the question
     * @param label The label of the question
     * @param picture The path of the picture (or the URL)
     */
    public Question(int id, String label, String picture) {
        this.m_id = id;
        this.m_labelQuestion = label;
        this.m_pictureQuestion = picture;
    }

    /**
     * get all the Question from a quizz
     *
     * @param idQuizz the id of the quizz
     * @return an ArrayList of Question
     */
    static public ArrayList<Question> getQuestionsForQuizz(int idQuizz) {
        ArrayList<Question> quizzList = new ArrayList<>();
        ArrayList<HashMap<String, Object>> quizzListBdd = DBController.Get().executeSelect("*",
                Question.TABLE_NAME + " , " + QuizzManager.QUIZZ_COMPOSE_QUESTIONS,
                "WHERE ID_QUIZZ =" + idQuizz + " AND " + Question.TABLE_NAME + "." + Question.ID + "=" + QuizzManager.QUIZZ_COMPOSE_QUESTIONS + "." + Question.ID);
        for (int i = 0; i < quizzListBdd.size(); i++) {
            Question question = new Question((int) quizzListBdd.get(i).get(Question.ID),
                    (String) quizzListBdd.get(i).get(Question.LABEL),
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

    /**
     * get the text of the question
     * @return String
     */
    public String getLabel() {
        return this.m_labelQuestion;
    }

    /**
     * get the URL of the picture
     * @return String
     */
    public String getPicture() {
        return this.m_pictureQuestion;
    }

    /**
     * get the type of an question for the creation or modification
     * @return a String
     */
    public String getType() {
        return this.m_type;
    }

    /**
     * Set the Type of an question for the creation or modification
     * @param theType a String ("Text" or "Image" or "Both")
     */
    public void setType(String theType) {
        this.m_type = theType;
    }
}
