package ru.sanluck.phonebook.employees;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DTO for Employee, for UI
 */
@Getter
@Setter
public class EmployeeDto {
    private Integer id;
    private String fio;
    private String gender;
    private String birthdate;
    private String phone;
    private String mobilePhone;
}
