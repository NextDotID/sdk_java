package common;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ParamChecker {
    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    public static void checkParam(Object input){
        Set<ConstraintViolation<Object>> violations = validator.validate(input);
        for(ConstraintViolation<Object> violation : violations){
            throw new NextIdException("ILLEGAL_PARAM"+ " ["  + violation.getMessage() + "]");
        }
    }
}
