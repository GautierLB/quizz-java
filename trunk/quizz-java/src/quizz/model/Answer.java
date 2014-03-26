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
     * Answer constructor
     *
     * @param label The label of the Answer
     * @param picture The path/URL of the picture
     * @param isValid Correct answer for question
     */
    public Answer(String label, String picture, Boolean isValid) {
        this.m_labelAnswer = label;
        this.m_pictureAnswer = picture;
        this.m_isValid = isValid;
    }

    /**
     * Get all answers for a question
     *
     * @param idQuestion The question's id
     * @return An ArrayList of Answers
     */
    static public ArrayList<Answer> getAnswerForQuestion(int idQuestion) {
        ArrayList<Answer> answersForQuestion = new ArrayList<>();
        ArrayList<HashMap<String, Object>> answerListFromDB = DBController.Get().executeSelect("*", Answer.TABLE_NAME + " , " + QuizzManager.QUESTIONS_HAVE_ANSWER, 
                "WHERE ID_QUESTION =" + idQuestion + " AND " + Answer.TABLE_NAME + "." + Answer.ID + "=" + QuizzManager.QUESTIONS_HAVE_ANSWER + "." + Answer.ID);
        for (int i = 0; i < answerListFromDB.size(); i++) {
            Answer answer = new Answer((String) answerListFromDB.get(i).get(Answer.LABEL),
                    (String) answerListFromDB.get(i).get(Answer.PICTURE),
                    (Boolean) answerListFromDB.get(i).get(Answer.IS_VALID));
            answersForQuestion.add(answer);
        }
        return answersForQuestion;
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
    
    public String getLabel() {
        return this.m_labelAnswer;
    }
    
    public String getPicture() {
        return this.m_pictureAnswer;
    }
}
