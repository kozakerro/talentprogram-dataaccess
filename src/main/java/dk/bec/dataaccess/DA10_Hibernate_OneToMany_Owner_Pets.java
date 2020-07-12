package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Owner;
import dk.bec.dataaccess.entity.Pet;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class DA10_Hibernate_OneToMany_Owner_Pets {

    public static void createPetsForOwner() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
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
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
