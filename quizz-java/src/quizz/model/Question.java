package quizz.model;

public class Question {

    private static DBController s_controller;
    private String m_labelQuestion;
    private String m_pictureQuestion;

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
     * Save in the database the Question
     * 
     * @return the id of the created question
     */
    public int saveQuestionInDB() {
        return this.s_controller.Get().executeInsert("questions",
                "label_question,picture_question",
                "'" + this.m_labelQuestion + "','" + this.m_pictureQuestion + "'");
    }
}
