package dk.bec.dataaccess.dao;

import dk.bec.dataaccess.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }
}
