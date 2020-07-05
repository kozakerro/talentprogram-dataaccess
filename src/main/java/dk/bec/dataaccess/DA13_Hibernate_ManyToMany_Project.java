package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Assessment;
import dk.bec.dataaccess.entity.Employee;
import dk.bec.dataaccess.entity.Project;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA13_Hibernate_ManyToMany_Project {

    public static void createProjectsForEmployee() {

        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // First employee
            Employee employee1 = session.get(Employee.class, 1);

            Project project1 = new Project("Compliance", 2_500_000);
            Project project2 = new Project("Maintenance", 1_250_000);

            employee1.addProject(project1);
            employee1.addProject(project2);

            session.save(project1);
            session.save(project2);

            System.out.println("Projects for Employee 1:");
            for(Project p : employee1.getProjects()) {
                System.out.println(p.getId() + ": " + p.getName() + ", " + p.getBudget());
            }

            // Second employee
            Employee employee2 = session.get(Employee.class, 2);
            employee2.addProject(project1);

            // List employees for Project 1;
            System.out.println("Employees in Project 1:");
            for(Employee e : project1.getEmployees()) {
                System.out.println(e.getId() + ": " + e.getFirstName() + " " + e.getLastName());
            }

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}
