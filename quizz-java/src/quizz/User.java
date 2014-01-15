/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

/**
 *
 *
 */
public class User {

    private static DBController m_controller;
    public int m_idUser;
    private String m_pseudoUser;
    private String m_mdpUser;
    private String m_mailUser;

    /**
     * the Contruct of the User
     *
     * @param pseudo the pseudo of the user
     * @param mdp the password of the user
     * @param mail the mail of the user
     */
    public User(String pseudo, String mdp, String mail) {
        this.m_pseudoUser = pseudo;
        this.m_mdpUser = mdp;
        this.m_mailUser = mail;
    }

    /**
     * add a user to the database
     */
    public void saveUser() {
        this.m_idUser = this.m_controller.Get().executeInsert("user",
                "pseudo_user,mdp_user,mail_user",
                "'" + this.m_pseudoUser
                + "','" + this.m_mdpUser
                + "','" + this.m_mailUser + "'");
    }

    /**
     * Make the link between a answer and the user in the database (insert
     * CHOOSE)
     *
     * @param answer the answer how have choose the user
     */
    public void addAnswer(Answer answer) {
        this.m_controller.Get().executeInsert("choose",
                "id_question,id_answer",
                this.m_idUser + ","
                + answer.getId());
    }
}
