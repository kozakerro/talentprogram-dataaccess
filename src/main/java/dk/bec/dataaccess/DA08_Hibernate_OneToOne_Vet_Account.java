package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Account;
import dk.bec.dataaccess.entity.Vet;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA08_Hibernate_OneToOne_Vet_Account {

    public static void createAccountForVet() {
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

    public static void casadeRemovalOfAccount() {
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
