import java.lang.annotation.*;
import java.lang.reflect.Field;

@Repeatable(Random.Randoms.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Random {

    int value();

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Randoms {
        Random[] value();
    }
}
