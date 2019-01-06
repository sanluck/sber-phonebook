package ru.sanluck.phonebook.department;

import ru.sanluck.phonebook.department.Department;

/**
 * Utility for Department
 */
public class Departments {
    private Departments() {
        // never used
    }

    public static Department createDepartment(
        String shortName,
        String fullName,
        Department parent
    ) {
        Department department = new Department();
        department.setShortName(shortName);
        department.setFullName(fullName);
        department.setParent(parent);
        return department;
    }
}
