package ru.sanluck.phonebook.department;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * Подразделение
 */
@Entity
@Data
public class Department extends AbstractPersistable<Integer> {
    private String shortName;
    private String fullName;
    @ManyToOne
    private Department parent;
}
