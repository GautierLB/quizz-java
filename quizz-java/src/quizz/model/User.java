package quizz.model;

import java.util.ArrayList;
import java.util.HashMap;
import quizz.Main;

public class User {

    public static final String TABLE_NAME = "BDD_B3I_groupe_3.dbo.[USER]";
    private static final String TABLE_ADMIN = "BDD_B3I_groupe_3.dbo.[ADMIN]";
    public static final String ID = "ID_USER";
    public static final String ID_ADMIN = "ID_ADMIN";
    private static final String PSEUDO = "PSEUDO_USER";
    private static final String MDP = "MDP_USER";
    private static final String MAIL = "MAIL_USER";
    private int m_idUser;
    private String m_pseudoUser;
    private String m_passwordUser;
    private String m_mailUser;
    private Boolean m_isAdmin;

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
    public User(int id, String pseudo, String mdp, String mail, boolean admin) {
        this.m_idUser = id;
        this.m_pseudoUser = pseudo;
        this.m_passwordUser = mdp;
        this.m_mailUser = mail;
        this.m_isAdmin = admin;
    }

    static public User getUserForId(int id) {
        boolean isAdmin;
        ArrayList<HashMap<String, Object>> userList = DBController.Get().executeSelect("*", User.TABLE_NAME, "where ID_USER = " + id);
        ArrayList<HashMap<String, Object>> userAdmin = DBController.Get().executeSelect("*", User.TABLE_ADMIN, "where ID_ADMIN=" + (int) userList.get(0).get(User.ID));
        if (userAdmin.isEmpty()) {//Si le liste userAdmin est vide alors l'utilisateur n'est pas administrateur
            isAdmin = false;
        } else {
            isAdmin = true;
        }
        return new User((int) userList.get(0).get(User.ID),
                (String) userList.get(0).get(User.PSEUDO),
                (String) userList.get(0).get(User.MDP),
                (String) userList.get(0).get(User.MAIL),
                isAdmin);
    }

    /**
     * Return a User find by the pseudo and determinate if the user is a admin
     * or not
     *
     * @param pseudo the pseudo of the User
     * @return the User find
     */
    static public User getUserByPseudo(String pseudo) {
        boolean isAdmin;
        ArrayList<HashMap<String, Object>> userList = DBController.Get().executeSelect("*", User.TABLE_NAME, "where PSEUDO_USER LIKE '" + pseudo.replace("'", "''") + "'");
        ArrayList<HashMap<String, Object>> userAdmin = DBController.Get().executeSelect(User.ID_ADMIN, User.TABLE_ADMIN, "where ID_ADMIN=" + (int) userList.get(0).get(User.ID));
        if (userAdmin.isEmpty()) {//Si le liste userAdmin est vide alors l'utilisateur n'est pas administrateur
            isAdmin = false;
        } else {
            isAdmin = true;
        }
        return new User((int) userList.get(0).get(User.ID),
                (String) userList.get(0).get(User.PSEUDO),
                (String) userList.get(0).get(User.MDP),
                (String) userList.get(0).get(User.MAIL),
                isAdmin);
    }

    /**
     * Control the couple Login/password
     *
     * @param pseudo the pseudo of the user
     * @param password the password of the user
     * @return a boolean , True if the couple is correct, False if is not
     */
    static public boolean controlLogin(String pseudo, String password) {
        boolean isCorrect;
        ArrayList<HashMap<String, Object>> userList = DBController.Get().executeSelect(User.ID+","+User.PSEUDO+","+User.MDP, User.TABLE_NAME, "where PSEUDO_USER LIKE '" + pseudo.replace("'", "''") + "'");
        if (!userList.isEmpty() && password.equals((String) userList.get(0).get(User.MDP))) {
            Main.idPseudo = (int) userList.get(0).get(User.ID);
            isCorrect = true;
        } else {
            isCorrect = false;
        }
        return isCorrect;
    }
    
    static public boolean controlAdmin(String pseudo){
        boolean isAdmin;
        ArrayList<HashMap<String, Object>> userList = DBController.Get().executeSelect(User.ID, User.TABLE_NAME, "where PSEUDO_USER LIKE '" + pseudo.replace("'", "''") + "'");
        ArrayList<HashMap<String, Object>> userAdmin = DBController.Get().executeSelect("*", User.TABLE_ADMIN, "where ID_ADMIN=" + (int) userList.get(0).get(User.ID));
        if (userAdmin.isEmpty()) {//Si le liste userAdmin est vide alors l'utilisateur n'est pas administrateur
            isAdmin = false;
        } else {
            isAdmin = true;
        }
        return isAdmin;
    }

    /**
     * Save the user in the database if the pseudo isn't taken
     *
     * @return true if everything was okay , false if the pseudo was already use
     */
    public boolean saveUser() {
        boolean isOkay;
        ArrayList<HashMap<String, Object>> userList = DBController.Get().executeSelect(User.PSEUDO, User.TABLE_NAME, "where PSEUDO_USER LIKE '" + this.getPseudoUser() + "'");
        if (userList.isEmpty()) {
            this.setIdUser(DBController.Get().executeInsert(User.TABLE_NAME, ""+User.PSEUDO + ',' + User.MDP + ',' + User.MAIL, "'" + this.getPseudoUser().replace("'", "''") + "','" + this.getPasswordUser() + "','" + this.getMailUser() + "'"));
            isOkay = true;
        } else {
            isOkay = false;
        }
        return isOkay;
    }

    
    public static void deconnexionUser(){
        Main.userPseudo = "User";
        Main.idPseudo=0;
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

    /**
     * Return if the user is a admin or not
     *
     * @return boolean --> true for admin
     */
    public Boolean isAdmin() {
        return m_isAdmin;
    }
}
