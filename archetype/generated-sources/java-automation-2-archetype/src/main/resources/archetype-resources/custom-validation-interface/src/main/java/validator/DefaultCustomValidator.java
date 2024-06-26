#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.validator;

import com.google.common.collect.Lists;
import java.util.List;

public class DefaultCustomValidator implements CustomValidator{
    @Override
    public List<String> validate(Object object) {
        List<String> errors = Lists.newArrayList();
        if (object != null) {
            errors.add("object is null!");
        }

        return errors;
    }
}
