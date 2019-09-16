package ru.sanluck.phonebook.employees;

import org.springframework.data.repository.CrudRepository;
import ru.sanluck.phonebook.department.Department;

import java.util.List;

/**
 * Repository for Employee
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
        List<Employee> findByDepartment(Department department);
        Employee findById(Integer id);
}
