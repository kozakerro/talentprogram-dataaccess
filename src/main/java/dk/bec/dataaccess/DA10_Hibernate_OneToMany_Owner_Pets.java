package dk.bec.dataaccess;

import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA10_Hibernate_OneToMany_Owner_Pets {

    public static void createPetsForOwner() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
