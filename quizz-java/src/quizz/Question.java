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
    
    public int GetId(){
        return this.m_idQuestion;
    }
}
