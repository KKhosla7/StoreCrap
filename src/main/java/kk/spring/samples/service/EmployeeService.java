package kk.spring.samples.service;

import kk.spring.samples.domain.Employee;

import java.util.List;

/**
 * Created by karan.khosla on 3/10/14.
 */
public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void addEmployee(Employee employeeProfile);

    public void deleteEmployeeById(Long employee_id);

    public void deleteAllEmployees();

    public void updateEmployeeDetails(Employee employeeProfile);

}
