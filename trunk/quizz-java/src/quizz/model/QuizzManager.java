package quizz.model;

import java.util.ArrayList;

public class QuizzManager {
    
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
}
