package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Owner;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA06_Hibernate_UpdateOwners {

    public static void updateOwner() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Owner owner = session.get(Owner.class, 1);
            owner.setLastName("Foster");
            printOwner(owner);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

    public static void anonymizeNames() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session
                .createQuery("update Owner o set o.lastName='(Anonymous)'")
                .executeUpdate();
            Owner owner = session.get(Owner.class, 1);
            printOwner(owner);
            session.getTransaction().commit();
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
