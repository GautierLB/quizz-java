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
        System.out.println("clé créer dans object : " + this.m_idUser);
    }
}
