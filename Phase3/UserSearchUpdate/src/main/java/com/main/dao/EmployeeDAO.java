package com.main.dao;

import com.main.model.Employee;

public interface EmployeeDAO {
    Employee getEmployeeById(int userId);
    void updateEmployee(Employee employee);
}
