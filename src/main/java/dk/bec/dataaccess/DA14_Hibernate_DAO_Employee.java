package dk.bec.dataaccess;

import dk.bec.dataaccess.dao.EmployeeDAO;
import dk.bec.dataaccess.entity.Employee;
import dk.bec.dataaccess.entity.Project;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DA14_Hibernate_DAO_Employee {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees(); // TODO: fix NPE
    }

    public static void retrieveEmployeesUsingDAO() {
        DA14_Hibernate_DAO_Employee example = new DA14_Hibernate_DAO_Employee();
        List<Employee> employees = example.getEmployees();

        for(Employee e : employees) {
            System.out.println(e.getId() + ": " + e.getFirstName() + " " + e.getLastName());
        }
    }

}
