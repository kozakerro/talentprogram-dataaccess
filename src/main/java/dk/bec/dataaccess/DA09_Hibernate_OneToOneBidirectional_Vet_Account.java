package dk.bec.dataaccess;

import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA09_Hibernate_OneToOneBidirectional_Vet_Account {

    public static void createAccountForEmployee() {
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
