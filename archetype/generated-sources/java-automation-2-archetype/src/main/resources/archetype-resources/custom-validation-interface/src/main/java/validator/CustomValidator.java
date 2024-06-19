#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.validator;

import java.util.List;

public interface CustomValidator {

    List<String> validate(Object object);
}
