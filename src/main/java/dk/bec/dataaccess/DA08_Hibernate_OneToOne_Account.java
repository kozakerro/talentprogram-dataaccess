package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Account;
import dk.bec.dataaccess.entity.Employee;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DA08_Hibernate_OneToOne_Account {

    public static void createAccountForEmployee() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            Account account = new Account("AmericaBank", "91 1235 2123 0000 0001 1234 5556");
            employee.setAccount(account);

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

            Employee employee = session.get(Employee.class, 1);
            session.delete(employee);

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
