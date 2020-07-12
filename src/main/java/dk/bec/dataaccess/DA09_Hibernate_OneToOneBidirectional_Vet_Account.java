package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Account;
import dk.bec.dataaccess.entity.Vet;
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
            Vet vet = new Vet("Johny", "Norman");
            Account account = new Account("j.norman", "1234567890");
            vet.setAccount(account);
            account.setVet(vet); //reverse relation set!
            session.save(vet);
            Vet vet1 = session.get(Vet.class, 1);
            Account account1 = vet1.getAccount();
            System.out.println(account1.getLogin() + " " + account1.getPasswordHash());
            Account account2 = session.get(Account.class, 2);
            Vet vet2 = account2.getVet();
            System.out.println(vet2.getFirstName() + " " + vet2.getLastName());
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
