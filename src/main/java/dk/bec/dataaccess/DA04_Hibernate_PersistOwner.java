package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Owner;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA04_Hibernate_PersistOwner {
    public static void persistOwner() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            Owner owner = new Owner("Adam", "Smith", "Warsaw", "500123546");
            session.beginTransaction();
            session.save(owner);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }
}
