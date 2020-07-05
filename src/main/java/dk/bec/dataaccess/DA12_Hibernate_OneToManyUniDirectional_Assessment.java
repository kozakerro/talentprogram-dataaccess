package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Assessment;
import dk.bec.dataaccess.entity.Computer;
import dk.bec.dataaccess.entity.Employee;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA12_Hibernate_OneToManyUniDirectional_Assessment {

    public static void createAssessmentsForEmployee() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            Assessment assessment1 = new Assessment(5, "Good job!");
            Assessment assessment2 = new Assessment(4, "Nice job!");

            employee.addAssessment(assessment1);
            employee.addAssessment(assessment2);

            session.save(assessment1);
            session.save(assessment2);

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

    public static void cascadeRemovalOfAssessmentWhenEmployeeIsRemoved() {

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
