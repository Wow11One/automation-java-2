#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.validator;

import java.util.List;
import com.google.common.collect.Lists;
import ${package}.entity.Student;
import ${package}.string.utils.StringValidationUtils;

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
        if (!StringValidationUtils.isBlank(student.getName())) {
            errors.add("student's name is blank!");
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
