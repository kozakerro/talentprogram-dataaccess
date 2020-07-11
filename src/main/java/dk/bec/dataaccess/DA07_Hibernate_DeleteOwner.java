package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Owner;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA07_Hibernate_DeleteOwner {

    public static void deleteOwnerById() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Owner owner = session.get(Owner.class, 1);
            session.delete(owner);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

    public static void deleteOwnerWithQuery() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session
                .createQuery("delete from Owner o where o.id=1")
                .executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
