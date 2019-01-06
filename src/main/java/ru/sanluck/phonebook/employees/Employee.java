package ru.sanluck.phonebook.employees;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.sanluck.phonebook.department.Department;

import javax.persistence.*;
import java.util.Date;

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
}
