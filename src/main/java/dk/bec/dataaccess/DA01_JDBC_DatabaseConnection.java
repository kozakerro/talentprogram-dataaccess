package dk.bec.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DA01_JDBC_DatabaseConnection {

    private static final String DRIVER = "org.hsqldb.jdbcDriver";
    private static final String URL = "jdbc:hsqldb:C:/projects/petclinic-talentprogram/petclinic";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";


    public static void connectToDatabase() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database!");
            // more instructions go here
            connection.close();
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exceptions here
        } finally {
            try { if(connection!=null){connection.close();}}
            catch(SQLException e) {}
        }

    }

}
