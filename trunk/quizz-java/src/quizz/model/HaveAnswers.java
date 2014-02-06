package quizz.model;

import java.util.List;

public abstract class HaveAnswers {
    private static DBController s_dbController;
    private int m_questionId;
    
    public HaveAnswers() {
        s_dbController = DBController.Get();
    }
    
    public void linkAnswersToQuestion(Question question, List<Answer> answersList) {
        m_questionId = question.saveQuestionInDB();
        for (int i = 0; i < answersList.size(); i++) {
            int answerId = answersList.get(i).saveAnswerInDB();
            s_dbController.executeInsert("have", "id_question,id_answer", m_questionId + "," + answerId);
        }
    }
    
    // Revoir la sauvegarde des quizz car il faut recuperer la questionID
    public void linkQuestionsToQuizz(Quizz quizz, List<Question> questionsList) {
        int quizzId = quizz.saveQuizz();
        for (int i = 0; i < questionsList.size(); i++) {
            s_dbController.executeInsert("compose", "id_quizz,id_question", quizzId + "," + questionsList.get(i).getId());
        }
    }
}
