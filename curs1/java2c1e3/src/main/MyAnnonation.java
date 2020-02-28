package main;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD}) // specific pe element de limbaj pot pune adnotarea
public @interface MyAnnonation {
    String value();

    int other() default 0;

    double[] array() default {};

    // tipuri permise in adnotare: primitive, String, Class<?>
}
