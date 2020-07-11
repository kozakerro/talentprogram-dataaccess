package dk.bec.dataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataaccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataaccessApplication.class, args);
		//DA04_Hibernate_PersistOwner.persistOwner();
		//DA05_Hibernate_QueryOwners.readOwner();
		//DA06_Hibernate_UpdateOwners.updateOwner();
		//DA06_Hibernate_UpdateOwners.anonymizeNames();
		//DA07_Hibernate_DeleteOwner.deleteOwnerById();
		//DA07_Hibernate_DeleteOwner.deleteOwnerWithQuery();
	}

}
