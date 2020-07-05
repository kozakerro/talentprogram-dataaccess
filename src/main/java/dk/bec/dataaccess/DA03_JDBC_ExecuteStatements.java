package dk.bec.dataaccess;

import java.sql.*;

public class DA03_JDBC_ExecuteStatements {

    private static final String DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    private static final String URL = "jdbc:hsqldb:C:/projects/petclinic-talentprogram/petclinicdb";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";


    public static void insertOwner() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO OWNERS(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE) " +
                    "VALUES ('Jonh', 'Pillow', 'Aleje Jerozolimskie 40', 'Warsaw', '225412277')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM OWNERS E");
            printOwners(resultSet);

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

    public static void updateOwners() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE OWNERS SET FIRST_NAME = 'David' WHERE ID=4");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM OWNERS E");
            printOwners(resultSet);

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

    public static void deleteOwner() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM OWNERS WHERE ID=11");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM OWNERS E");
            printOwners(resultSet);

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

    private static void printOwners(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String firstName = resultSet.getString("FIRST_NAME");
            String lastName = resultSet.getString("LAST_NAME");
            String address = resultSet.getString("ADDRESS");
            String city = resultSet.getString("CITY");
            String telephone = resultSet.getString("TELEPHONE");
            System.out.println(id + ": " + firstName + " " + lastName + ", tel:" + telephone);
            System.out.println(address + ", " + city);
        }
    }

}
