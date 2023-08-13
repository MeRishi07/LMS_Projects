package com.main.daoImpl;

import com.main.dao.EmployeeDAO;
import com.main.model.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Employee getEmployeeById(int userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, userId);
        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public void updateEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }
    }
}
