package dk.bec.dataaccess;

import java.sql.*;

public class DA02_JDBC_SelectStatement {

    private static final String DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    private static final String URL = "jdbc:hsqldb:C:/projects/petclinic-talentprogram/petclinicdb";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";


    public static void readAllOwners() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM OWNERS");
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
