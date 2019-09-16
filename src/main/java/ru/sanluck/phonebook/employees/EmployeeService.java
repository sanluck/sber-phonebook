package ru.sanluck.phonebook.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Сервис для работы с сотрудниками
 */
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>((Collection<? extends Employee>) employeeRepository.findAll());
    }

    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
