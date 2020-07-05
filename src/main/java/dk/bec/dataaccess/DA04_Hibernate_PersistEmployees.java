package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Account;
import dk.bec.dataaccess.entity.Employee;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DA04_Hibernate_PersistEmployees {

    public static void persistEmployees() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            Employee employee1 = new Employee("Adam", "Smith");
            Employee employee2 = new Employee("John", "Wayne");
            session.beginTransaction();
            session.save(employee1);
            session.save(employee2);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
