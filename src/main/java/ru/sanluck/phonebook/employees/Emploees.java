package ru.sanluck.phonebook.employees;

import ru.sanluck.phonebook.department.Department;

import java.util.Date;

/**
 * Utility for Employee
 */
public class Emploees {
    private Emploees() {
        // never used
    }

    public static Employee createEmployee(
            String surname,
            String forename,
            String patronymic,
            Gender gender,
            Date birthdate,
            Department department,
            String post
    ) {
        Employee employee = new Employee();
        employee.setSurname(surname);
        employee.setForename(forename);
        employee.setPatronymic(patronymic);
        employee.setGender(gender);
        employee.setBirthdate(birthdate);
        employee.setDepartment(department);
        employee.setPost(post);
        return employee;
    }
}
