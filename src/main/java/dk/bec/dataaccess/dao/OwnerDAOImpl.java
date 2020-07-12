package dk.bec.dataaccess.dao;

import dk.bec.dataaccess.entity.Owner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class OwnerDAOImpl implements OwnerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Owner> getOwners() {
        List<Owner> owners = entityManager
                .createQuery("from Owner o", Owner.class)
                .getResultList();
        return owners;
    }

    @Override
    @Transactional
    public Optional<Owner> getOwnerById(int id) {
        Optional<Owner> owner = Optional.ofNullable(entityManager.find(Owner.class, id));
        return owner;
    }

    @Override
    @Transactional
    public List<Owner> getOwnersByLastName(String lastName) {
        List<Owner> owners = entityManager
                .createQuery("from Owner o where o.lastName like :lastName", Owner.class)
                .setParameter("lastName", lastName)
                .getResultList();
        return owners;
    }

    @Override
    public void createOwners() {
        entityManager.persist(new Owner("Adam", "Johnes", "New York", "500123456"));
        entityManager.persist(new Owner("Nathalie", "Black", "Paris", "501321654"));
        entityManager.persist(new Owner("John", "Steward", "London", "500222333"));
        entityManager.persist(new Owner("Elin", "Marks", "Copehnagen", "602123654"));
        entityManager.persist(new Owner("Bob", "Wayne", "Berlin", "502123987"));
    }

    @Override
    public void lifecycle() {
        // transient
        Owner owner = new Owner("John", "NotPersisted", "Warsaw", "123456");
        System.out.println(">>>>> new entity: " + entityManager.contains(owner));  // not in EM, not in DB

        // managed
        entityManager.persist(owner);

        System.out.println(">>>>> after persist: " + entityManager.contains(owner));  // is in EM, not in DB
        entityManager.getTransaction().commit();  // is in DB now too
        entityManager.flush();
        System.out.println(">>>>> after flush: " + entityManager.contains(owner));  // is in EM, not in DB

        // detached
        entityManager.detach(owner);
        System.out.println(">>>>> after detach: " + entityManager.contains(owner));  // not in EM, is in DB

        owner.setFirstName("Adam");
        System.out.println(">>>>> after field change: " + entityManager.contains(owner));  // in in EM, is in DB (updated)
        // managed again
        entityManager.getTransaction().begin();
        owner = entityManager.merge(owner);
        System.out.println(">>>>> after merge: " + entityManager.contains(owner));  // in in EM, is in DB (updated)

        entityManager.flush();
        entityManager.getTransaction().commit();

        entityManager.remove(owner);
        System.out.println(">>>>> after remove: " + entityManager.contains(owner));  // in in EM, is in DB (updated)
        entityManager.flush();

        //entityManager.close();
        System.out.println(">>>>> after remove commit: " + entityManager.contains(owner));  // not in EM, not in DB
    }
}
