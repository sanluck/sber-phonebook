package ru.sanluck.phonebook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.sanluck.phonebook.department.Department;
import ru.sanluck.phonebook.department.DepartmentRepository;
import ru.sanluck.phonebook.employees.EmployeeRepository;

import java.util.Date;

import static ru.sanluck.phonebook.employees.Gender.MALE;
import static ru.sanluck.phonebook.department.Departments.createDepartment;
import static ru.sanluck.phonebook.employees.Emploees.createEmployee;

@SpringBootApplication
public class PhonebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhonebookApplication.class, args);
    }

    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return args -> {
            Department sberbank = departmentRepository.save(createDepartment("Сбербанк", "ПАО Сбербанк России", null));
            Department ca = departmentRepository.save(createDepartment("ЦА", "Центральный аппарат", sberbank));
            Department blockT = departmentRepository.save(createDepartment("Блок Т", "Блок Технологии", ca));

            employeeRepository.save(createEmployee("Лукьянов", "Александр", "Алексеевич", MALE, new Date(), blockT, "Main Engeneer", "20205", "+796350xxxxx"));
            employeeRepository.save(createEmployee("Верёвкин", "Максим", "Николаевич", MALE, new Date(), sberbank, "Chief Engeneer", "2020x","+796350xxxxx"));
            employeeRepository.save(createEmployee("Голубев", "Александр", "Васильевич", MALE, new Date(), blockT, "Lead Engeneer", "2020x", "+796350xxxxx"));
        };
    }
}
