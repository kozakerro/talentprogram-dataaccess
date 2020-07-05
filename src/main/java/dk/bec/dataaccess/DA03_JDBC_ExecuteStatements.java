package dk.bec.dataaccess;

import java.sql.*;

public class DA03_JDBC_ExecuteStatements {

    private static final String DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    private static final String URL = "jdbc:hsqldb:C:/projects/petclinic-talentprogram/petclinic";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";


    public static void insertEmployee() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO EMPLOYEE(FIRST_NAME, LAST_NAME) VALUES ('Jonh', 'Pillow')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE E");
            while (resultSet.next()) {
                int id = resultSet.getInt("EMPID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                System.out.println(id + ": " + firstName + " " + lastName);
            }

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

    public static void updateEmployee() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE EMPLOYEE SET FIRST_NAME = 'Alan' WHERE EMPID=2");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE E");
            while (resultSet.next()) {
                int id = resultSet.getInt("EMPID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                System.out.println(id + ": " + firstName + " " + lastName);
            }

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

    public static void deleteEmployee() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM EMPLOYEE WHERE EMPID=1");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE E");
            while (resultSet.next()) {
                int id = resultSet.getInt("EMPID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                System.out.println(id + ": " + firstName + " " + lastName);
            }

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
