package main;

import model.Produs;
import org.hibernate.validator.internal.engine.ValidatorFactoryImpl;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorFactoryImpl;

import javax.validation.*;
import java.util.Set;

public class Exemplu1 {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Produs p = new Produs();

        p.setPret(15);
        p.setNume("Ciocolata");
        p.setCategorie("textile");

        Set<ConstraintViolation<Produs>> violations = validator.validate(p);

        if (violations.isEmpty()) {
            System.out.println("Produs valid");
        } else {
            violations.forEach(violation ->
                    System.out.println(
                            violation.getPropertyPath() + " " +
                            violation.getMessage()
                    )
            );
        }
    }
}
