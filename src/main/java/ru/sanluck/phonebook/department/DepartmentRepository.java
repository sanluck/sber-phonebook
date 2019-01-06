package ru.sanluck.phonebook.department;

import org.springframework.data.repository.CrudRepository;
import ru.sanluck.phonebook.department.Department;

/**
 * Repository for Department
 */
public interface DepartmentRepository extends CrudRepository<Department, Integer> {}
