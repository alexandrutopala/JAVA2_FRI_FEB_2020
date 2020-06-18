package validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = ValidCategoryValidator.class)
public @interface ValidCategory {

    String message() default "Categorie invalida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
