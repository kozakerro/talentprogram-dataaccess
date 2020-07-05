package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Account;
import dk.bec.dataaccess.entity.Employee;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DA05_Hibernate_QueryEmployees {

    public static void readEmployee() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);

            System.out.println(employee.getId() + ": " + employee.getFirstName() + " " + employee.getLastName());
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

    public static void queryEmployees() {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Employee> employees = session
                    .createQuery("from Employee e where e.firstName='Adam' or e.lastName='Wayne'")
                    .getResultList();

            for(Employee employee : employees) {
                System.out.println(employee.getId() + ": " + employee.getFirstName() + " " + employee.getLastName());
            }
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
