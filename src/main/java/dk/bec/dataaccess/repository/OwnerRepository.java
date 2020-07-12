package dk.bec.dataaccess.repository;

import dk.bec.dataaccess.entity.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    public List<Owner> findByFirstNameAndLastName(String firstName, String lastName);
    public List<Owner> findByLastNameNotLike(String lastName);
    @Query("SELECT o FROM Owner o WHERE LENGTH(o.lastName) > :length")
    public List<Owner> findNamesLongerThan(@Param("length") Integer minNameLength);
}
