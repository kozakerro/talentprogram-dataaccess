package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Computer;
import dk.bec.dataaccess.entity.Employee;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DA11_Hibernate_LazyLoading_Computer {

    public static void tryToFetchLazyLoadedDataAfterSessionIsClosed() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            session.getTransaction().commit();
            session.close();

            //employee.getComputers();  // fetched here!

            // session is closed now
            List<Computer> computers = employee.getComputers();
            for(Computer c : computers) {
                System.out.println(c.getManufacturer() + ", " + c.getModel());
            }
        } catch (HibernateException he) {
            he.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

    public static void useJoinFetchToInitializeComputers() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Employee employee = (Employee) session
                    .createQuery("select e from Employee e JOIN FETCH e.computers where e.id=:employeeId")
                    .setParameter("employeeId", 1)
                    .getSingleResult();
            session.getTransaction().commit();

            session.close();

            // session is closed now
            List<Computer> computers = employee.getComputers();
            for(Computer c : computers) {
                System.out.println(c.getId() + ": " + c.getManufacturer() + ", " + c.getModel());
            }
        } catch (HibernateException he) {
            he.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
