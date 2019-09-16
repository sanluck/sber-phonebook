package ru.sanluck.phonebook.employees;

import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с сотрудниками
 */
@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private static final String EMPLOYEES = "employees";

    private final EmployeeService employeeService;
    private final Mapper mapper;

    @RequestMapping(path = "/"+EMPLOYEES, method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> mapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        model.addAttribute(EMPLOYEES, employeeDtos);
        return EMPLOYEES;
    }

    @RequestMapping(path = "/employee/save", method = RequestMethod.POST)
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDto employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        Employee empl = mapper.map(employee, Employee.class);
        employeeService.save(empl);
        return EMPLOYEES;
    }

    @RequestMapping(path = "/employee", method = RequestMethod.GET)
    public ModelAndView createEmployee() {
        String employee = "employee";
        return new ModelAndView(employee, employee, new EmployeeDto());
    }

}
