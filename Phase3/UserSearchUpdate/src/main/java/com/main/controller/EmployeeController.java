package com.main.controller;

import com.main.model.Employee;
import com.main.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/UserSearchUpdate")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index() {
        return "index"; // JSP page for the landing page
    }

    @GetMapping("/viewUser")
    public String viewUser() {
        return "view-user"; // JSP page to take user ID input
    }

    @RequestMapping("/editEmployee")
    public String editEmployee(@RequestParam("userId") int userId, Model model) {
        Employee employee = employeeService.getEmployeeById(userId);
        if (employee == null) {
            // User ID not found, show error JSP page
            return "error-page";
        }
        model.addAttribute("employee", employee);
        return "edit-form"; // JSP page for the edit form
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(employee);
        return "confirmation-page"; // JSP page for confirmation
    }
    

}
