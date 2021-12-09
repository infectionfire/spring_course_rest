package com.ivanovsergei.spring.rest.service;

import com.ivanovsergei.spring.rest.dao.EmployeeDAO;
import com.ivanovsergei.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service//отмечает класс, содержащий бизнес логику
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional//делегируем спрингу управление транзакциями
    public List<Employee> getAllEmployees() {

        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional//делегируем спрингу управление транзакциями
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional//делегируем спрингу управление транзакциями
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
