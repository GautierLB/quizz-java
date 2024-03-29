package quizz.model;

import java.util.ArrayList;

public class QuizzManager {

    public static final String QUIZZ_COMPOSE_QUESTIONS = "BDD_B3I_groupe_3.dbo.[COMPOSE]";
    public static final String QUESTIONS_HAVE_ANSWER = "BDD_B3I_groupe_3.dbo.[HAVE]";

    public static void linkAnswersToQuestion(Question question, ArrayList<Answer> answersList) {
        question.saveQuestionInDB();
        for (int i = 0; i < answersList.size(); i++) {
            int answerId = answersList.get(i).saveAnswerInDB();
            DBController.Get().executeInsert("have", "id_question,id_answer", question.getId() + "," + answerId);
        }
    }

    public static void linkQuestionsToQuizz(Quizz quizz, ArrayList<Question> questionsList) {
        quizz.saveQuizz();
        for (int i = 0; i < questionsList.size(); i++) {
            DBController.Get().executeInsert("compose", "id_quizz,id_question", quizz.getId() + "," + questionsList.get(i).getId());
        }
    }

    public static void deleteLinkAnswerToQuestion(Question question, ArrayList<Answer> answerList) {
        DBController.Get().executeDelete("have", Question.ID+" = "+question.getId());
        for (int i = 0; i < answerList.size(); i++) {           
            answerList.get(i).deleteAnswerInDB();          
        }
    }
    
    public static void deleteLinkQuestionToQuizz(Quizz quizz , ArrayList<Question> questionsList){
        DBController.Get().executeDelete("compose", Quizz.ID_QUIZZ+" = "+quizz.getId());
        for(int i = 0; i<questionsList.size();i++){           
            questionsList.get(i).deleteQuestionInDB();
        }
    }
}
