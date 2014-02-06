package quizz.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

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
        int idUser = 0;
        String pseudoUser = "";
        String passwordUser = "";
        String mailUser = "";
        DBController controller = DBController.Get();
        ResultSet result = controller.executeSelect("*", "user", "where ID_USER = " + id);
        try {
            while (result.next()) {
                idUser = result.getInt("ID_USER");
                pseudoUser = result.getString("PSEUDO_USER");
                passwordUser = result.getString("MDP_USER");
                mailUser = result.getString("MAIL_USER");
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        controller.closeRequest();
        return new User(idUser, pseudoUser, passwordUser, mailUser);
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
