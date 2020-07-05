package dk.bec.dataaccess.dao;

import dk.bec.dataaccess.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getEmployees();
}
