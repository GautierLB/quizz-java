package quizz.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DBController {

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
    }

    private Connection connectDB() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to a selected database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<HashMap<String, Object>> executeSelect(String select, String table, String where) {
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        String query = "SELECT " + select + " FROM " + table + " " + where + ";";

        Connection connection = this.connectDB();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                HashMap<String, Object> row = new HashMap<>();
                ResultSetMetaData rsmd = resultSet.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String colName = rsmd.getColumnName(i);
                    String colLabel = rsmd.getColumnLabel(i);
                    Object value = resultSet.getObject(colLabel);
                    row.put(colName, value);
                }
                result.add(row);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
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
            Statement request = this.connectDB().createStatement();
            request.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = request.getGeneratedKeys();
            if (resultSet.next()) {
                key = resultSet.getInt(1);
            }
            request.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return key;
    }
}
