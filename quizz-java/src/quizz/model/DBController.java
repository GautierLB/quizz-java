/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.model;

import java.sql.*;

public class DBController {

    private Connection m_connection;
    static private DBController s_dbController;

    static public DBController Get() {
        if (s_dbController == null) {
            s_dbController = new DBController();
        }
        return s_dbController;
    }

    private DBController() {
        try {
            // Load the SQLServerDriver class, build the
            // connection string, and get a connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://193.252.48.189\\SQLEXPRESS:1433;"
                    + "database=BDD_B3I_groupe_3;"
                    + "user=b3i_groupe_3;"
                    + "password=123Soleil";
            this.m_connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("erreur connection");
            System.exit(0);
        }
    }

    /**
     * Function how execute the specified sql query.
     * <p>
     * if the query failed return null
     *
     * @param select the data we want (for all use '*' )
     * @param table the table of the data
     * @param where the condition of a specific research
     * @return an ResultSet with the data
     */
    public ResultSet executeSelect(String select, String table, String where) {
        ResultSet selectReturn;
        try {
            // Create and execute an SQL statement that returns some data. 
            String SQL = "SELECT " + select + " FROM BDD_B3I_groupe_3.dbo.[" + table + "] " + where + ";";
            Statement request = this.m_connection.createStatement();
            selectReturn = request.executeQuery(SQL);
            request.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            selectReturn = null;
        }
        return selectReturn;
    }

    /**
     * Function how execute the insert in the table we want
     *
     * @param table the table where we execute the INSERT
     * @param fields the fields where we insert our values
     * @param values the values we INSERT (Format : "'Value','value2'...")
     * @return the key generated
     */
    public int executeInsert(String table, String fields, String values) {
        int Key = 0;
        try {
            table.toUpperCase();
            fields.toUpperCase();
            String SQL = "INSERT INTO BDD_B3I_groupe_3.dbo.[" + table + "] (" + fields + ") VALUES (" + values + ")";
            Statement request = this.m_connection.createStatement();
            request.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet test = request.getGeneratedKeys();
            if (test.next()) {
                Key = test.getInt(1);
            }
            request.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Key;
    }
}
