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
            Vet vet = new Vet("Johny", "Norman");
            Account account = new Account("j.norman", "1234567890");
            vet.setAccount(account);
            //session.save(account); saved automatically!
            session.save(vet);
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
            Vet vet = session.get(Vet.class, 1);
            session.delete(vet);
            //session.delete(vet.getAccount()) deleted automatically!
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
