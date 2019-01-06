package ru.sanluck.phonebook.employees;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.sanluck.phonebook.department.Department;

import javax.persistence.*;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Сотрудник банка
 */
@Entity
@Data
public class Employee extends AbstractPersistable<Integer> {
    private String forename;
    private String surname;
    private String patronymic;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 10)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @ManyToOne
    private Department department;
    private String post;
    @Column(length = 20)
    private String phone;
    @Column(length = 20)
    private String mobilePhone;

    public String getFio() {
       return Stream.of(surname, forename, patronymic)
               .filter(StringUtils::isNotEmpty)
               .collect(Collectors.joining(" "));
    }
}
