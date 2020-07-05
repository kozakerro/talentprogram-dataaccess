package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Account;
import dk.bec.dataaccess.entity.Computer;
import dk.bec.dataaccess.entity.Employee;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DA10_Hibernate_OneToMany_Computer {

    public static void createComputersForEmployee() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            Computer computer1 = new Computer("Lenovo", "ThinkPad");
            Computer computer2 = new Computer("Apple", "MacBookPro");

            employee.addComputer(computer1);
            employee.addComputer(computer2);

            session.save(computer1);
            session.save(computer2);

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
