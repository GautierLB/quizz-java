package quizz.model;

public class Answer {

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
     * Save question in DB
     * 
     * @return index of the saved question
     */
    public int saveAnswerInDB() {
        return DBController.Get().executeInsert("answers",
                "label_answers,picture_answers,is_valid",
                "'" + this.m_labelAnswer
                + "','" + this.m_pictureAnswer
                + "','" + this.m_isValid + "'");
    }
}
