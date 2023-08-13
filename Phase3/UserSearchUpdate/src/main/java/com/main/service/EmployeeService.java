package com.main.service;

import com.main.model.Employee;

public interface EmployeeService {
    Employee getEmployeeById(int userId);
    void updateEmployee(Employee employee);
}
