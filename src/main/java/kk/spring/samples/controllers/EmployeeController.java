package kk.spring.samples.controllers;

import kk.spring.samples.beans.Employee;
import kk.spring.samples.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by karan.khosla on 3/10/14.
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService empService;

    @RequestMapping("/employeelist.json")
    public
    @ResponseBody
    List<Employee> getEmployeeList() {
        return empService.getAllEmployees();
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public
    @ResponseBody
    void addEmployeeProfile(@RequestBody Employee employeeProfile) {
        empService.addEmployee(employeeProfile);
    }

    @RequestMapping(value = "/removeEmployee/{employeeId}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void removeEmployee(@PathVariable("employeeId") Long employeeId) {
        empService.deleteEmployeeById(employeeId);
    }

    @RequestMapping(value = "/updateEmployeeDetails", method = RequestMethod.PUT)
    public
    @ResponseBody
    void updateRailwayStation(@RequestBody Employee employee) {
        empService.updateEmployeeDetails(employee);
    }

    @RequestMapping(value = "/removeAllEmployees", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void removeAllEmployees() {
        empService.deleteAllEmployees();
    }

    @RequestMapping("/page")
    public String getPartialPage() {
        return "employee/page";
    }

}


































