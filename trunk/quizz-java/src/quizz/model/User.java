package quizz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    public static final String ID = "ID_USER";
    public static final String PSEUDO = "PSEUDO_USER";
    public static final String MDP = "MDP_USER";
    public static final String MAIL = "MAIL_USER";

    private int m_idUser;
    private String m_pseudoUser;
    private String m_passwordUser;
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
        this.m_passwordUser = mdp;
        this.m_mailUser = mail;
    }

    /**
     * User constructor with id
     *
     * @param id id of the user
     * @param pseudo pseudo of the user
     * @param mdp password of the user
     * @param mail email of the user
     *
     * @return the created user
     */
    public User(int id, String pseudo, String mdp, String mail) {
        this.m_idUser = id;
        this.m_pseudoUser = pseudo;
        this.m_passwordUser = mdp;
        this.m_mailUser = mail;
    }

    static public User getUserForId(int id) {
        DBController dBController = DBController.Get();
        ArrayList<HashMap<String, Object>> userList = dBController.executeSelect("*", "user", "where ID_USER = " + id);
        return new User((int) userList.get(0).get(User.ID),
                (String)userList.get(0).get(User.PSEUDO),
                (String)userList.get(0).get(User.MDP),
                (String)userList.get(0).get(User.MAIL));
    }

    /**
     * Save user in DB
     */
    public void saveUser() {
        this.setIdUser(DBController.Get().executeInsert("user", "pseudo_user,mdp_user,mail_user", "'" + this.getPseudoUser() + "','" + this.getPasswordUser() + "','" + this.getMailUser() + "'"));
    }

    /**
     * @return the m_idUser
     */
    public int getIdUser() {
        return m_idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.m_idUser = idUser;
    }

    /**
     * @return the pseudoUser
     */
    public String getPseudoUser() {
        return m_pseudoUser;
    }

    /**
     * @param pseudoUser the pseudoUser to set
     */
    public void setPseudoUser(String pseudoUser) {
        this.m_pseudoUser = pseudoUser;
    }

    /**
     * @return the passwordUser
     */
    public String getPasswordUser() {
        return m_passwordUser;
    }

    /**
     * @param passwordUser the passwordUser to set
     */
    public void setPasswordUser(String passwordUser) {
        this.m_passwordUser = passwordUser;
    }

    /**
     * @return the mailUser
     */
    public String getMailUser() {
        return m_mailUser;
    }

    /**
     * @param mailUser the mailUser to set
     */
    public void setMailUser(String mailUser) {
        this.m_mailUser = mailUser;
    }
}
