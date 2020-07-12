package dk.bec.dataaccess.dao;

import dk.bec.dataaccess.entity.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerDAO {
    public List<Owner> getOwners();
    public Optional<Owner> getOwnerById(int id);
    public List<Owner> getOwnersByLastName(String lastName);

    // additional methods
    public void createOwners();
    public void lifecycle();
}
