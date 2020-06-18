package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCategoryValidator
        implements ConstraintValidator<ValidCategory, String> {
    @Override
    public void initialize(ValidCategory constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return "alimente".equalsIgnoreCase(s);
    }
}
