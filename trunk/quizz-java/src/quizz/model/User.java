package quizz.model;

public class User {

    private static DBController m_controller;
    public int m_idUser;
    private String m_pseudoUser;
    private String m_mdpUser;
    private String m_mailUser;

    /**
     * User constructor
     * 
     * @param pseudo pseudo of the user
     * @param mdp password of the user
     * @param mail email of the user
     * 
     * @return the created user
     */
    public User(String pseudo, String mdp, String mail) {
        this.m_pseudoUser = pseudo;
        this.m_mdpUser = mdp;
        this.m_mailUser = mail;
    }

    /**
     * Save user in DB
     */
    public void saveUser() {
        this.m_idUser = this.m_controller.Get().executeInsert("user",
                "pseudo_user,mdp_user,mail_user",
                "'" + this.m_pseudoUser
                + "','" + this.m_mdpUser
                + "','" + this.m_mailUser + "'");
    }
}
