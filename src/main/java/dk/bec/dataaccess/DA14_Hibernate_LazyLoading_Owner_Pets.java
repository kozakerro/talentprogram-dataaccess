package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Owner;
import dk.bec.dataaccess.entity.Pet;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class DA14_Hibernate_LazyLoading_Owner_Pets {

    public static void tryToFetchDataWhenSessionIsClosed() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();
        try {
            createOwnerWithPets(session);

            session = factory.getCurrentSession();
            session.beginTransaction();
            Owner owner = session.get(Owner.class, 1);
            printOwner(owner);

            //List<Pet> pets = owner.getPets();  // fetched here!
            //printPets(pets);

            session.close(); // session is closed now

            List<Pet> pets = owner.getPets();
            printPets(pets); // LazyInitializationException thrown

        } catch (HibernateException he) {
            he.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

    public static void useJoinFetchQuery() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();
        try {
            createOwnerWithPets(session);

            session = factory.getCurrentSession();
            session.beginTransaction();
            Owner owner = (Owner)session
                    .createQuery("select o from Owner o JOIN FETCH o.pets where o.id=:ownerId")
                    .setParameter("ownerId", 1)
                    .getSingleResult();
            session.getTransaction().commit();
            session.close();
            // session is closed now
            List<Pet> pets = owner.getPets(); // no LazyInitializationException
            printPets(pets);

        } catch (HibernateException he) {
            he.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

    private static void createOwnerWithPets(Session session) {
        session.beginTransaction();
        Owner owner = new Owner("Adam", "Smith", "Warsaw", "500123546");
        session.save(owner);

        Pet pet1 = new Pet("Dog Forest");
        pet1.setBirthDate(LocalDate.of(2015, 5, 14));
        Pet pet2 = new Pet("Cat Jimmy");
        pet2.setBirthDate(LocalDate.of(2018, 7, 8));

        owner.addPet(pet1);
        owner.addPet(pet2);

        session.save(pet1);
        session.save(pet2);

        session.getTransaction().commit();
    }

    private static void printOwner(Owner owner) {
        System.out.println("Owner: ");
        System.out.println(owner.getId() + ": " + owner.getFirstName() + " " + owner.getLastName());
        System.out.println(owner.getAddress() + ", " + owner.getCity());
        System.out.println(owner.getTelephone());
    }

    private static void printPets(List<Pet> pets) {
        System.out.println("Pets: ");
        for(Pet p : pets) {
            System.out.println(p.getName());
        }
    }

}
