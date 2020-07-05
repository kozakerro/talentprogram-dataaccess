package dk.bec.dataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataaccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataaccessApplication.class, args);

		// JDBC
		DA01_JDBC_DatabaseConnection.connectToDatabase();
		//DA02_SelectStatement.realAllEmployees();
		//DA03_ExecuteStatements.insertEmployee();
		//DA03_ExecuteStatements.updateEmployee();
		//DA03_JDBC_ExecuteStatements.deleteEmployee();

		// Hibernate
		//DA04_Hibernate_PersistEmployees.persistEmployees();

		//DA05_Hibernate_QueryEmployees.readEmployee();
		//DA05_Hibernate_QueryEmployees.queryEmployees();

		//DA06_Hibernate_UpdateEmployees.updateEmployee();
		//DA06_Hibernate_UpdateEmployees.anonymizeNames();
		//DA07_Hibernate_DeleteEmployee.deleteEmployeeById();
		//DA07_Hibernate_DeleteEmployee.deleteEmployeeByQuery();

		//DA08_Hibernate_OneToOneAccount.createAccountForEmployee();
		//DA08_Hibernate_OneToOneAccount.casadeRemovalOfAccount();
        //DA09_Hibernate_OneToOneBidirectional_Account.createAccountForEmployee();
        //DA09_Hibernate_OneToOneBidirectional_Account.casadeRemovalOfEmployee();

		//DA10_Hibernate_OneToMany_Computer.createComputersForEmployee();
		//DA11_Hibernate_LazyLoading_Computer.tryToFetchLazyLoadedDataAfterSessionIsClosed();
		//DA11_Hibernate_LazyLoading_Computer.useJoinFetchToInitializeComputers();
		//DA12_Hibernate_OneToManyUniDirectional_Assessment.createAssessmentsForEmployee();
		//DA12_Hibernate_OneToManyUniDirectional_Assessment.cascadeRemovalOfAssessmentWhenEmployeeIsRemoved();

		//DA13_Hibernate_ManyToMany_Project.createProjectsForEmployee();

		//DA14_Hibernate_DAO_Employee.retrieveEmployeesUsingDAO();



	}

}
