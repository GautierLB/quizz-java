package quizz.model;

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
