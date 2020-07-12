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
		//DA08_Hibernate_OneToOne_Vet_Account.createAccountForVet();
		//DA08_Hibernate_OneToOne_Vet_Account.casadeRemovalOfAccount();
		//DA09_Hibernate_OneToOneBidirectional_Vet_Account.createAccountForEmployee();
		//DA10_Hibernate_OneToMany_Owner_Pets.createPetsForOwner();
		//DA11_Hibernate_OneToMany_Uni_Vet_Opinions.createOpinionsForVet();
		//DA12_Hibernate_ManyToMany_Vets_Specialties.createSpecialtiesForVets();
		//DA13_Hibernate_ManyToMany_Bi_Vets_Specialties.createSpecialtiesForVets();
		//DA14_Hibernate_LazyLoading_Owner_Pets.tryToFetchDataWhenSessionIsClosed();
		//DA14_Hibernate_LazyLoading_Owner_Pets.useJoinFetchQuery();
	}

}
