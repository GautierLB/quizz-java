package quizz.model;

public class Question {

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
        this.m_id = 0;
    }

    /**
     * Save in the database the Question
     * 
     * @return the id of the created question
     */
    public int saveQuestionInDB() {
        this.m_id = DBController.Get().executeInsert("questions",
                "label_question,picture_question",
                "'" + this.m_labelQuestion + "','" + this.m_pictureQuestion + "'");
        return this.m_id;
    }
    
    public int getId() {
        return this.m_id;
    }
}
