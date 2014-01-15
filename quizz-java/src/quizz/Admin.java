/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

public class Admin {

    private static DBController m_controller;
    private int m_idUser;
    private int m_idAdmin;

    public Admin(int idUser) {
        this.m_idUser = idUser;
    }

    public void saveAdmin() {
        this.m_idAdmin = this.m_controller.Get().executeInsert("admin",
                "id_user",
                "" + this.m_idUser + "");
    }
}
