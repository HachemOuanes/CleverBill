package Database;

import java.sql.*;

public class Connector {

    private static Connection start = null;
    private static Statement statement = null;
    private ResultSet result = null;

    private static void connect() {
        try {
            start = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/billingsystem", "root", "root");
        } catch (SQLException ex) {
            System.err.println("Failed to connect to database");
            ex.printStackTrace();
        }
    }

    public ResultSet read(String query) throws SQLException {

        try {
            connect();
            statement = start.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return result;
    }

    public ResultSet create(String query) throws SQLException {
        try {
            connect();
            statement = start.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            result = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return result;
    }

}




