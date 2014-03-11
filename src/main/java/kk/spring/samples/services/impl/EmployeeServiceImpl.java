package kk.spring.samples.services.impl;

import kk.spring.samples.beans.Employee;
import kk.spring.samples.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karan.khosla on 3/10/14.
 */

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

    private static List<Employee> employeeList = new ArrayList<Employee>();
    private static Long id = 0L;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employeeProfile) {
        employeeProfile.setId(++id);
        employeeList.add(employeeProfile);
    }

    @Override
    public void deleteEmployeeById(Long employee_id) {
        Employee employeeRecordFound = findEmployeeById(employee_id);
        if (employeeRecordFound != null) {
            employeeList.remove(employeeRecordFound);
        }
    }

    @Override
    public void deleteAllEmployees() {
        employeeList.clear();
        id = 0L;
    }

    @Override
    public void updateEmployeeDetails(Employee employeeProfile) {
        Employee employeeRecordFound = findEmployeeById(employeeProfile.getId());
        if (employeeRecordFound != null) {
            employeeList.remove(employeeRecordFound);
            employeeList.add(employeeProfile);
        }
    }

    private Employee findEmployeeById(Long id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id)
                return employee;
        }
        return null;
    }
}
