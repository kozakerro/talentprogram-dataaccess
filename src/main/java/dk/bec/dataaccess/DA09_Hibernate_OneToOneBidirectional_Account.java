package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Account;
import dk.bec.dataaccess.entity.Employee;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DA09_Hibernate_OneToOneBidirectional_Account {

    public static void createAccountForEmployee() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            Account account = new Account("AmericaBank", "91 1235 2123 0000 0001 1234 5556");
            account.setEmployee(employee);
            employee.setAccount(account);

            Employee relatedEmployee = account.getEmployee();
            System.out.println(relatedEmployee.getId() + ": " + relatedEmployee.getFirstName() + ", " + relatedEmployee.getLastName());

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

    public static void casadeRemovalOfEmployee() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Account account = session.get(Account.class, 3);
            Employee employee = account.getEmployee();
            employee.setAccount(null);
            session.delete(account);

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
