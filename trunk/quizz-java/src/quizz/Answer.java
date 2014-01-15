/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

/**
 *
 *
 */
public class Answer {

    private static DBController m_controller;
    private int m_idAnswer;
    private String m_labelAnswer;
    private String m_pictureAnswer;
    private Boolean m_isValid;

    /**
     * Contruct of the Answer
     *
     * @param label the label of the Answer
     * @param picture the path of the picture (or the URL)
     */
    public Answer(String label, String picture, Boolean isValid) {
        this.m_labelAnswer = label;
        this.m_pictureAnswer = picture;
        this.m_isValid = isValid;
    }

    /**
     * Save in the database the question
     */
    public void saveAnswer() {
        this.m_controller.Get().executeInsert("answers",
                "label_answers,picture_answers,is_valid",
                "'" + this.m_labelAnswer
                + "','" + this.m_pictureAnswer
                + "','" + this.m_isValid + "'");
    }

    /**
     * Get the Id of the Answer
     *
     * @return the id of the Answer
     */
    public int getId() {
        return this.m_idAnswer;
    }
}
