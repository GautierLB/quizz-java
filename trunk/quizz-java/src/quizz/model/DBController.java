package quizz.model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBController {

    private Connection m_connection;
    private Statement m_request;
    static private DBController s_dbController;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://193.252.48.189\\SQLEXPRESS:1433;database=BDD_B3I_groupe_3;";

    //  Database credentials
    static final String USER = "b3i_groupe_3";
    static final String PASS = "123Soleil";

    static public DBController Get() {
        if (s_dbController == null) {
            s_dbController = new DBController();
        }
        return s_dbController;
    }

    private DBController() {
        m_request = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to a selected database...");
            this.m_connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    /**
     * Execute select request function
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
            String SQL = "SELECT " + select + " FROM BDD_B3I_groupe_3.dbo.[" + table + "] " + where + ";";
            System.out.println("SQL statement: " + SQL);
            m_request = this.m_connection.createStatement();
            selectReturn = m_request.executeQuery(SQL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            selectReturn = null;
        }
        return selectReturn;
    }

    /**
     * Execute insert request function
     *
     * @param table the table where we execute the INSERT
     * @param fields the fields where we insert our values
     * @param values the values we INSERT (Format : "'Value','value2'...")
     * @return the key generated
     */
    public int executeInsert(String table, String fields, String values) {
        int key = 0;
        try {
            String SQL = "INSERT INTO BDD_B3I_groupe_3.dbo.[" + table + "] (" + fields + ") VALUES (" + values + ")";
            Statement request = this.m_connection.createStatement();
            request.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet test = request.getGeneratedKeys();
            if (test.next()) {
                key = test.getInt(1);
            }
            request.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return key;
    }
    
    /**
     * Close the request after a select
     */
    public void closeRequest() {
        if (m_request != null) {
            try {
                m_request.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
