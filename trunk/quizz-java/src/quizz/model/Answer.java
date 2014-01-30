package quizz.model;

public class Answer {

    private static DBController s_controller;
    private String m_labelAnswer;
    private String m_pictureAnswer;
    private Boolean m_isValid;

    /**
     * Contruct of the Answer
     *
     * @param label the label of the Answer
     * @param picture the path/URL of the picture
     * @param isValid correct answer for question
     * 
     * @return the created answer
     */
    public Answer(String label, String picture, Boolean isValid) {
        this.m_labelAnswer = label;
        this.m_pictureAnswer = picture;
        this.m_isValid = isValid;
    }

    /**
     * Save question in DB
     */
    public int saveAnswerInDB() {
        return this.s_controller.Get().executeInsert("answers",
                "label_answers,picture_answers,is_valid",
                "'" + this.m_labelAnswer
                + "','" + this.m_pictureAnswer
                + "','" + this.m_isValid + "'");
    }
}
