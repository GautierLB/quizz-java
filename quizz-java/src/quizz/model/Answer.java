package quizz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Answer {

    public static final String TABLE_NAME = "BDD_B3I_groupe_3.dbo.[ANSWERS]";
    public static final String ID = "ID_ANSWER";
    public static final String LABEL = "LABEL_ANSWERS";
    public static final String PICTURE = "PICTURE_ANSWERS";
    public static final String IS_VALID = "IS_VALID";
    private String m_labelAnswer;
    private String m_pictureAnswer;
    private Boolean m_isValid;

    /**
     * Contruct of the Answer
     *
     * @param label the label of the Answer
     * @param picture the path/URL of the picture
     * @param isValid correct answer for question
     */
    public Answer(String label, String picture, Boolean isValid) {
        this.m_labelAnswer = label;
        this.m_pictureAnswer = picture;
        this.m_isValid = isValid;
    }

    /**
     * get all the answer of a question
     *
     * @param idQuestion the id of the question
     * @return an ArrayList of Answer
     */
    static public ArrayList<Answer> getAnswerForQuestion(int idQuestion) {
        ArrayList<Answer> answerList = new ArrayList<>();
        ArrayList<HashMap<String, Object>> answerListBdd = DBController.Get().executeSelect("*", Answer.TABLE_NAME + " , " + QuizzManager.QUESTIONS_HAVE_ANSWER, "WHERE ID_QUESTION =" + idQuestion);
        for (int i = 0; i < answerListBdd.size(); i++) {
            Answer answer = new Answer((String) answerListBdd.get(i).get(Answer.LABEL),
                    (String) answerListBdd.get(i).get(Answer.PICTURE),
                    (Boolean) answerListBdd.get(i).get(Answer.IS_VALID));
            answerList.add(answer);
        }
        return answerList;
    }

    /**
     * Save question in DB
     *
     * @return index of the saved question
     */
    public int saveAnswerInDB() {
        return DBController.Get().executeInsert(Answer.TABLE_NAME,
                Answer.LABEL + "," + Answer.PICTURE + "," + Answer.IS_VALID,
                "'" + this.m_labelAnswer
                + "','" + this.m_pictureAnswer
                + "','" + this.m_isValid + "'");
    }
}
