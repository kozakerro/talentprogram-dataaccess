package dk.bec.dataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataaccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataaccessApplication.class, args);

		// JDBC
		DA01_JDBC_DatabaseConnection.connectToDatabase();
		//DA02_JDBC_SelectStatement.readAllOwners();
		//DA03_JDBC_ExecuteStatements.insertOwner();
		//DA03_JDBC_ExecuteStatements.updateOwners();
		//DA03_JDBC_ExecuteStatements.deleteOwner();
	}

}
