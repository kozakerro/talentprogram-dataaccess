package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Owner;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DA05_Hibernate_QueryOwners {

    public static void readOwner() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Owner owner = session.get(Owner.class, 1);
            printOwner(owner);
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

    public static void queryOwners() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Owner> owners = session
                .createQuery("from Owner o where o.firstName='Adam' or o.lastName='Wayne'")
                .getResultList();
            for(Owner o : owners) {
                printOwner(o);
            }
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

    private static void printOwner(Owner owner) {
        System.out.println(owner.getId() + ": " + owner.getFirstName() + " " + owner.getLastName());
        System.out.println(owner.getAddress() + ", " + owner.getCity());
        System.out.println(owner.getTelephone());
    }

}
