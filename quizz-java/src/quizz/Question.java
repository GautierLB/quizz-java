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

    public Question(int id, String label, String picture) {
        this.m_idQuestion = id;
        this.m_labelQuestion = label;
        this.m_pictureQuestion = picture;
    }

    /**
     * Save in the database and instantiate the Question
     * @param labelQuestion the label of the question
     * @param pictureQuestion  the picture of the question
     */
    public void saveQuestion() {
        this.m_controller.Get().executeInsert("questions", "label_question,picture_question", "'" + this.m_labelQuestion + "','" + this.m_pictureQuestion + "'");
    }
}
