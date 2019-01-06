package ru.sanluck.phonebook.employees;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с сотрудниками
 */
@Controller
public class EmployeeController {

    private static final String EMPLOYEES = "employees";

    private final EmployeeService employeeService;
    private final Mapper mapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, Mapper mapper) {
        this.employeeService = employeeService;
        this.mapper = mapper;
    }

    @RequestMapping("/employees")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        EmployeeDto employeeDto = mapper.map(employees.get(0), EmployeeDto.class);
        List<EmployeeDto> employeeDtos = employees.stream().map(employee -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
        model.addAttribute("employees", employeeDtos);
        return EMPLOYEES;
    }
}
