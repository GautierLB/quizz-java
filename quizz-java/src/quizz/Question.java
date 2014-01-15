/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.sql.*;

public class Question {

    private static DBController m_controller;
    private int m_idQuestion;
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
     */
    public void saveQuestion() {
        this.m_idQuestion = this.m_controller.Get().executeInsert("questions",
                "label_question,picture_question",
                "'" + this.m_labelQuestion + "','" + this.m_pictureQuestion + "'");
    }

    public int GetId() {
        return this.m_idQuestion;
    }

    /**
     * Make the link between the question and the answer in the database (
     * insert HAVE)
     *
     * @param answer the answer of the question
     */
    public void addAnswer(Answer answer) {
        this.m_controller.Get().executeInsert("have",
                "id_question,id_answer",
                this.m_idQuestion + ","
                + answer.getId());
    }
}
