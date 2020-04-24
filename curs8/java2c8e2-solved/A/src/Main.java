import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws NoSuchFieldException {
        Class<Produs> produsClass = Produs.class;

        Field pretField = produsClass.getDeclaredField("pret");

        Annotation[] annotations = pretField.getDeclaredAnnotations();

        Arrays.stream(annotations)
                .forEach(System.out::println);
    }
}
