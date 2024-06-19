package com.ukma.validator;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.ukma.entity.Student;
import com.ukma.string.utils.StringValidationUtils;

public class StudentCustomValidator implements CustomValidator {

    @Override
    public List<String> validate(Object object) {
        List<String> errors = Lists.newArrayList();
        if (object == null) {
            errors.add("student is null!");
            return errors;
        }
        Student student = (Student) object;


        if (!StringValidationUtils.isEmail(student.getEmail())) {
            errors.add("email format is not correct!");
        }
        if (StringValidationUtils.isBlank(student.getName())) {
            errors.add("student's name is blank!");
        } else {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                int nameMaxSize = objectMapper.readTree(new File("src/main/resources/validation-config.json"))
                        .get("nameMaxSize")
                        .asInt();
                if (student.getName().length() > nameMaxSize) {
                    errors.add("name length is bigger than max value(" + nameMaxSize + ")!");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (!StringValidationUtils.isUkrainianPhone(student.getPhone())) {
            errors.add("phone format is not correct!");
        }
        if (!StringValidationUtils.isAllUpperCase(student.getFaculty())) {
            errors.add("faculty name's characters should all be upper case!");
        }

        return errors;
    }
}
