package kk.spring.samples.controller;

import kk.spring.samples.domain.Employee;
import kk.spring.samples.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by karan.khosla on 3/10/14.
 */

@Controller
@RequestMapping("/api")
public class EmployeeRestController {


    @Autowired
    private EmployeeService empService;

    @RequestMapping("/employee/employeelist.json")
    public
    @ResponseBody
    List<Employee> getEmployeeList() {
        return empService.getAllEmployees();
    }

    @RequestMapping(value = "/employee/addEmployee", method = RequestMethod.POST)
    public
    @ResponseBody
    void addEmployeeProfile(@RequestBody Employee employeeProfile) {
        empService.addEmployee(employeeProfile);
    }

    @RequestMapping(value = "/employee/removeEmployee/{employeeId}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void removeEmployee(@PathVariable("employeeId") Long employeeId) {
        empService.deleteEmployeeById(employeeId);
    }

    @RequestMapping(value = "/employee/updateEmployeeDetails", method = RequestMethod.PUT)
    public
    @ResponseBody
    void updateRailwayStation(@RequestBody Employee employee) {
        empService.updateEmployeeDetails(employee);
    }

    @RequestMapping(value = "/employee/removeAllEmployees", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void removeAllEmployees() {
        empService.deleteAllEmployees();
    }
}


































