package dk.bec.dataaccess.service;

import dk.bec.dataaccess.dao.OwnerDAO;
import dk.bec.dataaccess.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DaoOwnerService {

    @Autowired
    OwnerDAO ownerDAO;

    @Transactional
    public List<Owner> getOwners() {
        System.out.println("Returning all owners");
        List<Owner> owners = ownerDAO.getOwners();
        return owners;
    }

    @Transactional
    public Optional<Owner> getOwner(int id) {
        System.out.println("Returning owner with id: " + id);
        Optional<Owner> owner = ownerDAO.getOwnerById(id);
        return owner;
    }

    @Transactional
    public List<Owner> getOwnersByLastName(String lastName) {
        System.out.println("Returning owner with last name like: " + lastName);
        List<Owner> owners = ownerDAO.getOwnersByLastName(lastName);
        return owners;
    }

    // additional methods
    @Transactional
    public void createOwners() {
        ownerDAO.createOwners();
    }

    @Transactional
    public void lifecycle() {
        ownerDAO.lifecycle();
    }

}
