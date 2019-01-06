package ru.sanluck.phonebook.employees;

import com.github.dozermapper.core.DozerConverter;
import org.apache.commons.lang3.StringUtils;

/**
 * Custom mapping for Gender
 */
public class GenderCustomConverter extends DozerConverter<Gender, String> {

    private static final String MALE = "Мужской";
    private static final String FEMALE = "Женский";
    private static final String UNKNOWN = "Неизвестно";

    public GenderCustomConverter() {
        super(Gender.class, String.class);
    }

    public GenderCustomConverter(Class<Gender> prototypeA, Class<String> prototypeB) {
        super(prototypeA, prototypeB);
    }

    @Override
    public String convertTo(Gender source, String destination) {

        if (source == Gender.MALE) {
            return MALE;
        }

        if (source == Gender.FEMALE) {
            return FEMALE;
        }

        return UNKNOWN;
    }

    @Override
    public Gender convertFrom(String source, Gender destination) {
        if (StringUtils.equalsIgnoreCase(source, MALE)) {
            return Gender.MALE;
        }

        if (StringUtils.equalsIgnoreCase(source, FEMALE)) {
            return Gender.FEMALE;
        }

        return Gender.UNKNOWN;
    }
}
