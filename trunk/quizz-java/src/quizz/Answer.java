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
    private String m_labelAnswer;
    private String m_pictureAnswer;

    public Answer(String label, String picture) {
        this.m_labelAnswer = label;
        this.m_pictureAnswer = picture;
    }

    /**
     * Save in the database the question
     */
    public void saveAnswer() {
        this.m_controller.Get().executeInsert("answers",
                "label_answers,picture_answers",
                "'" + this.m_labelAnswer + "','" + this.m_pictureAnswer + "'");
    }
}
